package com.devops.capstone.service;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.devops.capstone.db.UserDb;
import com.devops.capstone.model.User;

public class UserService {
	UserDb userDb;
	public UserService(){
		userDb=new UserDb();
	}
	
	public boolean isAuthorized(User signup){
		boolean isValidUser=false;
		
		if(signup!=null && signup.getEmail()!=null && signup.getPassword()!=null){
			 Set entrySet = userDb.userProfile.entrySet();
			 Iterator it = entrySet.iterator();
			 
			 while(it.hasNext()){
				 Map.Entry u = (Map.Entry)it.next();
					//System.out.println(u.getKey()+"\t"+u.getValue());
				 if(u.getKey().equals(signup.getEmail())){
					 isValidUser=true;
				 }
			 }	
		}		
		
		return isValidUser;
	}

	
	public boolean updatePassword(User user){
		boolean isUpdated=false;
		if(user!=null && user.getEmail()!=null){
			
			for (Map.Entry<String, User> entry : userDb.userProfile.entrySet()) {
				 if(entry.getKey().equals(user.getEmail())){
					 user.setFirstName(entry.getValue().getFirstName());
					 user.setLastName(entry.getValue().getLastName());
					 user.setEmail(entry.getValue().getEmail());
					 user.setPassword(user.getPassword());
					 entry.setValue(user);
					 isUpdated=true;
					 //System.out.println(user);
				 }				
			}
			

		}
		return isUpdated;
		
	}
	
	public boolean doRegistration(User user){
		boolean isCreated=false;
		if(user!=null && user.getEmail()!=null){			
			userDb.userProfile.put(user.getEmail(), user);
			isCreated=true;		
			System.out.println("Number of records available: "+userDb.userProfile.size());
		}
		return isCreated;
	}

}
