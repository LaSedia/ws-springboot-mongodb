package com.battesini.wsmongodb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.battesini.wsmongodb.domain.User;
import com.battesini.wsmongodb.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll()	{
		return repo.findAll();
	}

}
