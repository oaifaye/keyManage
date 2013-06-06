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

<title>登陆</title>
<link rel="stylesheet" href="css/login.css" type="text/css"></link>
</head>

<body>
	<s:form id="login" name="loginForm" action="manager_login" method="post"
		theme="simple">
		<div id="wrap">

			<div id="header"></div>
			<div class="logo">
				<img src="images/index-logo.png"></img>天房科技密码锁管理系统
			</div>
			<div id="content-wrap">
			
				<div class="space"></div>
				<div class="content">
					<div class="field">
						<label>账 户：</label>
						<s:textfield id="userName" name="userName" maxlength="15"
							cssClass="username" />
						<br />
					</div>
					<div class="field">
						<label>密 码：</label>
						<s:password id="password" name="password" maxlength="15"
							cssClass="password" />
						<br />
					</div>
					<div class="btn">
					<input name="" type="submit" class="login-btn" value="" />
				</div>
				</div>
				<s:actionerror cssStyle="font-weight:bold;color:red" />
				<s:fielderror value="loginBack.error"
					cssStyle="font-weight:bold;color:red" />
			</div>
		</div>
	</s:form>
</body>
</html>
