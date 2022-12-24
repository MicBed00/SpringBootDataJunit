package com.example.demo_project_orm_tests.repo;

import com.example.demo_project_orm_tests.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositryUser extends JpaRepository<User, Integer> {
}
