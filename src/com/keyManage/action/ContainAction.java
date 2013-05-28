package com.keyManage.action;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.util.Assert;

import com.keyManage.base.DaoException;
import com.keyManage.base.PaginationSupport;
import com.keyManage.bean.Contain;
import com.keyManage.bean.KeyAsk;
import com.keyManage.bean.KindOfKey;
import com.keyManage.bean.Manager;
import com.keyManage.service.contain.ContainService;
import com.keyManage.service.keyAsk.KeyAskService;
import com.keyManage.service.kindOfKey.KindOfKeyService;
import com.keyManage.util.CountObject;
import com.keyManage.util.TimeSupport;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ContainAction extends ActionSupport {
	private Contain contain;
	private KeyAsk keyAsk;
	private KindOfKey kindOfKey;
	private ContainService containService;
	private KindOfKeyService kindOfKeyService;
	private KeyAskService keyAskService;
	private List<KindOfKey> kindOfKeyList;
	private String containId;
	private String keyAskId;
	private String lotNumber;
	private String shipmentNum;
	private String containDate;
	private String kindOfKeyId;
	private int currentPage;
	private PaginationSupport paginationSupport;
	private List<KeyAsk> keyAskList;
	private List<CountObject> countObjectList;//含有各种锁的剩余数量的对象
	private Integer lastNum ;
	
	//初始化
	public String init(){
		if(containId!=null){
			contain=containService.findByPrimaryKey(containId);
			containDate=TimeSupport.formateTime(contain.getContainDate(), "yyyy-MM-dd");
		}
		if(currentPage<=1){
			currentPage=1;
		}
		try {
			Map<String, Object> params=new HashMap<String, Object>();
			params.put("isDelete", "1");
			//初始化锁的种类
			kindOfKeyList=kindOfKeyService.findListByParams(params);
			params.put("saveOrTake", "0");
			paginationSupport=containService.findByPage(params, currentPage, 2);
			return "initContain";
		} catch (DataAccessException e) {
			return ERROR;
		}
	}
	
	public String add(){
		try {
			contain.setContainDate(TimeSupport.parseTime(containDate, "yyyy-MM-dd"));
			if(contain.getId()==null||contain.getId().equals("")){
				//新建保存
				Manager manager = (Manager)ActionContext.getContext().getSession().get("manager");
				Assert.notNull(contain);
				contain.setIsDelete("1");
				contain.setSaveOrTake("0");
				contain.setManagerByCreateBy(manager);
				contain.setCreateDate(new Timestamp(System.currentTimeMillis()));
				containService.addContain(contain);
			}else{
			//修改保存
				containService.update(contain);
			}
			return SUCCESS;
		} catch (DataAccessException e) {
			return ERROR;
		}
	}
	
	//初始化shipment.jsp
		@SuppressWarnings("unchecked")
		public String initShipment(){
			if(currentPage<=1){
				currentPage=1;
			}
			try {
				paginationSupport=keyAskService.findKeyAskByPage(currentPage, 2);
				List<KeyAsk> keyAskList = (List<KeyAsk>)paginationSupport.getItems();
				for(KeyAsk keyAsk:keyAskList){
					Integer tokenNum = containService.findCountNumByKeyAskID(keyAsk.getId(), "1");
					if(tokenNum==null){
						tokenNum=0;
					}
					keyAsk.setLastNum(tokenNum);
				}
				return "initShipment";
			} catch (Exception e) {
				return ERROR;
			}
		}
		
	//根据所得种类的id初始化editShipment.jsp
	public String initEditShipment(){
		try {
			keyAsk=keyAskService.findByPrimaryKey(keyAskId);
			
			countObjectList=containService.findLastKey(keyAsk.getKindOfKey().getId());
			Integer tokenNum = containService.findCountNumByKeyAskID(keyAskId, "1");
			if(tokenNum!=null){
				lastNum=keyAsk.getAskNum()-tokenNum;
			}else{
				lastNum=keyAsk.getAskNum();
			}
			return "initEditShipment";
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	public String shipment(){
		try {
		//向Contain中插入出库信息
			List<Contain> containList=new ArrayList<Contain>();
			String[] shipmentArray=shipmentNum.split(",");
			String[] lotNumberArray=lotNumber.split(",");
			//计算containList，以便批量插入
			
			for(int i=0;i<shipmentArray.length;i++){
				if(!shipmentArray[i].replace(" ", "").equals("")&&shipmentArray[i]!=null){
					contain=new Contain();
					contain.setKeyAsk(keyAsk);
					contain.setKindOfKey(kindOfKey);
					contain.setSaveOrTake("1");
					contain.setIsDelete("1");
					Manager manager = (Manager)ActionContext.getContext().getSession().get("manager");
					contain.setManagerByCreateBy(manager);
					contain.setCreateDate(new Timestamp(System.currentTimeMillis()));
					//插入所数量与批号
					Integer keyNum = Integer.valueOf(shipmentArray[i].trim());
					String lotNumber=lotNumberArray[i].trim();
					contain.setKeyNum(keyNum);
					contain.setLotNumber(lotNumber);
					containList.add(contain);
				}
			}
			if(containList.size()!=0){
				containService.addAllContain(containList);
			}
		//修改KeyAsk中信息
			keyAsk=keyAskService.findByPrimaryKey(keyAsk.getId());
			keyAsk.setAnswerDate(new Timestamp(System.currentTimeMillis()));
			Integer tokenNum=containService.findCountNumByKeyAskID(keyAsk.getId(), "1");
			//自动完结
			if(tokenNum.equals(keyAsk.getAskNum())){
				keyAsk.setIsFinished("0");
			}
			keyAskService.updateKeyAsk(keyAsk);
			
			return "shipmentSuccess";
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	
	public Contain getContain() {
		return contain;
	}

	public void setContain(Contain contain) {
		this.contain = contain;
	}

	public ContainService getContainService() {
		return containService;
	}

	public void setContainService(ContainService containService) {
		this.containService = containService;
	}

	public KindOfKeyService getKindOfKeyService() {
		return kindOfKeyService;
	}

	public void setKindOfKeyService(KindOfKeyService kindOfKeyService) {
		this.kindOfKeyService = kindOfKeyService;
	}

	public List<KindOfKey> getKindOfKeyList() {
		return kindOfKeyList;
	}

	public void setKindOfKeyList(List<KindOfKey> kindOfKeyList) {
		this.kindOfKeyList = kindOfKeyList;
	}

	public String getContainId() {
		return containId;
	}

	public void setContainId(String containId) {
		this.containId = containId;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public PaginationSupport getPaginationSupport() {
		return paginationSupport;
	}

	public void setPaginationSupport(PaginationSupport paginationSupport) {
		this.paginationSupport = paginationSupport;
	}

	public String getContainDate() {
		return containDate;
	}

	public void setContainDate(String containDate) {
		this.containDate = containDate;
	}

	public KeyAskService getKeyAskService() {
		return keyAskService;
	}

	public void setKeyAskService(KeyAskService keyAskService) {
		this.keyAskService = keyAskService;
	}

	public List<KeyAsk> getKeyAskList() {
		return keyAskList;
	}

	public void setKeyAskList(List<KeyAsk> keyAskList) {
		this.keyAskList = keyAskList;
	}

	public String getKeyAskId() {
		return keyAskId;
	}

	public void setKeyAskId(String keyAskId) {
		this.keyAskId = keyAskId;
	}

	public KeyAsk getKeyAsk() {
		return keyAsk;
	}

	public void setKeyAsk(KeyAsk keyAsk) {
		this.keyAsk = keyAsk;
	}

	public List<CountObject> getCountObjectList() {
		return countObjectList;
	}

	public void setCountObjectList(List<CountObject> countObjectList) {
		this.countObjectList = countObjectList;
	}

	public String getLotNumber() {
		return lotNumber;
	}

	public void setLotNumber(String lotNumber) {
		this.lotNumber = lotNumber;
	}

	public String getShipmentNum() {
		return shipmentNum;
	}

	public void setShipmentNum(String shipmentNum) {
		this.shipmentNum = shipmentNum;
	}

	public String getKindOfKeyId() {
		return kindOfKeyId;
	}

	public void setKindOfKeyId(String kindOfKeyId) {
		this.kindOfKeyId = kindOfKeyId;
	}

	public KindOfKey getKindOfKey() {
		return kindOfKey;
	}

	public void setKindOfKey(KindOfKey kindOfKey) {
		this.kindOfKey = kindOfKey;
	}

	public Integer getLastNum() {
		return lastNum;
	}

	public void setLastNum(Integer lastNum) {
		this.lastNum = lastNum;
	}


}
