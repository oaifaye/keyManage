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
<link rel="stylesheet" href="css/list.css" type="text/css"></link>
<script type="text/javascript" src="js/keyAsk.js"></script>
<script type="text/javascript" src="js/Calendar3.js"></script>
</head>

<body>
	<div id="greybackground"></div>
	<div class="pageTitle">密码锁仓库管理—密码锁种类管理</div>
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
							<td><s:property value="name" />
							</td>
							<td><s:property value="remark" />
							</td>
							<td><s:property value="num" />
							</td>
							<td>
								<a id="askKey">申请取锁</a>
								<input type="hidden" id="id" value="${item}" />
							</td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
	</div>
	<div id="askKeySubmit">
		<form action="keyAsk_addKeyAsk">
			密码锁名称：<a id="keyName"></a>
			申请数量：<s:textfield id="askNum" name="keyAsk.askNum" cssClass="text"></s:textfield>
			需求时间：<s:textfield id="askDate" name="askDate" onclick="new Calendar().show(this)" readonly="true" cssClass="text"></s:textfield>
			需求备注：<s:textfield id="askRemark" name="keyAsk.askRemark" cssClass="text"></s:textfield>
			<input type="hidden" id="kindOfKeyId" name="kindOfKey.id" />
			<input type="submit" value="提交" class="button2" />
		</form>
	</div>
</body>
</html>
