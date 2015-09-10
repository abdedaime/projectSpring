package com.pfa.app.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pfa.app.service.IApplicationMailer;
/**
 * 
 * @author hicham-pc
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/META-INF/applicationContext.xml")
public class TestSendMail {
	@Autowired
	private IApplicationMailer send;

	@Test
	public void test() {
		send.sendMail("hicham.suptech@gmail.com", "tettttttt", "hhhhhhhhhhhh");

	}

}
