package com.example.pawpalandiaDB.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pawpalandiaDB.exceptions.UserNotFoundException;
import com.example.pawpalandiaDB.model.UserEntity;
import com.example.pawpalandiaDB.repository.UserRepository;

@Service
public class UserService {
    //Instanciar UserRepository
    private final UserRepository userRepository;
    
    @Autowired
    //Inyectar en el constructor
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //Método para obtener todos los usuarios
    public List<UserEntity> getAll() {
        return userRepository.findAll();
    }

    //Metodo para obtener un usuario por id
    public UserEntity getById(Long id) {
		return this.userRepository.findById(id)
				.orElseThrow(()-> new UserNotFoundException(id));
	}
	
	//Método para crear un nuevo usuario
	public UserEntity createUser(UserEntity newUser) {
		return this.userRepository.save(newUser);
	} 
	
	//Método para eliminar un usuario mediante id 
	public void deleteUser(Long id) {
		if (this.userRepository.existsById(id)) {
			this.userRepository.deleteById(id);
		} else {
			throw new UserNotFoundException(id);
		}
	}

	//Método para recuperar un nuevo usuario mediante email
	public UserEntity getByEmail(String email) {
		return this.userRepository.getByEmail(email);
	}

	//Método para actualizar un usuario usando mapeo en PUT
	public UserEntity updateUser(UserEntity user, Long id) {
		return userRepository.findById(id).map(userMap ->{
			userMap.setName(user.getName());
			userMap.setMiddleName(user.getMiddleName());
			userMap.setLastName(user.getLastName());
			userMap.setBirthDay(user.getBirthDay());
			userMap.setPhoneNumber(user.getPhoneNumber());
			userMap.setEmail(user.getEmail());
			userMap.setPassword(user.getPassword());
			userMap.setIsVip(user.getIsVip());
			userMap.setPrivacyPolicyAccepted(user.getPrivacyPolicyAccepted());
			return userRepository.save(userMap);
		})
		.orElseThrow(()->new UserNotFoundException(id));
	}

}
