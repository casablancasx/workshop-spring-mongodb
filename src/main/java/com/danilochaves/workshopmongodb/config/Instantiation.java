package com.danilochaves.workshopmongodb.config;

import com.danilochaves.workshopmongodb.dto.AuthorDTO;
import com.danilochaves.workshopmongodb.entities.Post;
import com.danilochaves.workshopmongodb.entities.User;
import com.danilochaves.workshopmongodb.repositories.PostRepository;
import com.danilochaves.workshopmongodb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private UserRepository userReposiroty;

    @Autowired
    private PostRepository postReposiroty;

    @Override
    public void run(String... arg0) throws Exception {


        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");




        userReposiroty.deleteAll();
        postReposiroty.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userReposiroty.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, LocalDate.parse("23/03/2018",dtf), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
        Post post2 = new Post(null, LocalDate.parse("22/03/2018",dtf), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));

        postReposiroty.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1, post2));
        userReposiroty.save(maria);
    }
}
