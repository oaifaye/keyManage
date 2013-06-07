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
<script type="text/javascript" src="js/Calendar3.js"></script>	
<script type="text/javascript" src="js/contain.js"></script>
</head>

<body>
	<div class="center">
	<%@ include file="../include/top.jsp" %>
	<%@ include file="../include/left.jsp" %>
	<div class="main">
	<div class="pageTitle">密码锁仓库管理—锁入库</div>
	<div class="pageColumn">
	<div class="add">
		
		<s:form action="contain_add" theme="simple" id="add">
		增加：<br />
			锁之种类：<s:select id="kindOfKey" name="contain.kindOfKey.id" list="kindOfKeyList" listKey="id" listValue="kindName" headerKey="" headerValue="--请选择--"></s:select><br />
			锁之批号：<s:textfield id="lotNumber" name="contain.lotNumber" maxLength="85" cssClass="lotNumber"></s:textfield>&nbsp;&nbsp;&nbsp;
			锁之数量：<s:textfield id="keyNum" name="contain.keyNum" maxLength="5" cssClass="keyNum" ></s:textfield>&nbsp;&nbsp;&nbsp;
			入库时间：<s:textfield id="containDate" name="containDate" onclick="new Calendar().show(this)" readonly="true"></s:textfield>
			
			<input type="hidden" id="containId" name="contain.id" value="${contain.id}" />
			<!-- 文本框不可用后传值 -->
			<s:if test="contain.id!=null">
				<input type="hidden" name="contain.kindOfKey.id" value="${contain.kindOfKey.id}" />
				<input type="hidden" name="containDate" value="${containDate}" />
				<input type="hidden" name="contain.keyNum" value="${contain.keyNum}" />
				<input type="hidden" name="contain.saveOrTake" value="${contain.saveOrTake}" />
				<input type="hidden" name="contain.isDelete" value="${contain.isDelete}" />
				<input type="hidden" name="contain.managerByCreateBy.id" value="${contain.managerByCreateBy.id}" />
				<input type="hidden" name="contain.createDate" value="${contain.createDate}" />
			</s:if>
			<input type="submit" value="保存" class="button2"/>
		</s:form>
	</div>
	<s:form name="submitForm">
	<table class="table">
		<thead>
			<th width="15">密码锁种类</th>
			<th width="25">密码锁批号</th>
			<th width="15%">密码锁数量</th>
			<th width="15%">入库时间</th>
			<th width="20%">创建人</th>
			<th width="10%">操作</th>
		</thead>
		<tbody>
			<s:iterator value="paginationSupport.items" >
				<tr>
					<td><s:property value="kindOfKey.kindName"/></td>
					<td><s:property value="lotNumber"/></td>
					<td><s:property value="keyNum"/></td>
					<td><s:date name="containDate" format="yyyy-MM-dd" /></td>
					<td>
						<s:property value="managerByCreateBy.name" />
					</td>
					<td>
						<s:a action="contain_init" >
							<s:param name="containId" value="id"></s:param>
							<s:param name="currentPage" value="currentPage"></s:param>
							修改
						</s:a>
					</td>
				</tr>
			</s:iterator>

			<tr>
				<td colspan="6" class="pageControl"><jsp:include page="/include/pageControl.jsp" />
				<br /></td>
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
