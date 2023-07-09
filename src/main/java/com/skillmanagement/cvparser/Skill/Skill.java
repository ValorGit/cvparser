package com.skillmanagement.cvparser.Skill;

import java.util.List;

import com.skillmanagement.cvparser.Skillproficiency.Skillproficiency;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "skill")
public class Skill {
    
@Id
@GeneratedValue
    private Long id;
    
    private String name;
    private String description;

    
    @OneToMany(mappedBy = "skill")
    List<Skillproficiency> skillproficiencies;
    
    public Skill(String name, String description){
        this.name = name;
        this.description = description;
    }

    public Skill(){

    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getDescription(){
        return this.description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    @Override
    public String toString(){
        return "id: " + this.id + " name: " + this.name + " description: " + this.description; 
    }
}
