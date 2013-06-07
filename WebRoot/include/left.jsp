<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>

  <link rel="stylesheet" href="css/style.css" type="text/css"></link>
  <script type="text/javascript" src="js/jquery.js"></script>
  <script type="text/javascript" src="js/index.js"></script>
  </head>
  
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
								<li><a href="procedureMessage_init" >程序信息管理</a></li>
								<li><a href="procedureVersion_init" >程序版本管理</a></li>
								<li><a href="department_init">单位信息管理</a></li>
								<li><a href="purpose_init" >锁用途管理</a></li>
								<li><a href="expressType_init" >送锁方式管理</a></li>
							</ul>
						</li>
						<li class="subMenu"><a href="#">人员信息管理</a>
							<ul>
								<li><a href="manager_init" >用户信息管理</a></li>
							</ul>
						</li>
						<li class="subMenu"><a href="#">查询统计</a>
							<ul>
								<li><a href="contain_initListConatin" >出入库情况查询</a></li>
							</ul>
						</li>
					</s:if>
				<!-- 管理员end -->
				<!-- 锁管理员start -->
					<s:if test='#session.manager.role=="1"'>
						<li class="subMenu"><a href="#">密码锁仓库管理</a>
							<ul>
								<li><a href="kindOfKey_init" >锁种类</a></li>
								<li><a href="contain_init" >锁入库</a></li>
								<li><a href="contain_initShipment">锁出库</a></li>
							</ul>
						</li>
						<li class="subMenu"><a href="#">查询统计</a>
							<ul>
								<li><a href="contain_initListConatin" >出入库情况查询</a></li>
							</ul>
						</li>
					</s:if>
				<!-- 锁管理员end -->
				<!-- 锁领用者start -->
					<s:if test='#session.manager.role=="2"'>
						<li class="subMenu"><a href="#">基础信息管理</a>
							<ul>
								<li><a href="department_init">单位信息管理</a></li>
							</ul>
						</li>
						<li class="subMenu"><a href="#">密码锁使用管理</a>
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
