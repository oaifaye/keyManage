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
<script type="text/javascript" src="js/shipment.js"></script>

<link rel="stylesheet" href="css/list.css" type="text/css"></link>
</head>

<body>
	<div id="greybackground"></div>
	<div class="pageTitle">密码锁仓库管理—密码锁种类管理</div>
	<div class="pageColumn">
		<div class="add"></div>
		<div style="font-size: 14px;">
		需求密码锁：<s:property value="keyAsk.kindOfKey.kindName" /><br />
		需求时间：<s:date name="keyAsk.askDate" format="yyyy-MM-dd" /><br />
		申请人：<s:property value="keyAsk.managerByCreateBy.name" />(<s:property value="keyAsk.managerByCreateBy.userName" />)<br />
		还需满足个数：<span id="lastNum"><s:property value="lastNum" /></span>
		</div>
		<s:form id="add" action="/contain_shipment">
			<table class="table">
				<thead>
					<th width="">密码锁批号</th>
					<th width="">剩余锁数量</th>
					<th width="">给与数量</th>
				</thead>
				<tbody>
					<s:iterator value="CountObjectList">
						<s:if test="num>0">
						<tr>
							<td><s:property value="item" />
							</td>
							<td><s:property value="num" />
							</td>
							<td>
								<s:textfield cssClass="shipmentNum" name="shipmentNum" theme="simple" maxLength="6" />
								<s:hidden name="lotNumber" value="%{item}"/>
							</td>
						</tr>
						</s:if>
					</s:iterator>
					<tr>
						<td colspan="3">
							<input type="submit" value="提交" class="button2" />
							<input type="button" id="rollBack" value="返回" class="button2" />
						</td>
					</tr>
				</tbody>
			</table>
			<s:hidden id="totalNum" name="totalNum"/>
			<s:hidden name="keyAsk.id" value="%{keyAsk.id}"/>
			<s:hidden name="kindOfKey.id" value="%{keyAsk.kindOfKey.id}"/>
		</s:form>
	</div>
</body>
</html>
