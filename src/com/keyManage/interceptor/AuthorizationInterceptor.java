package com.keyManage.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class AuthorizationInterceptor extends MethodFilterInterceptor {
	private static final long serialVersionUID = 6477996926735650473L;

	@Override
	protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
		Map<String, Object> session = actionInvocation.getInvocationContext().getSession();
		if(session.get("manager")== null){
			return "relogin";
		}else{
			return actionInvocation.invoke();
		}
	}

}
