package com.pfa.app.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.hibernate.validator.internal.util.privilegedactions.GetClassLoader;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
/**
 * 
 * @author hicham  abdedaime
 *
 */
public class ParsesrXpathJava {

	public static String getLangageByName(Document doc, XPath xpath, String lang) {
		String name = null;

		
		try {
			XPathExpression expr = xpath
					.compile("/Ontology/Langages/Langage[text()='" + lang
							+ "']/@id");
			name = (String) expr.evaluate(doc, XPathConstants.STRING);
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}

		return name;
	}

	public static String getLangageById(Document doc, XPath xpath, String idlang) {
		String name = null;

		try {
			XPathExpression expr = xpath
					.compile("/Ontology/Langages/Langage[@id=" + idlang
							+ "]/text()");
			name = (String) expr.evaluate(doc, XPathConstants.STRING);
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}

		return name;
	}

	public static List<String> getFrameworkByLangageId(Document doc,
			XPath xpath, String id) {
		List<String> list = new ArrayList<>();
		try {
			// create XPathExpression object
			
			XPathExpression expr = xpath
					.compile("/Ontology/Frameworks/Framework[contains(@EcritEn,"
							+ id + ")]/text()");
			// evaluate expression result on XML document
			NodeList nodes = (NodeList) expr.evaluate(doc,
					XPathConstants.NODESET);
			for (int i = 0; i < nodes.getLength(); i++)
				list.add(nodes.item(i).getNodeValue());
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static String getFramwortkByName(Document doc, XPath xpath,
			String lang) {
		String name = null;
	/*	if (lang == null) {
			return null;
		}*/

		try {
			XPathExpression expr = xpath
					.compile("/Ontology/Frameworks/Framework[text()='" + lang
							+ "']/@EcritEn");
			name = (String) expr.evaluate(doc, XPathConstants.STRING);
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}

		return name;
	}

	
	
	
	public   static HashSet<String>  getMots(String lang){
		HashSet<String>  maliste=new HashSet<String>();

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setNamespaceAware(true);
			DocumentBuilder builder;
			Document doc = null;
			try {
				builder = factory.newDocumentBuilder();
				ClassLoader classLoader = GetClassLoader.class.getClassLoader();
				String path = classLoader.getResource("META-INF/onto-test.xml")
						.toString();
				doc = builder.parse(path);
				XPathFactory xpathFactory = XPathFactory.newInstance();
				XPath xpath = xpathFactory.newXPath();
			//	String lang = "ionic";
				if (getLangageByName(doc, xpath, lang) != "") {
					//System.out.println("-------------------------------------");
					for (String a : getFrameworkByLangageId(doc, xpath,
							getLangageByName(doc, xpath, lang))) {
						//System.out.println(a);
						maliste.add(a);
					}
				}

				
				  if(getFramwortkByName(doc, xpath, lang)!=""){
				  //System.out.println("///////////////////////////////////////////////");
				  String framwork = getFramwortkByName(doc, xpath, lang);
				  if(framwork.contains(",")){
					  String    tab []=framwork.split(",");
					  for(  String   value : tab ){
						//  System.out.println("langaggggge       "+getLangageById(doc, xpath, value));
						  maliste.add(getLangageById(doc, xpath, value));
						  
						  // mise a jour de la fonction
						  for (String a : getFrameworkByLangageId(doc, xpath,
									value)) {
								//System.out.println(a);
								maliste.add(a);
							}
						  //end mise a joure
					  }
				}
				else {
					//System.out.println("la valeur de name  " + framwork);
					//System.out.println("langaggggge       "+getLangageById(doc, xpath, framwork));
					 maliste.add(getLangageById(doc, xpath, framwork));
					 
					 for (String a : getFrameworkByLangageId(doc, xpath,  framwork
								)) {
							//System.out.println(a);
							maliste.add(a);
						}

				}

				 }
				 

			} catch (Exception e) {
				e.printStackTrace();
			}
		
		  return maliste;
		
	}
	
	public static String construireSql(String langa) {
		String sql = "select  c from   Competence c  where c.nom";
		HashSet<String> liste = getMots(langa);
		   
		if(liste.size()==0){
			String  cdt="n";
			sql = sql + " " + "='" + cdt + "'";
		}

		System.out.println(liste.size());
		int i = 0;
		for (String sys : liste) {
			if (i == 0) {
				sql = sql + " " + "='" + sys + "'";
				i++;
				continue;

			}
			sql = sql + "  " + "or   c.nom ='" + sys + "'";
			i++;

		}
		sql=sql+ "  or  c.nom ='"+langa+"' " + " group by c.cv.user ";
		return sql;

	}

	


}
