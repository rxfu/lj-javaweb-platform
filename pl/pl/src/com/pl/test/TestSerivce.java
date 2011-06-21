package com.pl.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pl.common.base.BaseTest;
import com.pl.service.PdtypeService;
import com.pl.tdo.PdtypeBean;

@RunWith(SpringJUnit4ClassRunner.class)
public class TestSerivce extends BaseTest {
	@Autowired
	private PdtypeService pdtypeService;

	@Test
	public void getPdtype() throws Throwable {
		List<PdtypeBean> list= pdtypeService.getCurrentAllPdtype();
		if(pdtypeService.getCurrentAllPdtype().size()>0){
			assertTrue(false);
		}
		for (PdtypeBean pdtype : list) {
			System.out.println(pdtype.getPdtypeName1());
		}
	}

}
