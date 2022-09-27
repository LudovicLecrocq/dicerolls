package com.eql.repository;

import com.eql.models.Armour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ArmourRepo extends JpaRepository<Armour,Long> {
    @Query(value = "Select * from armour where a_name = :name",nativeQuery = true)
    Armour findByName(@Param(value = "name") String name);
}
