package com.quackr.demo.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;


@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunnerUser(UserRepository repository){
        return args -> {
            User alan = new User("Alan", "Turing", "alan@turing.com", "aturing");

            User kobe = new User("Kobe", "Bryant", "kobe@bryant.com", "kbryant");

            repository.saveAll(List.of(alan, kobe));

        };
    }
}

