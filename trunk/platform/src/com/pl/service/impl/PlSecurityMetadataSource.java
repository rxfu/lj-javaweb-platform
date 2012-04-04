package com.pl.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.AntUrlPathMatcher;
import org.springframework.security.web.util.UrlMatcher;
import org.springframework.stereotype.Service;


public class PlSecurityMetadataSource  implements FilterInvocationSecurityMetadataSource{
	@Autowired
//	 private PubAuthoritiesResourcesHome pubAuthoritiesResourcesHome;

	 private UrlMatcher urlMatcher = new AntUrlPathMatcher();
	 private static Map<String, Collection<ConfigAttribute>> resourceMap = null;

	 public PlSecurityMetadataSource() {
	  loadResourceDefine();
	 }

	 /**
	  * 扎入权限与url对应关系
	  */
	 private void loadResourceDefine() {
	  ApplicationContext context = new ClassPathXmlApplicationContext(
	    "classpath:applicationContext.xml");
	  resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
	  
      Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();
      List<String[]> caList = new ArrayList<String[]>();
      String[] caArray4= {"/index.jsp","IS_AUTHENTICATED_ANONYMOUSLY"};
      caList.add(caArray4);
      String[] caArray5= {"/index1.jsp","IS_AUTHENTICATED_ANONYMOUSLY"};
      caList.add(caArray5);
      
      
      
      String[] caArray1= {"/a/**","ROLE_abc"};
      caList.add(caArray1);
      String[] caArray2= {"/a/**","ROLE_1"};
      caList.add(caArray2);
      
      String[] caArray3= {"/**","ROLE_abcd"};
      caList.add(caArray3);
      
      for (int i = 0; i < caList.size(); i++) {
    	  ConfigAttribute ca = new SecurityConfig(caList.get(i)[1]);
          atts.add(ca);
          resourceMap.put(caList.get(i)[0], atts);
      }
	 }

	 public Collection<ConfigAttribute> getAttributes(Object object)
	            throws IllegalArgumentException {
	        String url = ((FilterInvocation)object).getRequestUrl();
	        Iterator<String> ite = resourceMap.keySet().iterator();
	        while (ite.hasNext()) {
	            String resURL = ite.next();
	            if (urlMatcher.pathMatchesUrl(resURL, url)) {
	                return resourceMap.get(resURL);
	            }
	        }
	        return null;
	    }

	    public boolean supports(Class<?> clazz) {
	        return true;
	    }
	    
	    public Collection<ConfigAttribute> getAllConfigAttributes() {
	        return null;
	    }


}
