package com.app.note.repository;

import com.app.note.entity.Group;
import com.app.note.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {
    List<Group> findAllByUser(User user);

//    @Query("SELECT g FROM Group g WHERE g.groupName LIKE %:search%")
//    List<Group> findByName(@Param("search") String search);

//    @Query(name="select g.group_id,g.group_name from notes.groups g where g.group_name like #search union select g.group_id,g.group_name from notes.groups g join notes.titles t on g.group_id=t.group_id join notes.notes n on n.title_id=t.title_id where n.message like #search",nativeQuery = true)
//    List<Object[]> findByName(@Param("search") String search);

    @Query("SELECT g FROM Group g LEFT JOIN Title t ON g.groupId=t.group.groupId "
            +"LEFT JOIN Note n ON n.title.titleId=t.titleId WHERE g.groupName LIKE %:search% "
            +"OR t.titleName LIKE %:search% OR n.message LIKE %:search%")
    List<Group> findByName(@Param("search") String search);
}
