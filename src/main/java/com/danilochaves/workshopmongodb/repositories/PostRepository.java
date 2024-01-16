package com.danilochaves.workshopmongodb.repositories;

import com.danilochaves.workshopmongodb.entities.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post,String> {
}
