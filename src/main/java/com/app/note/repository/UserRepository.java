package com.app.note.repository;

import com.app.note.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUserName(String userName);

    Optional<User> findByUserNameAndPassword(String userName, String password);
}

