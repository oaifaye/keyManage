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
<script type="text/javascript" src="js/Calendar3.js"></script>
<script type="text/javascript" src="js/listKeyMessage.js"></script>

<link rel="stylesheet" href="css/list.css" type="text/css"></link>
</head>

<body>
	<div id="greybackground"></div>
	<div class="pageTitle">密码锁仓库管理—密码锁种类管理</div>
	<div class="pageColumn">
		<div class="add"></div>
		<s:form id="selectSubmit" action="contain_execListContain" theme="simple">
			锁种类：<s:select name="kindOfKeyId" list="kindOfKeyList" listKey="id" listValue="kindName" headerKey="" headerValue="--请选择--" ></s:select>&nbsp;&nbsp;&nbsp;
			选择时间范围：<s:textfield id="startDate" name="startDate" onclick="new Calendar().show(this)" readonly="true" cssClass="text1" ></s:textfield> &nbsp;—
						<s:textfield id="endDate" name="endDate" onclick="new Calendar().show(this)" readonly="true" class="text1" />
			出库或入库：
					<select name="saveOrTake">
						<option value="">--请选择--</option>
						<option value="0">入库</option>
						<option value="1">出库</option>
					</select>
			<input type="submit" value="查询" />
		</s:form>
		<div class="resultList1">
			<table class="table">
				<thead>
					<th width="">密码锁种类</th>
					<th width="">批号</th>
					<th width="">数量</th>
					<th width="">出入库时间</th>
					<th width="">出入库</th>
					<th width="">创建人</th>
				</thead>
				<tbody>
					<s:iterator value="containList">
						<tr>
							<td>
								<s:property value="kindOfKey.kindName"/>
							</td>
							<td>
								<s:property value="lotNumber"/>
							</td>
							<td>
								<s:property value="keyNum"/>
							</td>
							<td>
								<s:date name="containDate" format="yyyy-MM-dd" />
							</td>
							<td>
								<s:if test='saveOrTake=="0"'>入</s:if>
								<s:elseif test='saveOrTake=="1"'>出</s:elseif>
							</td>
							<td>
								<s:property value="managerByCreateBy.name"/>
							</td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
