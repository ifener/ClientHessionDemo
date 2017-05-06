package com.ken.service.impl;

import com.ken.service.IHessianService;

import java.util.ArrayList;
import java.util.List;
import com.ken.entity.User;

public class HessianServiceImpl implements IHessianService {

	static List<User> list = new ArrayList<User>();

	static {
		list.add(new User(1, "Ken", "Male"));
		list.add(new User(2, "Jack", "Male"));
		list.add(new User(3, "Lucy", "Male"));
		list.add(new User(4, "Michael", "Male"));
		list.add(new User(5, "Pearl", "Female"));
	}

	public User getUserById(int id) {
		for (User u : list) {
			if (u.getId() == id) {
				return u;
			}
		}
		return null;
	}

}
