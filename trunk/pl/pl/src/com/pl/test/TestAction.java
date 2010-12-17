package com.pl.test;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pl.common.base.BaseTest;
import com.pl.web.w.reg.JsonUserAction;

@RunWith(SpringJUnit4ClassRunner.class)
public class TestAction extends BaseTest {
	@Autowired
	private JsonUserAction action;

	@Test
	public void getPdtype() throws Throwable {
		action.setUsername("111111");
		HashMap<String, Object> session = new HashMap<String, Object>();
		session.put("abc", "xiong");
		assertEquals(action.jsonUserExisted(),"success");


	}

}
