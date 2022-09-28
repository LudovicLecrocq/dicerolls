package com.eql.repository;

import com.eql.models.Enemy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EnemyRepo extends JpaRepository<Enemy,Long> {
    @Query(value = "Select * from enemy where e_name = :nameE",nativeQuery = true)
    Enemy findByName(@Param(value = "nameE") String name);
}
