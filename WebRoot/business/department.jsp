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
<script type="text/javascript" src="js/Calendar3.js"></script>
<link rel="stylesheet" href="css/detail.css" type="text/css"></link>
<script type="text/javascript" src="js/department.js"></script>
<script type='text/javascript' src='<%=basePath%>dwr/engine.js'></script> 
<script type='text/javascript' src='<%=basePath%>dwr/util.js'></script> 
<script type='text/javascript' src='<%=basePath%>dwr/interface/departmentService.js'></script> 
</head>

<body>
	<div id="greybackground"></div>
	<div class="pageTitle">密码锁仓库管理—密码锁种类管理</div>
	<div class="pageColumn">
		<div class="add"></div>
		<s:form action="department_add" theme="simple">
			<table class="table">
				<thead>
					<th width="" colspan="5">单位信息管理</th>
				</thead>
				<tbody>
					<tr>
						<td>单位父节点</td>
						<td colspan="4">
							省级：<s:select id="province" name="department.parentId" list="departmentList" listKey="id" listValue="departmentName" headerKey="" headerValue="--请选择--" theme="simple" cssClass="text"></s:select>
							市级：<select id="city" name="department.parentId" class="text"></select>
							区级：<select id="district" name="department.parentId" class="text"></select>
						</td>
					</tr>
					<tr>
						<td>添加单位</td>
						<td colspan="4">
							<div class="addDepartment">
								<s:textfield id="departmentName" name="department.departmentName" cssClass="text"></s:textfield>
								<s:submit id="addSubmit" value="保存" theme="simple"></s:submit>
							</div>
						</td>
					</tr>
				</tbody>
			</table>
		</s:form>
	</div>
</body>
</html>