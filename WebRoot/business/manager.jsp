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
<script type="text/javascript" src="js/manager.js"></script>
</head>

<body>
	<div class="center">
		<%@ include file="../include/top.jsp"%>
		<%@ include file="../include/left.jsp"%>
		<div class="main">
			<div class="pageTitle">人员信息管理—用户信息管理</div>
			<div class="pageColumn">
				<div class="add">
					<s:form action="manager_add" theme="simple" id="add">
		增加：<br />
			用户角色：
			<s:if test="manager!=null">
				<s:select id="role" name="managerMessages.role" list="#{1:'密码锁管理员',2:'密码锁领用者'}" cssClass="text2" />
			</s:if>
			<s:else>
				<s:select id="role" name="managerMessages.role"
							list="#{1:'密码锁管理员',2:'密码锁领用者'}" 
							headerKey="" headerValue="--请选择--" cssClass="text2" />
			</s:else>
			<br />
			用户名：<s:textfield name="managerMessages.userName" id="userName"></s:textfield>(密码：123456)
			用户名称：&nbsp;<s:textfield name="managerMessages.name" id="name"></s:textfield>
						<input type="hidden" name="managerMessages.id" value="${managerMessages.id}" />
						<input type="hidden" name="managerMessages.isDelete"
							value="${managerMessages.isDelete}" />
						<input type="hidden" name="managerMessages.createDate"
							value="${managerMessages.createDate}" />
						<input type="submit" value="保存" class="button2" />
					</s:form>
				</div>
				<s:form name="submitForm">
					<table class="table">
						<thead>
							<th width="70"><input class="select-all" name=""
								type="checkbox" value="" /> <a
								href="javascript:del('manager_removeAll')">删除</a></th>
							<th width="">用户名</th>
							<th width="">用户名称</th>
							<th width="">角色</th>
							<th width="">用户状态</th>
							<th width="15%">操作</th>
						</thead>
						<tbody>
							<s:iterator value="paginationSupport.items">
								
								<tr>
									<td class="checkBox">
										<s:if test="role!=0">
											<input type="checkbox" name="ids" value='${id}' />
										</s:if>
									</td>
									<td><s:property value="userName" />
									</td>
									<td><s:property value="name" />
									</td>
									<td>
										<s:if test='role==0' >管理员</s:if>
										<s:if test='role==1' >密码锁管理员</s:if>
										<s:if test='role==2' >密码锁领用者</s:if>
									</td>
									<td>
										<s:if test='isDelete==0' >已停用</s:if>
										<s:if test='isDelete==1' >未停用</s:if>
									</td>
									<td>
										<s:if test="role!=0">
										<s:a action="manager_init">
											<s:param name="managerId" value="id"></s:param>
											<s:param name="currentPage" value="currentPage"></s:param>
											修改
										</s:a>&nbsp;&nbsp;
										<s:if test="isDelete==0">
											<s:a action="manager_restore">
												<s:param name="managerId" value="id"></s:param>
												<s:param name="currentPage" value="currentPage"></s:param>
												恢复
											</s:a>
										</s:if>
										<s:else>
											恢复
										</s:else>
										</s:if>
									</td>
								</tr>
							</s:iterator>

							<tr>
								<td colspan="6" class="pageControl"><%@ include
										file="../include/pageControl.jsp"%></td>
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
