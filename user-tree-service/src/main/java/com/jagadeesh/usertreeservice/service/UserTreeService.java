package com.jagadeesh.usertreeservice.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jagadeesh.usertreeservice.advice.LogMethodParam;
import com.jagadeesh.usertreeservice.data.UserDetails;
import com.jagadeesh.usertreeservice.data.UserDetailsRepository;
import com.jagadeesh.usertreeservice.data.UserNest;

@Service
public class UserTreeService {
	
	@Autowired
	private UserDetailsRepository repo;

	@LogMethodParam
	public UserDetails fetchUserDetails(int userId) throws UserNotFoundException {
		return repo.findById(userId).orElseThrow(UserNotFoundException::new);
	}
	
	public List<UserNest> fetchUserNest() {
		List<UserDetails> users = repo.findAll();
		return buildUserNest(users);
	}
	
	private List<UserNest> buildUserNest(List<UserDetails> users){
		Map<Integer, UserNest> userIdMap = new HashMap<>();
		for(UserDetails user : users) {
			UserNest userNest = new UserNest(user.getName(), new ArrayList<UserNest>());
			userIdMap.put(user.getId(), userNest);
		}
		for(UserDetails user : users) {
			UserNest child = userIdMap.get(user.getId());
			UserNest parent = userIdMap.get(user.getParentId());
			if(parent!=null) parent.getSubClasses().add(child);
		}
		for(UserDetails user : users) {
			UserNest parent = userIdMap.get(user.getId());
			if(parent.getSubClasses().isEmpty())
				parent.setSubClasses(null);
		}
		return new ArrayList<UserNest>(userIdMap.values());
	}
	
	
}
