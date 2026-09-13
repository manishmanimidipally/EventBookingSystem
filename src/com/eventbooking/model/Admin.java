package com.eventbooking.model;

public class Admin extends User {
	
	private String adminRole;
	
	public Admin() {
		super();
	}
	
	public Admin(int userId, String name, String email,String password, String phone, String adminRole) {

       super(userId, name, email, password, phone);
       this.adminRole = adminRole;
     }
	
	 public String getAdminRole() {
	        return adminRole;
	    }

	 public void setAdminRole(String adminRole) {
	        this.adminRole = adminRole;
	    }

	 @Override
	    public String toString() {
	        return "Admin{" +
	                "userId=" + getUserId() +
	                ", name='" + getName() + '\'' +
	                ", email='" + getEmail() + '\'' +
	                ", adminRole='" + adminRole + '\'' +
	                '}';
	    }
	 
	 
	 
	 
	 
	
}
