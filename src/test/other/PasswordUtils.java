package test.other;


public class PasswordUtils 
{   
	@UseCase(id = 47, description = "Passwords must contain at least one numeric")   
	public static boolean validatePassword(String password) 
	{     
		return (password.matches("\\w*\\d\\w*"));   
	}  

	@UseCase(id = 48, description = "Password long 44")   
	public static boolean isLong(String password) {    
		return password.length() >= 40;
				
				
 }  


}