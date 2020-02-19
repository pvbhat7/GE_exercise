package com.ge.exercise1;

import java.util.ArrayList;
import java.util.List;

public class MyParser implements Parser{

	@Override
	public Application parseApplicationData(String data) {
		
		int flag1=data.indexOf(":");int flag2=data.indexOf(",");
		String applicationId = data.substring(flag1+1,flag2).replaceAll("\\s+","");
		flag1=data.indexOf(":", flag2+1);flag2=data.indexOf(",", flag2+1);
		String applicationName = data.substring(flag1+1,flag2).replaceAll("\\s+","");
		flag1=data.indexOf("[", flag2+1);flag2=data.indexOf("],", flag2+1);
		String users = data.substring(flag1+1,flag2).replaceAll("\\s+","");
		flag1=data.indexOf("[", flag2+1);flag2=data.lastIndexOf("]");
		String[] groupList = data.substring(flag1+1,flag2).replaceAll("\\s+","").split(",G");
		
		List<Group> groupsList = new ArrayList<>();			
		for(int i=0;i<groupList.length;i++){
			groupsList.add(fetchGroup(groupList[i],flag1,flag2));
		}		
		
		// creating application object
		ApplicationImpl applicationImpl = new ApplicationImpl(applicationId, applicationName);
		applicationImpl.setUsersList(fetchUsers(users,flag1,flag2));
		applicationImpl.setGroupsList(groupsList);
		return applicationImpl;
	
	}
	
	/*
	 * method to get list of users
	 * 
	 */
	private static List<User> fetchUsers(String users, int flag1, int flag2) {
		flag1=0;flag2=0;
		List<User> usersList = new ArrayList<User>();
		String[] arr=users.substring(0,users.length()-1).split("\\),");
		for(int i=0;i<arr.length;i++){
			flag1=arr[i].indexOf(":");flag2=arr[i].indexOf(",");
			String id = arr[i].substring(flag1+1,flag2).replaceAll("\\s+","");
			flag1=arr[i].indexOf(":", flag2+1);
			String name = arr[i].substring(flag1+1,arr[i].length()).replaceAll("(?!^)([A-Z])", " $1").replaceAll("\\)", "").replaceAll("\\]","");
			usersList.add(new UserImpl(id, name));			
		}
		return usersList;		
	}
	/*
	 *method to get list of groups 
	 */
	public static Group fetchGroup(String var, int flag1, int flag2){		
		flag1=var.indexOf(":");flag2=var.indexOf(",");
		String id = var.substring(flag1+1,flag2).replaceAll("\\s+","");
		flag1=var.indexOf(":",flag2);flag2=var.indexOf(",",flag1);
		String name = var.substring(flag1+1,flag2).replaceAll("\\s+","");
		GroupImpl group= new GroupImpl(id, name);
		String users = var.substring(var.indexOf("(",flag2),var.length());
		group.setUsersList(fetchUsers(users,flag1,flag2));
		return group;
	}

	
}
