package test.other;



import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.Test;

import application.entity.customer.Customer;
import application.logic.ApplicationValidation;

public class SimpleTest {

	public static void trackUseCases(String a, Class<?> cl) 
	{     
		for(Method m : cl.getDeclaredMethods()) {      
			UseCase uc = m.getAnnotation(UseCase.class);     
			
			if(uc != null) {     
				
				System.out.println(uc.description());
				
				try {
					if((boolean) m.invoke(null, a))
						System.out.println("ERROR");
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}    
		}   
	}  


	
	public void ddddd() {    
		String cc = "AAAAAAA";
		trackUseCases(cc, PasswordUtils.class);   
	} 
	
	
	@Test
	public void ttttt() {
		
		Customer mCustomer1 = new Customer();
		Customer mCustomer2 = new Customer();
		Customer mCustomer3 = new Customer();
		
		mCustomer1.setName("Andrea");
		mCustomer1.setSurname("Graziani");
		mCustomer3.setEmail("aldo.giovanni.giacomo@pippo.it");
		
		mCustomer2.setName("A4dr3a");
		mCustomer2.setSurname("Asdfghhhhhhhhgjjfhdfdgfdshgfdsgfdsghfdsgfdsfdsfdsfdsfdsfdsfdsfdsfdsfdsfdsfdsfdsfdsfsdfds");
		
		mCustomer3.setName("aNDREA");
		mCustomer3.setSurname("Graxxxx");
		mCustomer3.setEmail("aldo.giovanni.giacomo.it");
		
		Set<ConstraintViolation<Customer>> mViolations1 = ApplicationValidation.validate(mCustomer1);
		Set<ConstraintViolation<Customer>> mViolations2 = ApplicationValidation.validate(mCustomer2);
		Set<ConstraintViolation<Customer>> mViolations3 = ApplicationValidation.validate(mCustomer3);
		
		assertEquals(0, mViolations1.size());
		assertEquals(2, mViolations2.size());
		assertEquals(2, mViolations3.size());
		
		for (ConstraintViolation<Customer> violation : mViolations2) 
			System.out.println("Violation2: " + violation.getMessage());	
		
		for (ConstraintViolation<Customer> violation : mViolations3) 
			System.out.println("Violation3: " + violation.getMessage());	
	}
}

