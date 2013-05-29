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
<script type="text/javascript" src="js/keyAsk.js"></script>
<script type="text/javascript" src="js/Calendar3.js"></script>
<script type="text/javascript" src="js/listKeyAsk.js"></script>
<link rel="stylesheet" href="css/list.css" type="text/css"></link>
</head>

<body>
	<div id="greybackground"></div>
	<div class="pageTitle">密码锁仓库管理—密码锁种类管理</div>
	<div class="pageColumn">
		<div class="add"></div>
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
</body>
</html>