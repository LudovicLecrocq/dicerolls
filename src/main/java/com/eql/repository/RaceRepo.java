package com.eql.repository;

import com.eql.models.Race;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RaceRepo extends JpaRepository<Race,Long> {

    @Query(value = "Select * from race Where label = :labelR",nativeQuery = true)
    Race findByLabel(@Param(value = "labelR") String label);

}
