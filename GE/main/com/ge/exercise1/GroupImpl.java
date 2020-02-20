package com.ge.exercise1;

import java.util.List;

/**
 * 
 * @author Prashant Bhat
 * GroupImpl class is extended from Group class because at later stage 
 * we need to create object of GroupImpl , with Group class it won't
 * be possible because its abstract class
 * This class has list of users
 *
 */
public class GroupImpl extends Group {

	private List<User> usersList;
	
	public GroupImpl(String id, String name) {
		super(id, name);
	}

	public List<User> getUsersList() {
		return usersList;
	}

	public void setUsersList(List<User> usersList) {
		this.usersList = usersList;
	}
	
	

}
