<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<base href="<%=basePath%>" />

<title>天房科技密码锁管理系统</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/list.js"></script>
<script type="text/javascript" src="js/Calendar3.js"></script>
<script type="text/javascript" src="js/listKeyMessage.js"></script>

<link rel="stylesheet" href="css/list.css" type="text/css"></link>
</head>

<body>
	<div id="greybackground"></div>
	<div class="center">
	<%@ include file="../include/top.jsp" %>
	<%@ include file="../include/left.jsp" %>
	<div class="main">
	<div class="pageTitle">密码锁使用管理—用途管理</div>
	<div class="pageColumn">
		<s:form id="selectSubmit" action="keyMessage_execListKeyMessage" theme="simple">
			程序：<s:select name="selectObject.procedureMessage" list="procedureMessageList" listKey="id" listValue="procedureName" headerKey="" headerValue="--请选择--" ></s:select>&nbsp;&nbsp;&nbsp;
			单位：<s:select name="selectObject.department" list="departmentList" listKey="id" listValue="departmentName" headerKey="" headerValue="--请选择--" ></s:select>&nbsp;&nbsp;&nbsp;
			用途：<s:select name="selectObject.purpose" list="purposeList" listKey="id" listValue="name" headerKey="" headerValue="--请选择--" ></s:select>&nbsp;&nbsp;&nbsp;
			选择时间范围：<s:textfield id="startDate" name="selectObject.startDate" onclick="new Calendar().show(this)" readonly="true" ></s:textfield> &nbsp;—
						<s:textfield id="endDate" name="selectObject.endDate" onclick="new Calendar().show(this)" readonly="true" />&nbsp;&nbsp;&nbsp;
			<s:reset value="重置" cssClass="button2" />&nbsp;&nbsp;&nbsp;
			<input type="submit" value="查询" class="button2" />
		</s:form>
		<div class="resultList2">
			<table class="table">
				<thead>
					<th width="">密码锁种类</th>
					<th width="">单位</th>
					<th width="">数量</th>
					<th width="">所属程序</th>
					<th width="">送锁目的</th>
					<th width="">送锁日期</th>
					<th width="">送锁方式</th>
					<th width="">快递编号</th>
					<th width="">操作</th>
				</thead>
				<tbody>
					<s:iterator value="keyMessageList">
						<tr>
							<td>
								<s:property value="contain.kindOfKey.kindName"/>
							</td>
							<td>
								<s:property value="department.departmentName"/>
							</td>
							<td>
								<s:property value="keyNum"/>
							</td>
							<td>
								<s:property value="procedureMessage.procedureName"/>
							</td>
							<td>
								<s:property value="purpose.name"/>
							</td>
							<td>
								<s:date name="expressDate" format="yyyy-MM-dd" />
							</td>
							<td>
								<s:property value="expressType.expressTypeName"/>
							</td>
							<td>
								<s:property value="postCode"/>
							</td>
							<td>
								<s:if test='#session.manager.role=="2"'>
									<s:a action="keyMessage_editkeyMessage" >
										<s:param name="keyMessage.id" value="id"></s:param>
										<s:param name="containId" value="contain.id"></s:param>
										<s:param name="keyAskId" value="contain.keyAsk.id"></s:param>
										
										修改
									</s:a>
								</s:if>
								<s:else>
									<s:a action="keyMessage_checkKeyMessage" >
										<s:param name="keyMessage.id" value="id"></s:param>
										<s:param name="containId" value="contain.id"></s:param>
										<s:param name="keyAskId" value="contain.keyAsk.id"></s:param>
										查看
									</s:a>
								</s:else>
							</td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
		</div>
	</div>
	</div>
	<%@ include file="../include/foot.jsp" %>
	</div>
</body>
</html>
