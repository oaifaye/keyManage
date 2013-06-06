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
</head>

<body>
	<div id="greybackground"></div>
	<div class="center">
		<%@ include file="../include/top.jsp"%>
		<%@ include file="../include/left.jsp"%>
		<div class="main">
			<div class="pageColumn">
				<img class="index_bg" src="images/index_bg.jpg"></img>
			</div>
		</div>
		<%@ include file="../include/foot.jsp" %>
	</div>
</body>
</html>
