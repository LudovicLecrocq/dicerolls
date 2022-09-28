package com.eql.repository;

import com.eql.models.Personnage;
import com.eql.models.Session;
import com.eql.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersoRepo extends JpaRepository<Personnage,Long> {

    @Query(value = "Select * from personnage where user_id = :id",nativeQuery = true)
    List<Personnage> findAllByUser(@Param("id") Long id);

    @Query(value = "Select * from personnage where nom = :pName",nativeQuery = true)
    Personnage findByName(@Param("pName")String sName);

}
