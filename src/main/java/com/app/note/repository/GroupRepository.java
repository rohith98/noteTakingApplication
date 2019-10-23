package com.app.note.repository;

import com.app.note.entity.Group;
import com.app.note.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {
    List<Group> findAllByUser(User user);
}
