package com.app.note.repository;

import com.app.note.entity.Note;
import com.app.note.entity.Title;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<Note, Integer> {
    Note findByTitle(Title title);

//   @Query("select n from Note n where n.titleId = :titleId")
//    Note findByTitleId(@Param("titleId") Title titleId);

}
