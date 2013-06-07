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
<link rel="stylesheet" href="css/list.css" type="text/css"></link>
<script type="text/javascript" src="js/keyAsk.js"></script>
<script type="text/javascript" src="js/Calendar3.js"></script>
<script type='text/javascript' src='<%=basePath%>dwr/engine.js'></script>
<script type='text/javascript' src='<%=basePath%>dwr/util.js'></script>
<script type='text/javascript'
	src='<%=basePath%>dwr/interface/containService.js'></script>
</head>

<body>
	<div class="center">
	<div id="greybackground"></div>
	<%@ include file="../include/top.jsp" %>
	<%@ include file="../include/left.jsp" %>
	<div class="main">
		<div class="pageTitle">密码锁使用管理—密码锁申请</div>
		<div class="pageColumn">
			<div class="add"></div>
			<table class="table">
				<thead>
					<th width="">密码锁名称</th>
					<th width="40%">备注</th>
					<th width="">剩余锁数量</th>
					<th width="20%">操作</th>
				</thead>
				<tbody>
					<s:iterator value="CountObjectList">
						<tr>
							<td><div id="countObjectName">
									<s:property value="name" />
								</div></td>
							<td><s:property value="remark" /></td>
							<td><div id="countObjectNum">
									<s:property value="num" />
								</div></td>
							<td><a class="askKey">申请取锁</a> <input type="hidden" id="id"
								value="${item}" /></td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
		</div>
		<div id="askKeySubmit">
			<s:form id="addKeyAsk" action="keyAsk_addKeyAsk" theme="simple"
				name="addKeyAsk">
				<table class="table1">
					<tr>
						<td width="24%">密码锁名称</td>
						<td><span id="keyName" class="text"></span>
						</td>
					</tr>
					<tr>
						<td>剩余锁数量</td>
						<td><span id="num" class="text"></span>
						</td>
					</tr>
					<tr>
						<td>申请数量</td>
						<td><s:textfield id="askNum" name="keyAsk.askNum"
								cssClass="text" maxLength="6"></s:textfield></td>
					</tr>
					<tr>
						<td>需求时间</td>
						<td><s:textfield id="askDate" name="askDate"
								onclick="new Calendar().show(this)" readonly="true"
								cssClass="text"></s:textfield></td>
					</tr>
					<tr>
						<td>需求备注</td>
						<td><s:textfield id="askRemark" name="keyAsk.askRemark"
								cssClass="text" maxLength="85"></s:textfield></td>
					</tr>
					<tr>
						<td colspan="2"><input type="hidden" id="kindOfKeyId"
							name="kindOfKey.id" /> <input id="submit" type="submit"
							value="提交" class="button2" /> <input id="close" type="button"
							value="关闭" class="button2" /></td>
					</tr>
				</table>
			</s:form>
		</div>
	</div>
	<%@ include file="../include/foot.jsp" %>
	</div>
</body>
</html>
