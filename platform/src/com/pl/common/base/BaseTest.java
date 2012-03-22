package com.pl.common.base;

import junit.framework.Test;
import junit.framework.TestResult;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:/applicationContext*.xml"})
public class BaseTest implements Test {

	public int countTestCases() {
		return 0;
	}

	public void run(TestResult arg0) {
		
	}

}
