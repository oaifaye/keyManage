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
<script type="text/javascript" src="js/keyAsk.js"></script>
<script type="text/javascript" src="js/Calendar3.js"></script>
<script type="text/javascript" src="js/listKeyAsk.js"></script>
<link rel="stylesheet" href="css/list.css" type="text/css"></link>
</head>

<body>
<div class="center">
	<div id="greybackground"></div>
	<%@ include file="../include/top.jsp" %>
	<%@ include file="../include/left.jsp" %>
	<div class="main">
	<div class="pageTitle">密码锁使用管理—添加用途</div>
	<div class="pageColumn">
			<table class="table">
				<thead>
					<th width="">密码锁名称</th>
					<th width="">需求时间</th>
					<th width="">需求锁数量</th>
					<th width="">满足锁数量</th>
					<th width="">已用锁数量</th>
					<th width="">备注</th>
					<th width="">响应状态</th>
					<th width="">操作</th>
				</thead>
				<tbody>
					<s:iterator value="paginationSupport.items">
						<tr>
							<td><s:property value="kindOfKey.kindName" />
							</td>
							<td><s:date name="askDate" format="yyyy-MM-dd" />
							</td>
							<td><s:property value="askNum" />
							</td>
							<td><s:property value="tokenNum" />
							</td>
							<td><s:property value="usedNum" />
							</td>
							<td><s:property value="askRemark" />
							</td>
							<td><s:property value="isFinished" />
							</td>
							<td>
								<s:a action="keyAsk_initKeyUse" >
									<s:param name="keyAskId" value="id"></s:param>
									填写用途
								</s:a>
							</td>
						</tr>
					</s:iterator>
					<tr>
						<td colspan="8" class="pageControl">
							<%@ include file="../include/pageControl.jsp" %>
						</td>
					</tr>
				</tbody>
			</table>
	</div>
	</div>
	<%@ include file="../include/foot.jsp" %>
	</div>
</body>
</html>
