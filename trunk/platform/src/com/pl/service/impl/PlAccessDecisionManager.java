package com.pl.service.impl;

import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import com.pl.web.a.pdtype.PdtypeAction;

public class PlAccessDecisionManager implements AccessDecisionManager {
	
	private static final Log log = LogFactory.getLog(PlAccessDecisionManager.class);
	
	public void decide(Authentication authentication, Object object,
			Collection<ConfigAttribute> configAttributes)
			throws AccessDeniedException, InsufficientAuthenticationException {

		if (configAttributes == null) {
			return;
		}
		Iterator<ConfigAttribute> ite = configAttributes.iterator();
		while (ite.hasNext()) {
			ConfigAttribute ca = ite.next();
			String needRole = ((SecurityConfig) ca).getAttribute();
			log.info("访问需要权限为："+needRole);
			// ga 为用户所被赋予的权限。 needRole 为访问相应的资源应该具有的权限。
			for (GrantedAuthority ga : authentication.getAuthorities()) {
				log.info("目前的权限为:"+ga.getAuthority());
				if (needRole.equals(ga.getAuthority())) {
					return;
				}
			}
		}
		throw new InsufficientAuthenticationException("您没有足够的权限访问！");
//		throw new AccessDeniedException("您没有足够的权限访问！");
	}
	public boolean supports(ConfigAttribute attribute) {
		return true;
	}
	public boolean supports(Class<?> clazz) {
		return true;
	}
}
