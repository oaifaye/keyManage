<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'pageControl.jsp' starting page</title>
<style type="text/css">
	a{
		text-decoration: none;
		color: #075587;
	}
</style>
</head>

<body>
	<s:form name="newsForm" theme="simple" id="newsForm">
		共${paginationSupport.totalCount}条&nbsp;
 		第${currentPage}页&nbsp;
 		<s:if test="currentPage==1">首页&nbsp;上一页</s:if>
		<s:else>
			<a href="javascript:paginate(${1})">首页</a>
			<a href="javascript:paginate(${paginationSupport.previousPage})">上一页</a>
		</s:else>
		<s:if test="currentPage>=paginationSupport.nextPage">下一页&nbsp;尾页</s:if>
		<s:else>
			<a href="javascript:paginate(${paginationSupport.nextPage})">下一页</a>
			<a href="javascript:paginate(${paginationSupport.lastPage})">尾页</a>
		</s:else>
		&nbsp;
	</s:form>
</body>
</html>
