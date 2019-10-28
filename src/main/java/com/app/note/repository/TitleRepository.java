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
    List<Title> searchByName(@Param("search") String search);

    @Query("SELECT t FROM Title t "
        +"LEFT JOIN Note n ON n.title.titleId=t.titleId LEFT JOIN CheckList l on l.title.titleId=t.titleId "
        +"WHERE t.titleName LIKE %:search% OR n.message LIKE %:search% OR l.listName LIKE %:search%")
    List<Title> searchAll(@Param("search") String search);

}
