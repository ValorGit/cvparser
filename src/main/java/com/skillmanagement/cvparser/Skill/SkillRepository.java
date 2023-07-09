package com.skillmanagement.cvparser.Skill;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SkillRepository extends JpaRepository<Skill, Long>{

    @Query("SELECT s FROM Skill s WHERE s.name =?1")
    Optional<Skill> findSkillByName(String name);
    
    
}
