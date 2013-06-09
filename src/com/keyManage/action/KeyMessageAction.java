package com.keyManage.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.util.Assert;

import com.keyManage.bean.Contain;
import com.keyManage.bean.Department;
import com.keyManage.bean.ExpressType;
import com.keyManage.bean.KeyAsk;
import com.keyManage.bean.KeyMessage;
import com.keyManage.bean.Manager;
import com.keyManage.bean.ProcedureMessage;
import com.keyManage.bean.Purpose;
import com.keyManage.service.contain.ContainService;
import com.keyManage.service.department.DepartmentService;
import com.keyManage.service.expressType.ExpressTypeService;
import com.keyManage.service.keyAsk.KeyAskService;
import com.keyManage.service.keyMessage.KeyMessageService;
import com.keyManage.service.procedureMessage.ProcedureMessageService;
import com.keyManage.service.procedureVersion.ProcedureVersionService;
import com.keyManage.service.purpose.PurposeService;
import com.keyManage.util.SelectObject;
import com.keyManage.util.TimeSupport;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class KeyMessageAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private KeyMessageService keyMessageService;
	private ProcedureMessageService procedureMessageService;
	private ProcedureVersionService procedureVersionService;
	private DepartmentService departmentService;
	private ContainService containService;
	private ExpressTypeService expressTypeService;
	private PurposeService purposeService;
	private KeyAskService keyAskService;
	private KeyMessage keyMessage;
	private Contain contain;
	private String containId;
	private List<ProcedureMessage> procedureMessageList;
	private List<Department> departmentList;
	private List<ExpressType> expressTypeList;
	private List<Purpose> purposeList;
	private List<KeyMessage> keyMessageList;
	private String departmentId;
	private String expressDate;
	private String keyAskId;//保存后跳转keyAsk_initKeyUse.action时用
	private Integer lastNum;
	private SelectObject selectObject;//自定义查询的对象
	private String provinceId;
	private String cityId;
	private String districtId;
	//初始化添加锁用途页面
	public String initAddKey(){
		contain=containService.findByPrimaryKey(containId);
		Map<String, Object> params=new HashMap<String, Object>();
		//准备程序信息
		params.put("isDelete", "1");
		procedureMessageList=procedureMessageService.findListByParams(params);
		//准备送锁方式
		expressTypeList=expressTypeService.findListByParams(params);
		//准备领锁目的
		purposeList=purposeService.findListByParams(params);
		//准备省级单位
		params.put("level", 1);
		departmentList=departmentService.findListByParams(params);
		List<Contain> containList = containService.findLastNumOfContain(keyAskId);
		
		for(Contain contain:containList){
			if(containId.equals(contain.getId())){
				lastNum=contain.getKeyNum();
			}
		}
		
		/*修改时使用*/
		if(keyMessage!=null){
			/*总数需要加上当前锁在数据库中的数量*/
			lastNum=lastNum+keyMessage.getKeyNum();
			/*三级单位的id*/
			String[] ids = departmentService.findparentIdById(keyMessage.getDepartment().getId(), "1");
			if(ids.length>=1){
				provinceId=ids[0];
			}
			if(ids.length>=2){
				cityId=ids[1];
			}
			if(ids.length>=3){
				districtId=ids[2];
			}
			/*初始化送锁时间*/
			expressDate=TimeSupport.formateTime(keyMessage.getExpressDate(), "yyyy-MM-dd");
			
		}
		return "initAddKey";
	}
	
	//添加锁信息
	public String addKey(){
		KeyAsk keyAsk=keyAskService.findByPrimaryKey(keyAskId);
		Integer usedNum=0;
		try {
		//判断所填锁的数量是否小于库存
			List<Contain> containList = containService.findLastNumOfContain(keyAskId);
			for(Contain contain:containList){
				if(containId.equals(contain.getId())){
					lastNum=contain.getKeyNum();
				}
			}
			/*修改保存时*/
			if(keyMessage.getId()!=null&&!keyMessage.getId().equals("")){
				/*修改时校验总数需要加上当前锁在数据库中的数量*/
				lastNum=lastNum+keyMessage.getKeyNum();
			}
			if(keyMessage.getKeyNum()>lastNum){
				//请求锁数量超过数据库中的
				HttpServletResponse response=ServletActionContext.getResponse();
				response.setCharacterEncoding("UTF-8");
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out;
				out = response.getWriter();
				out.print("<script>alert('申请数量不能超过"+lastNum+"!!');location='keyMessage_initAddKey?containId="+containId+"&keyAskId="+keyAskId+"';</script>");
				return null;
			}
			Assert.notNull(keyMessage);
			//将前台传过来的多级单位的id只取最后一个id，存入keyMessage对象
			departmentId=departmentId.replace(" ", "");
			String[] departmentIdArray=departmentId.split(",");
			Department department = new Department();
			department.setId(departmentIdArray[departmentIdArray.length-1]);
			keyMessage.setDepartment(department);
			//添加时间
			keyMessage.setExpressDate(TimeSupport.parseTime(expressDate, "yyyy-MM-dd"));
			contain = containService.findByPrimaryKey(containId);
			keyMessage.setContain(contain);
			keyMessage.setIsDelete("1");
			Manager manager = (Manager)ActionContext.getContext().getSession().get("manager");
			keyMessage.setManagerByCreateBy(manager);
			keyMessage.setCreateDate(new Timestamp(System.currentTimeMillis()));
			/*修改保存时*/
			if(keyMessage.getId()!=null&&!keyMessage.getId().equals("")){
				keyMessageService.updateKeyMessage(keyMessage);
				return "updateKey";
			} 
			keyMessageService.addKeyMessage(keyMessage);
			
			//自动变为已完结
			usedNum=keyMessageService.findNumOfUsed(keyAskId);
			if(usedNum.equals(keyAsk.getAskNum())){
				keyAsk.setIsFinished("0");
				keyAskService.updateKeyAsk(keyAsk);
			}
			
			return "addKey";
		} catch (IOException e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	//初始化锁列表（listKeyMessage.jsp）
	public String initListKeyMessage(){
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("isDelete", "1");
		procedureMessageList=procedureMessageService.findListByParams(params);//初始化程序下拉菜单
		purposeList=purposeService.findListByParams(params);//初始化用途下拉菜单
		params.put("level", 1);
		departmentList=departmentService.findListByParams(params);//初始化省级单位下拉菜单
		return "initListKeyMessage";
	}
	
	//执行锁列表自助查询
	public String execListKeyMessage(){
		Map<String, Object> params = new HashMap<String, Object>();
		Map<String, Timestamp[]> betweenParams=new HashMap<String, Timestamp[]>();
		Map<String, String[]> inParams=new HashMap<String, String[]>();
		//查询条件临时存入一个keyMessage对象
		if(selectObject!=null){
		if(selectObject.getProcedureMessage()!=null&&!selectObject.getProcedureMessage().equals("")){
			params.put("procedureMessage.id", selectObject.getProcedureMessage());//程序
		}
		if(selectObject.getPurpose()!=null&&!selectObject.getPurpose().equals("")){
			params.put("purpose.id", selectObject.getPurpose());//用途
		}
		
		Manager manager = (Manager)ActionContext.getContext().getSession().get("manager");
		/*为锁用户时*/
		if(manager.getRole().equals("2")){
			params.put("managerByCreateBy.id", manager.getId());//填写人为当前用户
		}else{
		/*为管理员或仓库保管员时*/	
			
		}
		
		if(selectObject.getDepartment()!=null&&!selectObject.getDepartment().equals("")){
			String[] departmentIds = departmentService.findListByParentId(selectObject.getDepartment(), "1");
			inParams.put("department.id", departmentIds);//单位
		}
		
		if(selectObject.getStartDate()!=null&&!selectObject.getStartDate().equals("")&&
				selectObject.getEndDate()!=null&&!selectObject.getEndDate().equals("")){
			//开始时间与结束时间转换格式
			Timestamp startTime = TimeSupport.parseTime(selectObject.getStartDate(), "yyyy-MM-dd");
			Timestamp endTime = TimeSupport.parseTime(selectObject.getEndDate(), "yyyy-MM-dd");
			Timestamp[] betweenValue={startTime,endTime};
			betweenParams.put("createDate", betweenValue);//填写时间
		}
		}
		keyMessageList=keyMessageService.findListByParams(params, null,betweenParams,inParams);
		return "execListKeyMessage";
	}
	
	public String editkeyMessage(){
		keyMessage=keyMessageService.findByPrimaryKey(keyMessage.getId());
		return "editkeyMessage";
	}
	
	public KeyMessageService getKeyMessageService() {
		return keyMessageService;
	}
	public void setKeyMessageService(KeyMessageService keyMessageService) {
		this.keyMessageService = keyMessageService;
	}
	public KeyMessage getKeyMessage() {
		return keyMessage;
	}
	public void setKeyMessage(KeyMessage keyMessage) {
		this.keyMessage = keyMessage;
	}
	public String getContainId() {
		return containId;
	}
	public void setContainId(String containId) {
		this.containId = containId;
	}
	public ContainService getContainService() {
		return containService;
	}
	public void setContainService(ContainService containService) {
		this.containService = containService;
	}

	public Contain getContain() {
		return contain;
	}

	public void setContain(Contain contain) {
		this.contain = contain;
	}

	public ProcedureMessageService getProcedureMessageService() {
		return procedureMessageService;
	}

	public void setProcedureMessageService(
			ProcedureMessageService procedureMessageService) {
		this.procedureMessageService = procedureMessageService;
	}

	public ProcedureVersionService getProcedureVersionService() {
		return procedureVersionService;
	}

	public void setProcedureVersionService(
			ProcedureVersionService procedureVersionService) {
		this.procedureVersionService = procedureVersionService;
	}

	public List<ProcedureMessage> getProcedureMessageList() {
		return procedureMessageList;
	}

	public void setProcedureMessageList(List<ProcedureMessage> procedureMessageList) {
		this.procedureMessageList = procedureMessageList;
	}

	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public List<Department> getDepartmentList() {
		return departmentList;
	}

	public void setDepartmentList(List<Department> departmentList) {
		this.departmentList = departmentList;
	}

	public ExpressTypeService getExpressTypeService() {
		return expressTypeService;
	}

	public void setExpressTypeService(ExpressTypeService expressTypeService) {
		this.expressTypeService = expressTypeService;
	}

	public List<ExpressType> getExpressTypeList() {
		return expressTypeList;
	}

	public void setExpressTypeList(List<ExpressType> expressTypeList) {
		this.expressTypeList = expressTypeList;
	}

	public PurposeService getPurposeService() {
		return purposeService;
	}

	public void setPurposeService(PurposeService purposeService) {
		this.purposeService = purposeService;
	}

	public List<Purpose> getPurposeList() {
		return purposeList;
	}

	public void setPurposeList(List<Purpose> purposeList) {
		this.purposeList = purposeList;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getExpressDate() {
		return expressDate;
	}

	public void setExpressDate(String expressDate) {
		this.expressDate = expressDate;
	}

	public String getKeyAskId() {
		return keyAskId;
	}

	public void setKeyAskId(String keyAskId) {
		this.keyAskId = keyAskId;
	}

	public Integer getLastNum() {
		return lastNum;
	}

	public void setLastNum(Integer lastNum) {
		this.lastNum = lastNum;
	}

	public SelectObject getSelectObject() {
		return selectObject;
	}

	public void setSelectObject(SelectObject selectObject) {
		this.selectObject = selectObject;
	}

	public List<KeyMessage> getKeyMessageList() {
		return keyMessageList;
	}

	public void setKeyMessageList(List<KeyMessage> keyMessageList) {
		this.keyMessageList = keyMessageList;
	}

	public String getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getDistrictId() {
		return districtId;
	}

	public void setDistrictId(String districtId) {
		this.districtId = districtId;
	}

	public KeyAskService getKeyAskService() {
		return keyAskService;
	}

	public void setKeyAskService(KeyAskService keyAskService) {
		this.keyAskService = keyAskService;
	}

	
}
