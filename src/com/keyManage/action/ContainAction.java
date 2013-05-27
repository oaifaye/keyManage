package com.keyManage.action;

import java.sql.Timestamp;
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
import com.keyManage.util.TimeSupport;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ContainAction extends ActionSupport {
	private Contain contain;
	private ContainService containService;
	private KindOfKeyService kindOfKeyService;
	private KeyAskService keyAskService;
	private List<KindOfKey> kindOfKeyList;
	private String containId;
	private int currentPage;
	private PaginationSupport paginationSupport;
	private String containDate;
	private List<KeyAsk> keyAskList;
	
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
			paginationSupport=containService.findByPage(params, currentPage, 2);
			//
			kindOfKeyList=kindOfKeyService.findListByParams(params);
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
		public String initShipment(){
			try {
				Map<String, Object> params= new HashMap<String, Object>();
				Manager manager = (Manager)ActionContext.getContext().getSession().get("manager");
				params.put("isDelete", "1");
				//params.put("managerByCreateBy.id", manager.getId());
				keyAskList=keyAskService.findListByParams(params);
				return "initShipment";
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
	
	
}
