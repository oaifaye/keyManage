<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>

  <link rel="stylesheet" href="css/style.css" type="text/css"></link></head>
  
  <body>
   <div id="header">
			<div class="logo fleft">天房科技密码锁管理系统</div>
			<a class="logout fright" href="logout.jsp"> </a>
			<div class="clear"></div>
			<div class="subnav">
				<div class="subnavLeft fleft"></div>
				<div class="fleft"></div>
				<div class="subnavRight fright"></div>
				<div class="userMessage">
					当前用户：<s:property value="#session.manager.name"/>
					(<s:property value="#session.manager.userName"/>)&nbsp;&nbsp;
					角色：<s:if test='#session.manager.role==0' >管理员</s:if>
						<s:if test='#session.manager.role==1' >密码锁管理员</s:if>
						<s:if test='#session.manager.role==2' >密码锁领用者</s:if>
				</div>
			</div>
	</div>
  </body>
</html>
