package com.ge.exercise1;

/**
 * 
 * @author Prashant Bhat
 * UserImpl class is extended from User class because at later stage 
 * we need to create object of UserImpl , with User class it won't
 * be possible because its abstract class
 * This class has main purpose of creation of User object only
 *
 */
public class UserImpl extends User{

	public UserImpl(String id, String name) {
		super(id, name);
	}

}
