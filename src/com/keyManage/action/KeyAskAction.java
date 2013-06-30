package com.keyManage.action;

import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
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

public class KeyAskAction extends ActionSupport {
	private KeyAskService keyAskService;
	private ContainService containService;
	private KindOfKeyService kindOfKeyService;
	private List<CountObject> countObjectList;//含有各种锁的剩余数量的对象
	private List<KeyAsk> keyAskList;
	private KeyAsk keyAsk;
	private KindOfKey kindOfKey;
	private String askDate;
	private String keyAskId;
	private int currentPage;
	private List<Contain> containList;
	private List<KindOfKey> kindOfKeyList;
	private String startDate;
	private String endDate;
	private String kindOfKeyId;
	private String isFinished;

	//==============================================锁申请用户===========================================================
	//初始化keyAsk.jsp
	public String initKeyAsk(){
		try {
			countObjectList = containService.findLastKey();
			return "initKeyAsk";
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	//保存锁申请
	public String addKeyAsk(){
		Manager managerSession = (Manager) ActionContext.getContext()
				.getSession().get("manager");
		try {
			/* 验证是否为锁领用者 */
			if (!managerSession.getRole().equals("2")) {
				HttpServletResponse response = ServletActionContext
						.getResponse();
				response.setCharacterEncoding("UTF-8");
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter();
				out.print("<script>alert('您没有此权限!!');location='business/index.jsp';</script>");
				return null;
			}
			if(!kindOfKey.getId().equals("")&&kindOfKey.getId()!=null){
				Integer lastNum = containService.findNumByKindOfKeyID(kindOfKey.getId());
				if(keyAsk.getAskNum()>lastNum){
				//请求锁数量超过数据库中的
					HttpServletResponse response=ServletActionContext.getResponse();
					response.setCharacterEncoding("UTF-8");
					response.setContentType("text/html; charset=utf-8");
					PrintWriter out=response.getWriter();
					out.print("<script>alert('申请数量不能超过"+lastNum+"!!');location='keyAsk_initKeyAsk';</script>");
					return null;
				}
				keyAsk.setKindOfKey(kindOfKey);
				keyAsk.setAskDate(TimeSupport.parseTime(askDate, "yyyy-MM-dd"));
				keyAsk.setIsFinished("2");
				keyAsk.setIsDelete("1");
				Manager manager = (Manager)ActionContext.getContext().getSession().get("manager");
				keyAsk.setManagerByCreateBy(manager);
				keyAsk.setCreateDate(new Timestamp(System.currentTimeMillis()));
				keyAskService.addKeyAsk(keyAsk);
			}
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	
	//初始化listKeyAsk.jsp（申请管理,自助查询）
	public String initListKeyAsk(){
		Map<String, Object> params = new HashMap<String, Object>();
		Map<String, Timestamp[]> betweenParams = new HashMap<String, Timestamp[]>();
		Manager manager = (Manager)ActionContext.getContext().getSession().get("manager");
		params.put("isDelete", "1");
		try {
			kindOfKeyList=kindOfKeyService.findListByParams(params);
			params.put("managerByCreateBy.id", manager.getId());
			/*执行查询*/
			if(kindOfKeyId!=null&&!kindOfKeyId.equals("")){
				params.put("kindOfKey.id",kindOfKeyId);
			}
			
			if(startDate!=null&&!startDate.equals("")&&
					endDate!=null&&!endDate.equals("")){
				//开始时间与结束时间转换格式
				Timestamp startTime = TimeSupport.parseTime(startDate, "yyyy-MM-dd");
				Timestamp endTime = TimeSupport.parseTime(endDate, "yyyy-MM-dd");
				Timestamp[] betweenValue={startTime,endTime};
				betweenParams.put("createDate", betweenValue);//填写时间
			}
			
			if(isFinished!=null&&!isFinished.equals("")){
				params.put("isFinished",isFinished);
			}
			
			params.put("managerByCreateBy.id", manager.getId());
			keyAskList=keyAskService.findListByParams(params, null, betweenParams, null);
			if(keyAskList!=null){
				for(KeyAsk keyAsk:keyAskList){
					Integer tokenNum = containService.findCountNumByKeyAskID(keyAsk.getId(), "1");
					if(tokenNum==null){
						tokenNum=0;
					}
					Integer usedNum=containService.findNumOfUsed(keyAsk.getId());
					keyAsk.setTokenNum(tokenNum);
					keyAsk.setUsedNum(usedNum);
				}
			}
			return "initListKeyAsk";
		} catch (Exception e) {
			return ERROR;
		}
		
	}
	
	//初始化锁的用途页面keyUse.jsp
	public String initKeyUse(){
		Manager managerSession = (Manager) ActionContext.getContext()
				.getSession().get("manager");
		try {
			/* 验证是否为锁领用者 */
			if (!managerSession.getRole().equals("2")) {
				HttpServletResponse response = ServletActionContext
						.getResponse();
				response.setCharacterEncoding("UTF-8");
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter();
				out.print("<script>alert('您没有此权限!!');location='business/index.jsp';</script>");
				return null;
			}
		keyAsk=keyAskService.findByPrimaryKey(keyAskId);
		containList=containService.findLastNumOfContain(keyAsk.getId());
		return "initKeyUse";
		} catch (Exception e) {
			return ERROR;
		}
	}
	
	
	//==========================================================================================================
	public KeyAskService getKeyAskService() {
		return keyAskService;
	}

	public void setKeyAskService(KeyAskService keyAskService) {
		this.keyAskService = keyAskService;
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

	public List<CountObject> getCountObjectList() {
		return countObjectList;
	}

	public void setCountObjectList(List<CountObject> countObjectList) {
		this.countObjectList = countObjectList;
	}

	public KeyAsk getKeyAsk() {
		return keyAsk;
	}

	public void setKeyAsk(KeyAsk keyAsk) {
		this.keyAsk = keyAsk;
	}

	public String getAskDate() {
		return askDate;
	}

	public void setAskDate(String askDate) {
		this.askDate = askDate;
	}

	public KindOfKey getKindOfKey() {
		return kindOfKey;
	}

	public void setKindOfKey(KindOfKey kindOfKey) {
		this.kindOfKey = kindOfKey;
	}

	public List<KeyAsk> getKeyAskList() {
		return keyAskList;
	}

	public void setKeyAskList(List<KeyAsk> keyAskList) {
		this.keyAskList = keyAskList;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
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

	public String getKeyAskId() {
		return keyAskId;
	}

	public void setKeyAskId(String keyAskId) {
		this.keyAskId = keyAskId;
	}

	public List<Contain> getContainList() {
		return containList;
	}

	public void setContainList(List<Contain> containList) {
		this.containList = containList;
	}

	public List<KindOfKey> getKindOfKeyList() {
		return kindOfKeyList;
	}

	public void setKindOfKeyList(List<KindOfKey> kindOfKeyList) {
		this.kindOfKeyList = kindOfKeyList;
	}

	public String getKindOfKeyId() {
		return kindOfKeyId;
	}

	public void setKindOfKeyId(String kindOfKeyId) {
		this.kindOfKeyId = kindOfKeyId;
	}

	public String getIsFinished() {
		return isFinished;
	}

	public void setIsFinished(String isFinished) {
		this.isFinished = isFinished;
	}
}
