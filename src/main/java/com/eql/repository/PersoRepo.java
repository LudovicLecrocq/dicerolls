package com.eql.repository;

import com.eql.models.Personnage;
import com.eql.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersoRepo extends JpaRepository<Personnage,Long> {

//    @Query("From User Where ")
//    User findUserById(@Param("id") long id);
}
