package com.java10.userService;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;

import com.java10.DTO.UserDTO;
import com.java10.module.User;
import com.java10.respository.UserRepository;

public class UserService {
	private UserRepository userRepository;
	public UserService() {
		userRepository = new UserRepository();
	}
	
	public List<UserDTO> getAllUser(){
		return userRepository.findAllJoin();	
	}
	
	public int insert(UserDTO dto) {
		String hashed = BCrypt.hashpw(dto.getPassword(), BCrypt.gensalt());

		User user	= new User();
		user.setAvatar(dto.getAvatar());
		user.setEmail(dto.getEmail());
		user.setFullname(dto.getFullname());
		user.setRole_id(dto.getRole_id());
		user.setPassword(hashed);
		return userRepository.insert(user);
	}
	
	public int delete(int id) {
		return userRepository.delete(id);
	}
	
	public int edit(UserDTO dto) {
		User user	= userRepository.findUserById(dto.getId());
		String pas =dto.getPassword();
		user.setAvatar(dto.getAvatar());
		user.setEmail(dto.getEmail());
		user.setFullname(dto.getFullname());
		user.setId(dto.getId());
		user.setRole_id(dto.getRole_id());
		if (pas != null)
			pas = BCrypt.hashpw(pas, BCrypt.gensalt());
		
		user.setPassword(pas);
		
		return userRepository.edit(user);
	}
	
	public UserDTO findUserById(int id) {
		User user = userRepository.findUserById(id);
		UserDTO dto = new UserDTO();
		dto.setAvatar(user.getAvatar());
		dto.setEmail(user.getEmail());
		dto.setFullname(user.getFullname());
		dto.setId(user.getId());
		dto.setRole_id(user.getRole_id());
		dto.setDesRole(null);
		dto.setPassword(null);
		return dto;
	}
	
	public UserDTO login(String email, String password) {
		return userRepository.login(email, password);
	}
	
}
