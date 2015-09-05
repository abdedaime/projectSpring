package com.pfa.app.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.pfa.app.service.IServiceUser;

public class UniqueUsernameValidator    implements  ConstraintValidator<UniqueUsername, String> {
     @Autowired
	 private  IServiceUser  service;
	
	
	@Override
	public void initialize(UniqueUsername constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		
		if(service==null){
			 return true;
		}
		return     service.getUser(email)==null;
				
	}

}
