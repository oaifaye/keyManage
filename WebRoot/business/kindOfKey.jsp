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
<script type="text/javascript" src="js/pageControl.js"></script>
</head>

<body>
	<div class="pageTitle">密码锁仓库管理—密码锁种类管理</div>
	<div class="pageColumn">
	<div class="add">
		
		<s:form action="kindOfKey_add" theme="simple">
		增加：<br />
			种类名称：<s:textfield name="kindOfKey.kindName" maxLength="20"></s:textfield><br />
			备&nbsp;&nbsp;&nbsp;&nbsp;注：<s:textfield name="kindOfKey.remark" maxLength="85"  cssClass="remark"></s:textfield>
			<input type="submit" value="保存" class="button2" />
		</s:form>
	</div>
	<table class="table">
		<thead>
			<th width="30"><input class="select-all" name="" type="checkbox"
				value="" />
			</th>
			<th width="">密码锁名称</th>
			<th width="">新建人</th>
			<th width="50%">备注</th>
			<th width="10%">操作</th>
		</thead>
		<tbody>
			<s:iterator value="paginationSupport.items" >
				<tr>
					<td class="checkBox"><input name="ids[]" type="checkbox" value="" /></td>
					<td><s:property value="kindName"/></td>
					<td><s:property value="kindName"/></td>
					<td><s:property value="remark"/></td>
					<td>
						<img src="images/icon/edit2.png" width="16" height="16" />
						<img src="images/icon/del.png" width="16" height="16" />
					</td>
				</tr>
			</s:iterator>

			<tr class=" ">
				<td colspan="5 class="checkBox">
					<s:form name="newsForm" theme="simple" id="newsForm">
					共${paginationSupport.totalCount}条&nbsp;
            		第${currentPage}页&nbsp;
					<a href="javascript:paginate(${1})">首页</a>
					<a href="javascript:paginate(${paginationSupport.previousPage})">上一页</a>
					<a href="javascript:paginate(${paginationSupport.nextPage})">下一页</a>
					<a href="javascript:paginate(${paginationSupport.lastPage})">尾页</a>
					</s:form>
				</td>
			</tr>

		</tbody>
	</table>
	</div>
</body>
</html>
