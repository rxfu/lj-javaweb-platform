package com.yk.web.menu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * ��ȡ�˵���Controller
 * @author xiongqingchun001
 *
 */
@Controller
public class MenuController {
	
	@RequestMapping(value="/menu/select")
	public String select(){
		return "/yk/menu/select.jsp";
	}
}
