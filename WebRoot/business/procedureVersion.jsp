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
<script type="text/javascript" src="js/procedureVersion.js"></script>
</head>

<body>
	<div class="pageTitle">密码锁仓库管理—密码锁种类管理</div>
	<div class="pageColumn">
		<div class="add">

			<s:form action="procedureVersion_add" theme="simple" id="add">
		增加：<br />
			<s:if test="procedureMessageList!=null">
				程序名称：<s:select id="procedureMessage" name="procedureVersion.procedureMessage.id" list="procedureMessageList" listKey="id" listValue="procedureName" headerKey="" headerValue="--请选择--"></s:select><br />
			</s:if>
			<s:else>
				程序名称：<a href="<%=basePath%>procedureMessage_init" >前往填写</a><br />
			</s:else>
			程序版本：<s:textfield id="VersionName" name="procedureVersion.VersionName" maxLength="20"></s:textfield><br />
				<input type="hidden" name="procedureVersion.id" value="${procedureVersion.id}" />
				<input type="hidden" name="procedureVersion.isDelete"
					value="${procedureVersion.isDelete}" />
				<input type="hidden" name="procedureVersion.managerByCreateBy.id"
					value="${procedureVersion.managerByCreateBy.id}" />
				<input type="hidden" name="procedureVersion.createDate"
					value="${procedureVersion.createDate}" />
				<input type="submit" value="保存" class="button2" />
			</s:form>
		</div>
		
		<s:form name="submitForm">
			<table class="table">
				<thead>
					<th width="70"><input class="select-all" name=""
						type="checkbox" value="" /> <a
						href="javascript:del('procedureVersion_removeAll')">删除</a></th>
					<th width="">程序名称</th>
					<th width="">程序版本</th>
					<th width="">新建人</th>
					<th width="10%">操作</th>
				</thead>
				<tbody>
					<s:iterator value="paginationSupport.items">
						<tr>
							<td class="checkBox"><input type="checkbox" name="ids" value='${id}' />
							</td>
							<td><s:property value="procedureMessage.procedureName" />
							</td>
							<td><s:property value="versionName" />
							</td>
							<td><s:property value="managerByCreateBy.name" />
							</td>
							<td><s:a action="procedureVersion_init">
									<s:param name="procedureVersionId" value="id"></s:param>
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
</body>
</html>
