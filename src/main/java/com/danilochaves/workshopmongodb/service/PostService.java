package com.danilochaves.workshopmongodb.service;

import com.danilochaves.workshopmongodb.dto.UserDTO;
import com.danilochaves.workshopmongodb.entities.Post;
import com.danilochaves.workshopmongodb.entities.User;
import com.danilochaves.workshopmongodb.repositories.PostRepository;
import com.danilochaves.workshopmongodb.repositories.UserRepository;
import com.danilochaves.workshopmongodb.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository repository;

    public List<Post> findAll(){
        List<Post> list = repository.findAll();
        return list;
    }

    public Post findById(String id){
       Optional<Post> obj = repository.findById(id);
       return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Post> findByTitle(String text){
        return repository.findByTitleContainingIgnoreCase(text);
    }

}
