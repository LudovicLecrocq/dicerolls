package com.eql.repository;

import com.eql.models.Stat;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface StatRepo extends JpaRepository<Stat,Long> {


}
