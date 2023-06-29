package com.skillmanagement.cvparser.Proficiency;

import java.util.List;

import com.skillmanagement.cvparser.Skillproficiency.Skillproficiency;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Proficiency {
    public Proficiency(String level) {
        this.level = level;
    }
    public Proficiency(String level, String description) {
        this.level = level;
        this.description = description;
    }
    public Proficiency(Long id, String level, String description) {
        this.id = id;
        this.level = level;
        this.description = description;
    }
    
    @Id
    @GeneratedValue
    private Long id;
    
    private String level;
    private String description;

    @OneToMany(mappedBy = "proficiency")
    List<Skillproficiency> skillproficiencies;

    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getLevel() {
        return level;
    }
    public void setLevel(String level) {
        this.level = level;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public String toString() {
        return "Proficiency [id=" + id + ", level=" + level + ", description=" + description + "]";
    }

    
}
