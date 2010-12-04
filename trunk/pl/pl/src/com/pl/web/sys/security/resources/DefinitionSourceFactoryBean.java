package com.pl.web.sys.security.resources;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.security.access.ConfigAttributeEditor;
import org.springframework.security.web.access.intercept.RequestKey;
import org.springframework.security.web.util.AntUrlPathMatcher;
import org.springframework.security.web.util.UrlMatcher;

public class DefinitionSourceFactoryBean implements FactoryBean{

	private SecurityService securityService;
	
	public void setSecurityService(SecurityService securityService) {
		this.securityService = securityService;
	}

	public Object getObject() throws Exception {
		
		return new DefaultFilterInvocationDefinitionSource(getUrlMatcher(), bulidRequstMap());
	}

	@SuppressWarnings("unchecked")
	public Class getObjectType() {
		return FilterInvocationDefinitionSource.class;
	}

	public boolean isSingleton() {
		return true;
	}
	
	protected UrlMatcher getUrlMatcher(){
		return new AntUrlPathMatcher();
	}
	
	protected LinkedHashMap<RequestKey, ConfigAttributeDefinition> bulidRequstMap(){
		
		List<Security> resources = securityService.getResources();
		
		LinkedHashMap<RequestKey, ConfigAttributeDefinition> distMap = new LinkedHashMap<RequestKey, ConfigAttributeDefinition>();
		
		ConfigAttributeEditor edit = null;
		
		for(Security sec : resources){
			
			if(sec.getRoleName() != null){
				
				System.out.println(sec.getRoleName()+" : "+sec.getResourceValue());
				
				edit = new ConfigAttributeEditor();
				
				RequestKey requestKey = new RequestKey(sec.getResourceValue(), null);
				
				edit.setAsText(sec.getRoleName());
				
				distMap.put(requestKey, (ConfigAttributeDefinition)edit.getValue());
				
			}
			
		}
		
		return distMap;
	}
	

}
