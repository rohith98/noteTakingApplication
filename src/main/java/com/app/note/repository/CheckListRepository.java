package com.app.note.repository;

import com.app.note.entity.CheckList;
import com.app.note.entity.Title;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CheckListRepository extends JpaRepository<CheckList, Integer> {
   List<CheckList> findAllByTitle(Title title);

//    @Query("select c from CheckList c order by c.list_id desc limit 3")
//    List<CheckList> findLastThreeEntry();

//    List<CheckList> findFirst3ByOrderByListIdDesc();

}
