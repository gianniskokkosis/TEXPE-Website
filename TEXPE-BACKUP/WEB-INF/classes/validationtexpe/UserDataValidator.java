package validationtexpe;

import texpeclasses.*;

public class UserDataValidator{

	/**
	 * A method to validate user's Name. 
	 * 
	 * @param name, String
	 * @return boolean, true if is valid, false	if is not.
	 */
	public boolean isNameValid(String name) {
		
		return (name == null || name.length() < 3 || name.length() > 45 ? false : true);

	}

	/**
	 * A method to validate user's Surname. 
	 * 
	 * @param surname, String
	 * @return boolean, true if is valid, false	if is not.
	 */
	public boolean isSurnameValid(String surname) {
		
		return (surname == null || surname.length() < 3 || surname.length() > 45  ? false : true);

	}

	/**
	 * A method to validate user's Username. 
	 * 
	 * @param username, String
	 * @return boolean, true if is valid, false	if is not.
	 */
	
	public boolean isUsernameValid(String username){
		
		return (username == null || username.length() < 3 || username.length() > 20  ? false : true);
	}
	
	/**
	 * A method to validate user's email. 
	 * 
	 * @param email, String
	 * @return boolean, true if is valid, false	if is not.
	 */
	public boolean isValidEmailAddress(String email) {

		//Reference: https://stackoverflow.com/questions/624581/what-is-the-best-java-email-address-validation-method
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);

        return m.matches();
	}
	
	public boolean isPasswordValid(String password){
		
		return (password == null || password.length() < 5 || password.length() > 20 ? false : true);
	}
	
	public boolean isConfirmationValid(String confirm , String password){
		
		return (confirm == null || password.equals(confirm) ? false : true);
	}
	
	public boolean userExist(String username) throws Exception{
		
		UserDAO udao = new UserDAO();
		try{
			if (udao.findUser(username) == null){
				return true;
			}else{
				return false;
		}
		}catch(Exception ex){
			throw new Exception("An error occured while finding users.");
		}
	}
	
	public boolean isNotificationsValid(String aggree){
		
		if (aggree==null){
			return false;
		}else{
			return true;
		}
	}
}