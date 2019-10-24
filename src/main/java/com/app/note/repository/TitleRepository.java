package com.app.note.repository;

import com.app.note.entity.Group;
import com.app.note.entity.Title;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TitleRepository extends JpaRepository<Title, Integer> {
    List<Title> findAllByGroup(Group group);

    @Query("SELECT t FROM Title t WHERE t.titleName LIKE %:search%")
    List<Title> findByName(@Param("search") String search);

}
