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
<script type="text/javascript" src="js/kindOfKey.js"></script>
</head>

<body>
	<div class="center">
	<%@ include file="../include/top.jsp" %>
	<%@ include file="../include/left.jsp" %>
	<div class="main">
	<div class="pageTitle">密码锁仓库管理—密码锁种类管理</div>
	<div class="pageColumn">
		<div class="add">

			<s:form action="kindOfKey_add" theme="simple" id="add">
		增加：<br />
			种类名称：<s:textfield id="kindName" name="kindOfKey.kindName"
					maxLength="20"></s:textfield>
				<br />
			添加备注：<s:textfield id="remark"
					name="kindOfKey.remark" maxLength="85" cssClass="remark"></s:textfield>
				<input type="hidden" name="kindOfKey.id" value="${kindOfKey.id}" />
				<input type="hidden" name="kindOfKey.isDelete"
					value="${kindOfKey.isDelete}" />
				<input type="hidden" name="kindOfKey.managerByCreateBy.id"
					value="${kindOfKey.managerByCreateBy.id}" />
				<input type="hidden" name="kindOfKey.createDate"
					value="${kindOfKey.createDate}" />
				<input type="submit" value="保存" class="button2" />
			</s:form>
		</div>
		<s:form name="submitForm">
			<table class="table">
				<thead>
					<th width="70"><input class="select-all" name=""
						type="checkbox" value="" /> <a
						href="javascript:del('kindOfKey_removeAll')">删除</a></th>
					<th width="">密码锁名称</th>
					<th width="">新建人</th>
					<th width="50%">备注</th>
					<th width="10%">操作</th>
				</thead>
				<tbody>
					<s:iterator value="paginationSupport.items">
						<tr>
							<td class="checkBox"><input type="checkbox" name="ids"
								value='${id}' />
							</td>
							<td><s:property value="kindName" />
							</td>
							<td><s:property value="managerByCreateBy.name" />
							</td>
							<td><s:property value="remark" />
							</td>
							<td><s:a action="kindOfKey_init">
									<s:param name="kindOfKeyId" value="id"></s:param>
									<s:param name="currentPage" value="currentPage"></s:param>
							修改
						</s:a></td>
						</tr>
					</s:iterator>

					<tr>
						<td colspan="5" class="pageControl">
							<%@ include file="../include/pageControl.jsp" %>
						</td>
					</tr>

				</tbody>
			</table>
		</s:form>
	</div>
	</div>
	</div>
</body>
</html>
