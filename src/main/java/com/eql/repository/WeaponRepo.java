package com.eql.repository;

import com.eql.models.Weapon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WeaponRepo extends JpaRepository<Weapon,Long> {
    @Query(value = "Select * from weapon where w_name = :name",nativeQuery = true)
    Weapon findByName(@Param(value = "name") String name);
}
