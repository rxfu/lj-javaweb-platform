package com.pl.common.security;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;



import com.pl.web.sys.security.user.BaseUserDetails;

public class SecurityUtil {
	public static boolean isLogin(){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		BaseUserDetails baseUserDetails = (BaseUserDetails) authentication.getPrincipal();
		if(!StringUtils.isEmpty(baseUserDetails.getUsername())){
			return true;
		}
		return false;
	}
}
