package com.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class userDaoService {
	private static List<user> users = new ArrayList<>(); 
	
	private int usersCounter=3;

	static {
		users.add(new user(1,"Adam",new Date()));
		users.add(new user(2,"Eve",new Date()));
		users.add(new user(3,"Jack",new Date()));
		//users.add(new user(4,"ram",new Date()));
	}
	
	public List<user> findAll() {
		return users;
	}
	public user Save(user user) {
		if(user.getId()==null) {
			user.setId(++usersCounter);
		}
		users.add(user);
		return user;
	}
	public user findOne(int id) {
		for(user user:users) {
			if(user.getId()==id) {
				return user;
			}
		}
		return null;
	}
	public user deleteById(int id) {
		Iterator<user> iterator = users.iterator();
		while (iterator.hasNext()) {
			user user = iterator.next();
			if (user.getId() == id) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}

}
