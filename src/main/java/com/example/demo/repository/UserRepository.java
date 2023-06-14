package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.vo.UserVO;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserRepository {

	private List<UserVO> generateUsers() {
		
		List<UserVO> users = new ArrayList<>();
		
		for(int i = 0; i < 10; i++) {
			
			int userID = i + 1;
			String username = String.format("Usuário %s", userID);
			String email = String.format("usuario-%s@gmail.com", userID);
			
			UserVO user = new UserVO(userID, username, email);
			
			users.add(user);
			
		}
		
		return users;
		
	}
	
	public List<UserVO> getAll() {
		
		return this.generateUsers();
		
	}
	
	public UserVO getById(int id) {
		
		List<UserVO> users = this.generateUsers();
		
		List<UserVO> result = users.stream().filter(user -> user.getId() == id).toList();
		
		if (result.isEmpty()) {
			return null;
		} else {
			return result.get(0);
		}
		
	}
	
}
