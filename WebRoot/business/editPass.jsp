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
<link rel="stylesheet" href="css/list.css" type="text/css"></link>
<script type="text/javascript" src="js/editPass.js"></script>
</head>

<body>
	<div class="center">
		<%@ include file="../include/top.jsp"%>
		<%@ include file="../include/left.jsp"%>
		<div class="main">
			<div class="pageTitle">人员信息管理—密码修改</div>
			<div class="pageColumn">
				<div class="add"></div>
				<s:form id="execEditPass" action="manager_execEditPass"
					theme="simple">
					<table class="table2">
						<thead>
							<th width="" colspan="2" style="border-bottom: 0px;">修改密码</th>
						</thead>
						<tbody>
							<tr>
								<td>
									输入新密码
								</td>
								<td>
									<s:password id="password" name="password" cssClass="text1" maxLength="20" />
								</td>
							</tr>
							<tr>
								<td>
									重复新密码
								</td>
								<td>
									<input id="passwordRepeat" type="password" class="text1" maxLength="20"/>
								</td>
							</tr>
							<tr>
								<td colspan="2" ><s:submit value="保存" cssClass="button2" /></td>
							</tr>
						</tbody>
					</table>
				</s:form>
			</div>
		</div>
		<%@ include file="../include/foot.jsp"%>
	</div>
</body>
</html>
