package com.example.authtemplate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class AuthtemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthtemplateApplication.class, args);
    }

    @Bean
    public CommandLineRunner startup(UserRepository repository, PasswordEncoder encoder) {
        return args -> {
            final String username = "user1";
            if (repository.findByUsername(username) == null) {
                final UserEntity user = new UserEntity();
                user.setUsername(username);
                user.setPassword(encoder.encode("secret"));
                user.setRole("USER");
                repository.save(user);
            }

            System.out.println(repository.findAll());

        };
    }
}
