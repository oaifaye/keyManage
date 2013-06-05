<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>

  <link rel="stylesheet" href="css/style.css" type="text/css"></link></head>
  
  <body>
    <div id="content">
			<div class="space"></div>
			<div class="menu">
				<ul>
					<li class="subMenuTitle">功能菜单</li>
				<!-- 管理员start -->
					<s:if test='#session.manager.role=="0"'>
						<li class="subMenu"><a href="#">基础信息管理</a>
							<ul>
								<li><a href="procedureMessage_init" target="_self">程序信息管理</a></li>
								<li><a href="procedureVersion_init" target="rightPage">程序版本管理</a></li>
								<li><a href="department_init" target="rightPage">单位信息管理</a></li>
								<li><a href="purpose_init" target="rightPage">锁用途管理</a></li>
								<li><a href="expressType_init" target="rightPage">送锁方式管理</a></li>
							</ul>
						</li>
					</s:if>
				<!-- 管理员end -->
				<!-- 锁管理员start -->
					<s:if test='#session.manager.role=="1"'>
						<li class="subMenu"><a href="#">密码锁仓库管理</a>
							<ul>
								<li><a href="kindOfKey_init" target="rightPage">锁种类</a></li>
								<li><a href="contain_init" target="rightPage">锁入库</a></li>
								<li><a href="contain_initShipment" target="rightPage">锁出库</a></li>
							</ul>
						</li>
						<li class="subMenu"><a href="#">查询统计</a>
							<ul>
								<li><a href="contain_initListConatin" target="rightPage">出入库情况查询</a></li>
								<li><a href="contain_init" target="rightPage">锁入库</a></li>
								<li><a href="contain_initShipment" target="rightPage">锁出库</a></li>
							</ul>
						</li>
					</s:if>
				<!-- 锁管理员end -->
				<!-- 锁领用者start -->
					<s:if test='#session.manager.role=="2"'>
						<li class="subMenu"><a href="#">密码锁申请</a>
							<ul>
								<li><a href="keyAsk_initKeyAsk" >密码锁申请</a></li>
								<li><a id="test1" href="keyAsk_initListKeyAsk" >添加用途</a></li>
								<li><a href="keyMessage_initListKeyMessage" >用途管理</a></li>
							</ul>
						</li>
					</s:if>
				<!-- 锁领用者end -->
				</ul>
			</div>
			<div class="sidebar fleft"></div>
			
		</div>
  </body>
</html>
