package com.ge.exercise1;

import java.util.Collection;
import java.util.List;

public class ApplicationImpl extends Application {
	
	private List<Group> groupsList;
	private List<User> usersList;

	public ApplicationImpl(String id, String name) {
		super(id, name);
	}

	@Override
	public Collection<User> getUsers() {
		return usersList;
	}

	@Override
	public User getUser(String userId) {
		User user = null;
		for(User u : usersList){
			if(u.getId().equals(userId))
				user = u;
		}
		return user;
	}

	@Override
	public Collection<Group> getGroups() {
		return groupsList;
	}

	@Override
	public Group getGroup(String groupId) {
		Group group = null;
		for(Group g : groupsList){
			if(g.getId().equals(groupId))
				group = g;
		}
		return group;
	}

	public List<Group> getGroupsList() {
		return groupsList;
	}

	public void setGroupsList(List<Group> groupsList) {
		this.groupsList = groupsList;
	}

	public List<User> getUsersList() {
		return usersList;
	}

	public void setUsersList(List<User> usersList) {
		this.usersList = usersList;
	}
	
	
	
	
	
	
	

}
