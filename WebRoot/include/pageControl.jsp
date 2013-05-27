<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
</head>

<body>
	<!-- <s:form name="newsForm" theme="simple" id="newsForm"> -->
	
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
	<!-- </s:form> -->
</body>
</html>
