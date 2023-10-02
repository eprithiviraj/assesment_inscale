package com.payload;

import com.pojo.Create_User;
import com.pojo.Update_User;

public class Payloads {
	
	public Create_User createUser(int id, String username,String firstName,String lastName,String email,String password,String phone,int userStatus) {
		
		Create_User create_user_input=new Create_User(id, username, firstName, lastName, email, password, phone, userStatus); 
		return create_user_input;
	}
	public Update_User updateUser(int id, String username,String firstName,String lastName,String email,String password,String phone,int userStatus) {
		
		Update_User create_user_input=new Update_User(id, username, firstName, lastName, email, password, phone, userStatus); 
		return create_user_input;
	}

}
