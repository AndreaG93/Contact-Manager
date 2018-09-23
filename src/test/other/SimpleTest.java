package test.other;



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
		Testggg fff = new Testggg();
		fff.setUnsupported(true);
		
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		
		
		Set<ConstraintViolation<Testggg>> violations = validator.validate(fff);
		
		for (ConstraintViolation<Testggg> violation : violations) {
		    System.out.println(violation.getMessage());

		}
	}
}

