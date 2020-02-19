package com.ge.exercise1;

import java.util.List;

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
