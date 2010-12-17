package com.pl.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pl.common.base.BaseTest;
import com.pl.web.w.pdtype.Pdtype;
import com.pl.web.w.pdtype.PdtypeService;

@RunWith(SpringJUnit4ClassRunner.class)
public class TestSerivce extends BaseTest {
	@Autowired
	private PdtypeService pdtypeService;

	@Test
	public void getPdtype() throws Throwable {
		List<Pdtype> list= pdtypeService.getCurrentAllPdtype();
		if(pdtypeService.getCurrentAllPdtype().size()>0){
			assertTrue(false);
		}
		for (Pdtype pdtype : list) {
			System.out.println(pdtype.getPdtypeName1());
		}
	}

}
