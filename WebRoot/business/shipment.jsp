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
<script type="text/javascript" src="js/Calendar3.js"></script>
<script type="text/javascript" src="js/shipment.js"></script>

<link rel="stylesheet" href="css/list.css" type="text/css"></link>
</head>

<body>
	<div class="center">
		<div id="greybackground"></div>
		<%@ include file="../include/top.jsp"%>
		<%@ include file="../include/left.jsp"%>
		<div class="main">
			<div class="pageTitle">密码锁仓库管理—锁出库</div>
			<div class="pageColumn">
				<s:form id="selectSubmit" action="keyAsk_initListKeyAsk" theme="simple">
			选择锁的类型：<s:select name="kindOfKeyId" list="kindOfKeyList" listKey="id" listValue="kindName" headerKey="" headerValue="--请选择--" ></s:select>&nbsp;&nbsp;&nbsp;
			选择时间范围：<s:textfield id="startDate" name="startDate" onclick="new Calendar().show(this)" readonly="true" ></s:textfield> &nbsp;—
						<s:textfield id="endDate" name="endDate" onclick="new Calendar().show(this)" readonly="true" />&nbsp;&nbsp;&nbsp;
			响应状态：<s:select name="isFinished" list="#{0:'已完结',1:'已满足',2:'未完结'}"  headerKey="" headerValue="--请选择--" ></s:select>&nbsp;&nbsp;&nbsp;
			<s:reset value="重置" cssClass="button2" />&nbsp;&nbsp;&nbsp;
			<input type="submit" value="查询" class="button2" />
		</s:form>
		<div class="resultList2">
				<table class="table">
					<thead>
						<th width="">密码锁名称</th>
						<th width="">需求时间</th>
						<th width="">需求锁数量</th>
						<th width="">满足数量</th>
						<th width="">已用锁数量</th>
						<th width="">备注</th>
						<th width="">申请人</th>
						<th width="">响应状态</th>
						<th width="">操作</th>
					</thead>
					<tbody>
						<s:iterator value="paginationSupport.items">
							<tr>
								<td><s:property value="kindOfKey.kindName" />
								</td>
								<td><s:date name="askDate" format="yyyy-MM-dd" />
								</td>
								<td><s:property value="askNum" />
								</td>
								<td><s:property value="tokenNum" />
								</td>
								<td><s:property value="usedNum" />
								</td>
								<td><s:property value="askRemark" />
								</td>
								<td><s:property value="managerByCreateBy.name" />
								</td>
								<td>
									<s:if test='isFinished=="0"'>已完结</s:if> 
									<s:elseif test='isFinished=="1"'>已满足</s:elseif>
									<s:elseif test='isFinished=="2"'>未完结</s:elseif>
								</td>
								<td><s:if test='isFinished!="2"'>回应</s:if> <s:else>
										<s:a action="/contain_initEditShipment">
											<s:param name="keyAskId" value="id"></s:param>
										回应
									</s:a>
									</s:else>
								</td>
							</tr>
						</s:iterator>
						<tr>
							<td colspan="9" class="pageControl"><%@ include
									file="../include/pageControl.jsp"%></td>
						</tr>
					</tbody>
				</table>
			</div>
</div>
		</div>
		<%@ include file="../include/foot.jsp"%>
	</div>
</body>
</html>
