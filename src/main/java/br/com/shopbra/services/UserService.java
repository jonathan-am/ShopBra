package br.com.shopbra.services;

import br.com.shopbra.dto.UpdateUserRequestDTO;
import br.com.shopbra.dto.UserDTO;
import br.com.shopbra.entity.user.User;

public interface UserService {
	
	public UserDTO getUserById(String id);
	
	public UserDTO createUser(User ref);
	
	public UserDTO updateUser(String id, UpdateUserRequestDTO request);
	
	public UserDTO updateUser(String id, String password);
	

}
