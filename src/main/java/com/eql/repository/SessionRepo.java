package com.eql.repository;

import com.eql.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepo extends JpaRepository<Session,Long> {

    @Query(value = "Select * from session where s_name = :sName",nativeQuery = true)
    Session findBySName(@Param("sName")String sName);
}
