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
<script type="text/javascript" src="js/Calendar3.js"></script>
<link rel="stylesheet" href="css/list.css" type="text/css"></link>
<script type="text/javascript" src="js/department.js"></script>
<script type='text/javascript' src='<%=basePath%>dwr/engine.js'></script>
<script type='text/javascript' src='<%=basePath%>dwr/util.js'></script>
<script type='text/javascript' src='<%=basePath%>dwr/interface/departmentService.js'></script>
</head>

<body>
	<div class="center">
		<div id="greybackground"></div>
		<%@ include file="../include/top.jsp"%>
		<%@ include file="../include/left.jsp"%>
		<div class="main">
			<div class="pageTitle">基础信息管理—单位信息管理</div>
			<div class="pageColumn">
				<div class="add"></div>
				
				<s:form id="department_add" action="department_add" theme="simple"> 
					<table class="table2">
						<thead>
							<th width="" colspan="5" style="border-bottom: 0px;">单位信息管理</th>
						</thead>
					</table>
					<table class="table2">
						<!-- <tbody> -->
						<tr>
							<td>单位父节点</td>
							<td width="80%">
								
								省级：
								<s:if test="departmentList!=null">
								<s:select id="province"
									name="department.parentId" list="departmentList" listKey="id"
									listValue="departmentName" headerKey="" headerValue="--请选择--"
									theme="simple" cssClass="province"></s:select> 
								</s:if>
								市级：<select id="city" name="department.parentId" class="province"></select> 
								区级：<select id="district" name="department.parentId" class="province"></select>
							</td>
						</tr>
						<tr>
							<td>添加单位</td>
							<td>
								<div class="addDepartment">
									单位名称：<s:textfield id="departmentName"
										name="department.departmentName" maxLength="20" cssClass="text1"></s:textfield>
									<s:submit id="addSubmit" value="保存" theme="simple"></s:submit>
								</div></td>
						</tr>
						<tr>
							<td>修改单位</td>
							<td>
								<div class="addDepartment">
									单位名称：<s:textfield id="departmentName1"
										name="department.departmentName" maxLength="20" cssClass="text1"></s:textfield>
									<input id="updateSubmit" type="submit" value="修改" />
								</div></td>
						</tr>
						<!-- </tbody> -->
					</table>
				</s:form>
			</div>
		</div>
		<%@ include file="../include/foot.jsp"%>
	</div>
</body>
</html>
