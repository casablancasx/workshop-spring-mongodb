package com.danilochaves.workshopmongodb.service;

import com.danilochaves.workshopmongodb.dto.UserDTO;
import com.danilochaves.workshopmongodb.entities.User;
import com.danilochaves.workshopmongodb.repositories.UserRepository;
import com.danilochaves.workshopmongodb.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        List<User> list = repository.findAll();
        return list;
    }

    public User findById(String id){
       Optional<User> obj = repository.findById(id);
       return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User insert(User obj){
        return repository.insert(obj);
    }

    public User fromDto(UserDTO obj){
        return new User(obj.getId(), obj.getName(), obj.getEmail());
    }
}
