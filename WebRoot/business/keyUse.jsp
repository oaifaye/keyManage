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

<link rel="stylesheet" href="css/list.css" type="text/css"></link>
</head>

<body>
	<div class="center">
	<div id="greybackground"></div>
	<%@ include file="../include/top.jsp" %>
	<%@ include file="../include/left.jsp" %>
	<div class="main">
	<div class="pageTitle">密码锁仓库管理—密码锁种类管理</div>
	<div class="pageColumn">
		<div class="add"></div>
			<table class="table">
				<thead>
					<th width="">密码锁批号</th>
					<th width="">空闲数量</th>
					<th width="">获批时间</th>
					<th width="">操作</th>
				</thead>
				<tbody>
					<s:iterator value="containList">
						<tr>
							<td><s:property value="lotNumber" />
							</td>
							<td><s:property value="keyNum" />
							</td>
							<td><s:date name="createDate" format="yyyy-MM-dd hh:mm:ss"/>
							</td>
							<td>
								<s:a action="keyMessage_initAddKey" >
									<s:param name="containId" value="id"></s:param>
									<s:param name="keyAskId" value="%{keyAskId}"></s:param>
									填写用途
								</s:a>
							</td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
	</div>
	</div>
	<%@ include file="../include/foot.jsp" %>
	</div>
</body>
</html>
