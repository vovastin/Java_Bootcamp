package edu.school21.services;

import edu.school21.exceptions.AlreadyAuthenticatedException;
import edu.school21.models.User;
import edu.school21.repositories.UsersRepository;

public class UsersServiceImpl {
	
	UsersRepository usersRepository;

	public UsersServiceImpl(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}

	boolean authenticate(String login, String password) {
		User user = usersRepository.findByLogin(login);
		
		if (user.getAuthStatus()) {
			throw new AlreadyAuthenticatedException();
		}

		if (user.getPassword().equals(password)) {
			user.setAuthStatus(true);
			usersRepository.update(user);
			return true;
		}
		return false;
	}

}
