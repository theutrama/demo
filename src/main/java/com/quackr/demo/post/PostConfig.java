package com.quackr.demo.post;

import com.quackr.demo.user.User;
import com.quackr.demo.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PostConfig {

    @Bean
    CommandLineRunner commandLineRunnerPost(PostRepository repository){
        return args -> {
            String newPost = "Dies ist ein TestPost";
            new Post(new User("postUser", "postUser", "postUser", "postUser"), newPost);
        };
    }
}
