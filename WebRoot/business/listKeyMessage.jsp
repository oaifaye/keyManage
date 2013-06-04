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

<title>锁仓库</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/list.js"></script>
<script type="text/javascript" src="js/Calendar3.js"></script>
<script type="text/javascript" src="js/listKeyMessage.js"></script>

<link rel="stylesheet" href="css/list.css" type="text/css"></link>
</head>

<body>
	<div id="greybackground"></div>
	<div class="pageTitle">密码锁仓库管理—密码锁种类管理</div>
	<div class="pageColumn">
		<div class="add"></div>
		<s:form action="keyMessage_execListKeyMessage" theme="simple">
			程序：<s:select name="selectObject.procedureMessage" list="procedureMessageList" listKey="id" listValue="procedureName" headerKey="" headerValue="--请选择--" />
			单位：<s:select name="selectObject.department" list="departmentList" listKey="id" listValue="departmentName" headerKey="" headerValue="--请选择--"  />
			用途：<s:select name="selectObject.purpose" list="purposeList" listKey="id" listValue="name" headerKey="" headerValue="--请选择--"  />
			选择时间：<s:textfield name="selectObject.startDate" onclick="new Calendar().show(this)" readonly="true" cssClass="text1" />
			<s:textfield name="selectObject.endDate" onclick="new Calendar().show(this)" readonly="true" cssClass="text1" />
			<s:submit value="查询"/>
		</s:form>
			<table class="table">
				<thead>
					<th width="">密码锁种类</th>
					<th width="">单位</th>
					<th width="">数量</th>
					<th width="">所属程序</th>
					<th width="">程序版本</th>
					<th width="">送锁目的</th>
					<th width="">送锁日期</th>
				</thead>
				<tbody>
					<s:iterator value="keyMessageList">
						<tr>
							<td>
								<s:property value="kindOfKey.kindName"/>
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
								<s:property value="procedureVersions.versionName"/>
							</td>
							<td>
								<s:property value="purpose.name"/>
							</td>
							<td>
								<s:date name="expressDate" format="yyyy-mm-dd" />
							</td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
	</div>
</body>
</html>
