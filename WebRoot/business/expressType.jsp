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
<script type="text/javascript" src="js/expressType.js"></script>
</head>

<body>
	<div class="center">
	<%@ include file="../include/top.jsp" %>
	<%@ include file="../include/left.jsp" %>
	<div class="main">
	<div class="pageTitle">密码锁仓库管理—密码锁种类管理</div>
	<div class="pageColumn">
		<div class="add">
			<s:form action="expressType_add" theme="simple" id="add">
			增加：<br />
			送锁方式：<s:textfield id="expressTypeName" name="expressType.expressTypeName" maxLength="20"></s:textfield>
				<br />
				<input type="hidden" name="expressType.id" value="${expressType.id}" />
				<input type="hidden" name="expressType.isDelete"
					value="${expressType.isDelete}" />
				<input type="hidden" name="expressType.managerByCreateBy.id"
					value="${expressType.managerByCreateBy.id}" />
				<input type="hidden" name="expressType.createDate"
					value="${expressType.createDate}" />
				<input type="submit" value="保存" class="button2" />
			</s:form>
		</div>
		<s:form name="submitForm">
			<table class="table">
				<thead>
					<th width="70"><input class="select-all" name=""
						type="checkbox" value="" /> <a
						href="javascript:del('expressType_removeAll')">删除</a></th>
					<th width="">锁的用途</th>
					<th width="">新建人</th>
					<th width="10%">操作</th>
				</thead>
				<tbody>
					<s:iterator value="paginationSupport.items">
						<tr>
							<td class="checkBox"><input type="checkbox" name="ids"
								value='${id}' />
							</td>
							<td><s:property value="expressTypeName" />
							</td>
							<td><s:property value="managerByCreateBy.name" />
							</td>
							<td><s:a action="expressType_init">
									<s:param name="expressTypeId" value="id"></s:param>
									<s:param name="currentPage" value="currentPage"></s:param>
							修改
						</s:a></td>
						</tr>
					</s:iterator>

					<tr>
						<td colspan="4" class="pageControl">
							<%@ include file="../include/pageControl.jsp" %>
						</td>
					</tr>

				</tbody>
			</table>
		</s:form>
	</div>
	</div>
	<%@ include file="../include/foot.jsp" %>
	</div>
</body>
</html>
