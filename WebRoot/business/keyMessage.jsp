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
<script type="text/javascript" src="js/keyMessage.js"></script>
<script type='text/javascript' src='<%=basePath%>dwr/engine.js'></script> 
<script type='text/javascript' src='<%=basePath%>dwr/util.js'></script> 
<script type='text/javascript' src='<%=basePath%>dwr/interface/procedureVersionService.js'></script> 
<script type='text/javascript' src='<%=basePath%>dwr/interface/departmentService.js'></script> 

<link rel="stylesheet" href="css/detail.css" type="text/css"></link>
</head>

<body>
	<div id="greybackground"></div>
	<div class="pageTitle">密码锁仓库管理—密码锁种类管理</div>
	<div class="pageColumn">
		<div class="add"></div>
		<s:form id="add" action="/keyMessage_addKey" theme="simple">
			<table class="table">
				<thead>
					<th width="" colspan="6">密码锁信息添加</th>
				</thead>
				<tbody>
					<tr>
						<td class="tdLeft">锁种类</td>
						<td colspan="2"><s:property value="contain.kindOfKey.kindName"/></td>
						<td class="tdLeft">锁批号</td>
						<td colspan="2"><s:property value="contain.lotNumber"/></td>
					</tr>
					<tr>
						<td class="tdLeft">程序</td>
						<td colspan="2">
							<s:select id="procedureMessage" name="keyMessage.procedureMessage.id" list="procedureMessageList" listKey="id" listValue="procedureName" headerKey="" headerValue="--请选择--" cssClass="text1"></s:select>
						</td>
						<td class="tdLeft">版本</td>
						<td colspan="2">
							<select id="procedureVersion" name="keyMessage.procedureVersion.id" class="text1"></select>
						</td>
					</tr>
					<tr>
						<td class="tdLeft">单位</td>
						<td colspan="5">
							省级：<s:select id="province" name="departmentId" list="departmentList" listKey="id" listValue="departmentName" headerKey="" headerValue="--请选择--" theme="simple" cssClass="text"></s:select>
							市级：<select id="city" name="departmentId" class="text"></select>
							区级：<select id="district" name="departmentId" class="text"></select>
						</td>
					</tr>
					<tr>
						<td class="tdLeft">锁数量(不超过<s:property value="lastNum" />)</td>
						<td colspan="2"><s:textfield id="keyNum" name="keyMessage.keyNum" cssClass="text1" maxLength="6" /></td>
						<td class="tdLeft">用户名</td>
						<td colspan="2"><s:textfield  name="keyMessage.userName" cssClass="text1" maxlength="20"/></td>
					</tr>
					<tr>
						<td class="tdLeft">送锁方式</td>
						<td colspan="2">
							<s:select id="expressType" name="keyMessage.expressType.id" list="expressTypeList" listKey="id" listValue="expressTypeName" headerKey="" headerValue="--请选择--" cssClass="text1"></s:select>
						</td>
						<td class="tdLeft">
							快递编号
							<input type="checkbox" checked="checked" id="isExpress" name="isExpress"/>
						</td>
						<td colspan="2"><s:textfield id="expressCode" name="keyMessage.expressCode" cssClass="text1" maxlength="20"/></td>
					</tr>
					<tr>
						<td class="tdLeft">邮编</td>
						<td colspan="2"><s:textfield id="postCode" name="keyMessage.postCode" cssClass="text1" maxLength="6"/></td>
						<td class="tdLeft">送锁日期</td>
						<td colspan="2"><s:textfield id="expressDate" name="expressDate" onclick="new Calendar().show(this)" readonly="true" cssClass="text1"></s:textfield></td>
					</tr>
					<tr>
						<td class="tdLeft">锁用途</td>
						<td colspan="2">
							<s:select id="purpose" name="keyMessage.purpose.id" list="purposeList" listKey="id" listValue="remark" headerKey="" headerValue="--请选择--" cssClass="text1"></s:select>
						</td>
						<td class="tdLeft">用途描述：</td>
						<td colspan="2"><span id="purposeRemark"/></td>
					</tr>
					<tr>
						<td class="tdLeft">备注</td>
						<td colspan="5"><s:textarea id="remark" name="keyMessage.remark" cols="70" rows="2"/></td>
					</tr>
					<tr>
						<td colspan="6"><s:submit value="提交"/></td>
					</tr>
				</tbody>
			</table>
			<s:hidden name="containId" value="%{containId}"/>
			<s:hidden name="keyAskId" value="%{keyAskId}"/>
			
		</s:form>
	</div>
</body>
</html>
