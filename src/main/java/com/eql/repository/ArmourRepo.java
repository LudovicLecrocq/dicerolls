package com.eql.repository;

import com.eql.models.Armour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArmourRepo extends JpaRepository<Armour,Long> {
}
