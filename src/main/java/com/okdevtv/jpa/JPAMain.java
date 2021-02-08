package com.okdevtv.jpa;

import com.okdevtv.jpa.model.UserEntity;
import com.okdevtv.jpa.model.UserRole;
import com.okdevtv.jpa.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class JPAMain{
        public static void main(String[] args) {
                ConfigurableApplicationContext context = SpringApplication.run(JPAMain.class, args);
                UserRepository userRepository = context.getBean(UserRepository.class);

                userRepository.save(new UserEntity("Kenu", 50, UserRole.ADMIN));
                UserEntity user = userRepository.findByUserName("Kenu");
                System.out.println("나이:" + user.getAge() + "," + "이름:" + user.getUserName() + "," + "생성일:" + user.getCreatedAt());
        }
}

