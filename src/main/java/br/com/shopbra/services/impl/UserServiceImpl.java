package br.com.shopbra.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import br.com.shopbra.dto.UpdateUserRequestDTO;
import br.com.shopbra.dto.UserDTO;
import br.com.shopbra.entity.user.User;
import br.com.shopbra.exceptions.TypeNotFoundException;
import br.com.shopbra.exceptions.UpdateUserException;
import br.com.shopbra.exceptions.UserNotFoundException;
import br.com.shopbra.repository.UserRepository;
import br.com.shopbra.services.UserService;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class UserServiceImpl implements UserService{
	
	
	@Autowired
	private UserRepository repo;
	
	@Override
	@Cacheable(value = "user",key = "#id ")
	public UserDTO getUserById(String id) {
		log.info("UserService.getUserById - start - id: [{}]", id);
		User u = repo.getUserById(id).orElseThrow(()->new UserNotFoundException("User Not Found"));
		UserDTO response = new UserDTO(u);
		log.info("UserService.getUserById - end - id: [{}], user: [{}]", id, response);
		return response;
	}

	@Override
	@CachePut(value = "user", key = "#ref.id")
	public UserDTO createUser(User ref) {
		log.info("UserService.createUser - start - id: [{}]", ref.getId());
		validateCustomerType(ref.getType().getUserType().toString());
		UserDTO response = new UserDTO(repo.save(ref));
		log.info("UserService.createUser - end sucess - response: [{}]", response);
		return response;
	}
	
	@Override
	@CacheEvict(value = "user", key = "#id")
	public UserDTO updateUser(String id, UpdateUserRequestDTO request) {
		log.info("UserService.updateUser - start - id: [{}], request: [{}]", id, request);
		User user = repo.getUserById(id).orElseThrow(()->new UserNotFoundException("User Not Found"));
		
		if(request.getName()!=null && !request.getName().isEmpty()) { 
			user.setName(request.getName());
		}
		if((request.getCustomProperty()!=null && request.getCustomProperty().getId()!=null&&request.getCustomProperty().getValue()!=null)) {
			if(user.getCustomProperties().contains(request.getCustomProperty())) {
				user.getCustomProperties().forEach(v ->{if(v == request.getCustomProperty()) user.getCustomProperties().remove(v);});
			}
			user.getCustomProperties().add(request.getCustomProperty());
		}
		repo.saveAndFlush(user);
		UserDTO response = new UserDTO(user);
		log.info("UserService.updateUser - end - id: [{}], response: [{}]", id, response);
		return response;
	}
	
	@Override
	@CacheEvict(value = "user", key = "#id")
	public UserDTO updateUser(String id, String password) {
		log.info("UserService.updateUser - start - id: [{}], password: [{}]", id, hidePassword(password));
		User user = repo.getUserById(id).orElseThrow(()->new UserNotFoundException("User Not Found"));
		
		if(password!=null && !password.isEmpty()) {
			user.setPassword(password);
		}else {
			throw new UpdateUserException("Password cannot be used.");
		}
		
		repo.saveAndFlush(user);
		UserDTO response = new UserDTO(user);
		
		return response;
	}
	
	private String hidePassword(String password) {
		String[] old = password.split("(?!^)");
		String result = "";
		for(int i = 0; i < 6 ; i++) {
			old[i] = "*";
		}
		for(int x = 0; x < old.length; x++) {
			result = result+old[x];
		}
		return result;
	}
	
	
	private void validateCustomerType(String customerType) {
		switch(customerType) {
			case "ADMIN":
				break;
			case "CUSTOMER":
				break;
			case "DEFAULT":
				break;
			default:
				log.error("UserService.createUser - error - message: `Type Not Found` customerType: [{}]", customerType);
				throw new TypeNotFoundException("Type Not Found");
		}
	}

}
