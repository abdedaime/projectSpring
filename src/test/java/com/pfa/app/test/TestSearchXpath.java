package com.pfa.app.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.pfa.app.dao.ParsesrXpathJava;

public class TestSearchXpath {
	  private ParsesrXpathJava    parser;
	@Before
	public  void     setUp(){
		 parser=new ParsesrXpathJava();
	}

	@Test
	public void test() {
		//ClassLoader classLoader = getClass().getClassLoader();
		
		//File file = new File(classLoader.getResource("META-INF/onto-test.xml").getFile());
		
		 
		 //  showResult(parser.getMots("css"));
		  System.out.println(ParsesrXpathJava.construireSql("semantic-ui"));
		
		
	}
	
	private     void showResult(List<?>  e){
		    for(Object  a  :        e){
		    	   System.out.println(a);
		    }
	}

}
