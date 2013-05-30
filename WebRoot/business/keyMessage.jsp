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
<script type="text/javascript" src="js/shipment.js"></script>

<link rel="stylesheet" href="css/detail.css" type="text/css"></link>
</head>

<body>
	<div id="greybackground"></div>
	<div class="pageTitle">密码锁仓库管理—密码锁种类管理</div>
	<div class="pageColumn">
		<div class="add"></div>
		<s:property value="lastNum" />
		<s:form action="/keyMessage_addKey">
			<table class="table">
				<thead>
					<th width="" colspan="6">密码锁信息添加</th>
				</thead>
				<tbody>
					<tr>
						<td>锁种类</td>
						<td colspan="2"></td>
						<td>锁批号</td>
						<td colspan="2"></td>
					</tr>
					<tr>
						<td>程序</td>
						<td colspan="2"></td>
						<td>版本</td>
						<td colspan="2"></td>
					</tr>
					<tr>
						<td>省</td>
						<td colspan="2"></td>
						<td>市</td>
						<td colspan="2"></td>
					</tr>
					<tr>
						<td>锁数量</td>
						<td colspan="2"><s:textfield name="keyMessage.keyNum" theme="simple"/></td>
						<td>用户名</td>
						<td colspan="2"></td>
					</tr>
					<tr>
						<td>送锁方式</td>
						<td colspan="2"></td>
						<td>快递编号</td>
						<td colspan="2"></td>
					</tr>
					<tr>
						<td>邮编</td>
						<td colspan="2"></td>
						<td>递送日期</td>
						<td colspan="2"></td>
					</tr>
					<tr>
						<td colspan="6">备注</td>
					</tr>
				</tbody>
			</table>
			<s:hidden name="containId" value="%{containId}"/>
			<s:submit value="提交"/>
			<!-- <input type="submit" value="提交" class="button2" /> -->
		</s:form>
	</div>
</body>
</html>
