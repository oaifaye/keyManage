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
<link rel="stylesheet" href="css/style.css" type="text/css"></link>
<script type="text/javascript" src="js/index.js"></script>
</head>

<body style="overflow-y:hidden">
	<div id="wrap">
		<div id="header">
			<div class="logo fleft"></div>
			<a class="logout fright" href="<%=basePath%>logout.jsp"> </a>
			<div class="clear"></div>
			<div class="subnav">
				<div class="subnavLeft fleft"></div>
				<div class="fleft"></div>
				<div class="subnavRight fright"></div>
			</div>
		</div>
		<!--#header -->
		<div id="content">
			<div class="space"></div>
			<div class="menu">
				<ul>
					<li class="subMenuTitle">功能菜单</li>
				<!-- 管理员start -->
					<s:if test='#session.manager.role=="0"'>
						<li class="subMenu"><a href="#">程序管理</a>
						<ul>
							<li><a href="<%=basePath%>procedureMessage_init" target="right">程序管理</a></li>
							<li><a href="<%=basePath%>keyAsk_initListKeyAsk" target="right">程序版本管理</a>
							</li>
						</ul>
					</li>
					</s:if>
				<!-- 管理员end -->
				<!-- 锁管理员start -->
					<s:if test='#session.manager.role=="1"'>
					<li class="subMenu"><a href="#">密码锁仓库管理</a>
						<ul>
							<li><a href="<%=basePath%>kindOfKey_init" target="right">锁种类</a></li>
							<li><a href="<%=basePath%>contain_init" target="right">锁入库</a></li>
							<li><a href="<%=basePath%>contain_initShipment" target="right">锁出库</a></li>
						</ul>
					</li>
					</s:if>
				<!-- 锁管理员end -->
				<!-- 锁领用者start -->
					<s:if test='#session.manager.role=="2"'>
						<li class="subMenu"><a href="#">密码锁申请</a>
						<ul>
							<li><a href="<%=basePath%>keyAsk_initKeyAsk" target="right">密码锁申请</a></li>
							<li><a href="<%=basePath%>keyAsk_initListKeyAsk" target="right">申请管理</a>
							</li>
						</ul>
					</li>
					</s:if>
				<!-- 锁领用者end -->
				
				</ul>
			</div>
			<div class="sidebar fleft"></div>
			<div class="right">
			<div class="page">
					<iframe class="rightMain" name="right" frameborder="0" src="main.html"></iframe>
			</div>
			</div>
		</div>
		<!--#content -->
		<div class="clear"></div>
		<div id="footer">CopyRight &copy; 2012-2014 http://www.tftech.cn</div>
		<!--#footer -->


	</div>
	<!--#wrap -->
</body>
</html>
