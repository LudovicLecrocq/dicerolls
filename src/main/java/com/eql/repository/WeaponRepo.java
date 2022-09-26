package com.eql.repository;

import com.eql.models.Weapon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeaponRepo extends JpaRepository<Weapon,Long> {
}
