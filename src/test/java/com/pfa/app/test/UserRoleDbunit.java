package com.pfa.app.test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pfa.app.entities.Utilisateur;
import com.pfa.app.service.IServiceUser;

/**
 * 
 * @author PC-Mobiblanc-HP-02
 * 
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/META-INF/applicationContext.xml")
public class UserRoleDbunit {
	@Autowired
    private IServiceUser      service;
	/*@Test
	public void test() {
		Utilisateur user = new Utilisateur();
		user.setEmail("hicham.suptech@gmail.co");
		user.setDate(new Date());
		user.setEnabled(true);
		user.setNom("hicham");
		user.setPrenom("abdedaim");
		 service.add(user);

	}*/
	
	@Test
	public void activerCompte()  {
		String password = "hicham.abbb@gmail.com";
    


		  String  encrypt=PasswordToMd5(password);
		 // System.out.println(encrypt);
 		  //service.getAllusers()
		 // System.out.println(service.getAllusers().size());
 		  for(Utilisateur   u :  service.getAllusers()){
 			  
    
 			     if(PasswordToMd5(u.getEmail()).equals(encrypt)){
 			    	 System.out.println("equaklkkkkkkkkks");
 			    	 u.setEnabled(true);
 			    	service.UpdateUser(u);
 			    	
 			    	 break;
 			     }
 		  }
 		 
	}
	
	private String PasswordToMd5(String password) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		md.update(password.getBytes());

		byte byteData[] = md.digest();

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16)
					.substring(1));
		}

		// System.out.println(sb.toString());
		return sb.toString();

	}

}
