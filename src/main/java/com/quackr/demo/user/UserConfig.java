package com.quackr.demo.user;

import com.quackr.demo.post.Post;
import com.quackr.demo.post.PostRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;


@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunnerUser(UserRepository repository, PostRepository postRep){
        return args -> {
            User alan = new User("Alan", "Turing", "alan@turing.com", "aturing");

            User kobe = new User("Kobe", "Bryant", "kobe@bryant.com", "kbryant");

            Post post1 = new Post("TestPost1");
            Post post2 = new Post("TestPost2");

            kobe.setPosts(List.of(post1,post2));

            post1.setUser(kobe);

            post2.setUser(alan);

            postRep.saveAll(List.of(post1,post2));
            repository.saveAll(List.of(alan, kobe));



        };
    }
}
