package com.keyManage.action;

import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.dao.DataAccessException;
import org.springframework.util.Assert;

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
	private List<Contain> containList;
	private Integer lastNum ;
	private Integer totalNum;
	private String saveOrTake;
	private String startDate;
	private String endDate;
	
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
			paginationSupport=containService.findByPage(params, currentPage, 10);
			return "initContain";
		} catch (DataAccessException e) {
			return ERROR;
		}
	}
	
	public String add(){
		Map<String, Object> params=new HashMap<String, Object>();
		try {
			
			contain.setContainDate(TimeSupport.parseTime(containDate, "yyyy-MM-dd"));
			if(contain.getId()==null||contain.getId().equals("")){
			//新建保存
				/*验证批号是否重复*/
				params.put("lotNumber", contain.getLotNumber());
				List<Contain> containTest = containService.findListByParams(params);
				if(containTest!=null){
					HttpServletResponse response=ServletActionContext.getResponse();
					response.setCharacterEncoding("UTF-8");
					response.setContentType("text/html; charset=utf-8");
					PrintWriter out = response.getWriter();
					out.print("<script>alert('此锁批号已经存在，请更名!!');location='contain_init';</script>");
					return null;
				}
				Manager manager = (Manager)ActionContext.getContext().getSession().get("manager");
				Assert.notNull(contain);
				contain.setIsDelete("1");
				contain.setSaveOrTake("0");
				contain.setManagerByCreateBy(manager);
				contain.setCreateDate(new Timestamp(System.currentTimeMillis()));
				containService.addContain(contain);
			}else{
			//修改保存
				/*验证批号是否重复*/
				params.put("lotNumber", contain.getLotNumber());
				List<Contain> containTest = containService.findListByParams(params);
				if(containTest!=null)
				if(!containTest.get(0).getId().equals(contain.getId())||containTest.size()>1){
					HttpServletResponse response=ServletActionContext.getResponse();
					response.setCharacterEncoding("UTF-8");
					response.setContentType("text/html; charset=utf-8");
					PrintWriter out = response.getWriter();
					out.print("<script>alert('此锁批号已经存在，请更名!!');location='contain_init';</script>");
					return null;
				}
				containService.update(contain);
			}
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	//初始化shipment.jsp(锁出库)
		@SuppressWarnings("unchecked")
		public String initShipment(){
			if(currentPage<=1){
				currentPage=1;
			}
			try {
				paginationSupport=keyAskService.findKeyAskByPage(currentPage, 12);
				List<KeyAsk> keyAskList = (List<KeyAsk>)paginationSupport.getItems();
				for(KeyAsk keyAsk:keyAskList){
					Integer tokenNum = containService.findCountNumByKeyAskID(keyAsk.getId(), "1");
					if(tokenNum==null){
						tokenNum=0;
					}
					Integer usedNum=containService.findNumOfUsed(keyAsk.getId());
					keyAsk.setTokenNum(tokenNum);
					keyAsk.setUsedNum(usedNum);
				}
				return "initShipment";
			} catch (Exception e) {
				return ERROR;
			}
		}
		
	//根据所得种类的id初始化editShipment.jsp（编辑锁出库）
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
	
	//锁出库处理
	public String shipment(){
		
		try {
		//向Contain中插入出库信息
			List<Contain> containList=new ArrayList<Contain>();
			String[] shipmentArray=shipmentNum.split(",");
			String[] lotNumberArray=lotNumber.split(",");
			//判断所填锁的数量是否小于库存
			keyAsk=keyAskService.findByPrimaryKey(keyAsk.getId());
			countObjectList=containService.findLastKey(keyAsk.getKindOfKey().getId());
			Integer tokenNum = containService.findCountNumByKeyAskID(keyAsk.getId(), "1");
			if(tokenNum!=null){
				lastNum=keyAsk.getAskNum()-tokenNum;
			}else{
				lastNum=keyAsk.getAskNum();
			}
				if(totalNum>lastNum){
					HttpServletResponse response=ServletActionContext.getResponse();
					response.setCharacterEncoding("UTF-8");
					response.setContentType("text/html; charset=utf-8");
					PrintWriter out=response.getWriter();
					out.print("<script>alert('锁的数量数量不能超过"+lastNum+"!!');location='contain_initEditShipment?keyAskId="+keyAsk.getId()+"';</script>");
					return null;
				}
			//计算containList，以便批量插入
			
			for(int i=0;i<shipmentArray.length;i++){
				if(!shipmentArray[i].replace(" ", "").equals("")&&shipmentArray[i]!=null){
					contain=new Contain();
					contain.setKeyAsk(keyAsk);
					contain.setKindOfKey(kindOfKey);
					contain.setSaveOrTake("1");
					contain.setIsDelete("1");
					contain.setContainDate(new Timestamp(System.currentTimeMillis()));
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
			tokenNum = containService.findCountNumByKeyAskID(keyAsk.getId(), "1");
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
	
	/**初始化查询统计——出入库情况*/
	public String initListConatin(){
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("isDelete", "1");
		//初始化锁的种类
		kindOfKeyList=kindOfKeyService.findListByParams(params);
		return "initListContain";
	}
	
	/**执行查询统计——出入库情况*/
	public String execListContain(){
		Map<String, Object> params=new HashMap<String, Object>();
		Map<String, Timestamp[]> betweenParams=new HashMap<String, Timestamp[]>();
		Timestamp startTimestamp = null;
		Timestamp endTimestamp = null;
		params.put("isDelete", "1");
		if(kindOfKeyId!=null&&!kindOfKeyId.equals("")){
			params.put("kindOfKey.id",kindOfKeyId);
		}
		if(saveOrTake!=null&&!saveOrTake.equals("")){
			params.put("saveOrTake",saveOrTake);
		}
		if(startDate!=null&&endDate!=null&&!startDate.equals("")&&!endDate.equals("")){
			//开始时间与结束时间转换格式
			startTimestamp = TimeSupport.parseTime(startDate, "yyyy-MM-dd");
			endTimestamp = TimeSupport.parseTime(endDate, "yyyy-MM-dd");
			Timestamp[] betweenValue={startTimestamp,endTimestamp};
			betweenParams.put("createDate", betweenValue);//填写时间
		}
		containList=containService.findListByParams(params, null, betweenParams, null);
		return "execListContain";
	}
	
//============================================================================================================================
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

	public Integer getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
	}

	public List<Contain> getContainList() {
		return containList;
	}

	public void setContainList(List<Contain> containList) {
		this.containList = containList;
	}

	public String getSaveOrTake() {
		return saveOrTake;
	}

	public void setSaveOrTake(String saveOrTake) {
		this.saveOrTake = saveOrTake;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}


}
