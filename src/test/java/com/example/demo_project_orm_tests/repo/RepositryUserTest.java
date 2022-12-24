package com.example.demo_project_orm_tests.repo;

import com.example.demo_project_orm_tests.DemoProjectOrmTestsApplication;
import com.example.demo_project_orm_tests.entity.User;
import com.example.demo_project_orm_tests.service.UserService;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import static org.junit.jupiter.api.Assertions.*;
//@DataJpaTest
//@RunWith(SpringRunner.class)  //używamy w Junit 4
@Testcontainers
@SpringBootTest(classes = {RepositryUser.class, UserService.class},
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
class RepositryUserTest {

    public static PostgreSQLContainer container = new PostgreSQLContainer(DockerImageName.parse("postgres:15-alpine"))
            .withUsername("userTest")
            .withPassword("1234")
            .withDatabaseName("dbtest");

    // > spring 2.2.6
    @DynamicPropertySource
    static void properties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", container::getJdbcUrl);
        registry.add("spring.datasource.username", container::getUsername);
        registry.add("spring.datasource.password", container::getPassword);
    }

    @Autowired
    UserService userService;

    @Autowired
    RepositryUser repositryUser;

    @Test
    public void firstTest() {
        repositryUser.save(new User());
        System.out.println("Udany!");
    }

}