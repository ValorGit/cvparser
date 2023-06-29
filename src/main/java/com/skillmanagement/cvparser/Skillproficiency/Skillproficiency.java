package com.skillmanagement.cvparser.Skillproficiency;

import java.util.List;

import com.skillmanagement.cvparser.Employee.Employee;
import com.skillmanagement.cvparser.Proficiency.Proficiency;
import com.skillmanagement.cvparser.Skill.Skill;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "skillproficiency")
public class Skillproficiency {

    
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skill skill;

    @ManyToOne
    @JoinColumn(name ="proficiency_id")
    private Proficiency proficiency;

    @ManyToMany(mappedBy = "competence")
    private List<Employee> ownedBy;

    public Skillproficiency(){
        
    }

    public Skillproficiency(Skill skill, Proficiency proficiency){
        this.skill = skill;
        this.proficiency = proficiency;
    }

    public Long getId() {
        return id;
    }

    public Skill getSkill() {
        return skill;
    }

    public Proficiency getProficiency() {
        return proficiency;
    }

    public List<Employee> getOwnedBy() {
        return ownedBy;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public void setProficiency(Proficiency proficiency) {
        this.proficiency = proficiency;
    }

    public void setOwnedBy(List<Employee> ownedBy) {
        this.ownedBy = ownedBy;
    }
    
}
