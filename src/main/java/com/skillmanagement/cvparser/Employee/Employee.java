package com.skillmanagement.cvparser.Employee;

import java.util.ArrayList;
import java.util.List;

import com.skillmanagement.cvparser.Proficiency.Proficiency;
import com.skillmanagement.cvparser.Skill.Skill;
import com.skillmanagement.cvparser.Skillproficiency.Skillproficiency;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {

     @Id
    @SequenceGenerator(
        name = "employee_sequence",
        sequenceName = "employee_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "employee_sequence"
    )
    @Column(name = "employee_id")
    private Long id;
    private String name;
    private String email;

@ManyToMany(cascade = CascadeType.ALL)
@JoinTable(
  name = "competence", 
  joinColumns = @JoinColumn(name = "employee_id"), 
  inverseJoinColumns = @JoinColumn(name = "skillproficiency_id"))
    private List<Skillproficiency> competence;

    
    public Employee(String name, String email, List<Skillproficiency> competence) {
    this.name = name;
    this.email = email;
    this.competence = competence;
}

    public Employee(String name, String email) {
        this.name = name;
        this.email = email;

        List<Skillproficiency> competence = new ArrayList<>();
        competence.add(new Skillproficiency(new Skill("Programmieren", "Etwas Programmieren"), new Proficiency("Experte")));

    }

    public Employee(Long id, String name, String email, List<Skillproficiency> competence) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.competence = competence;
    }

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public List<Skillproficiency> getCompetence(){
        return this.competence;
    }

    public void setCompetenece(List<Skillproficiency> competence){
        this.competence = competence;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void addSkill(List<Skillproficiency> skills){
        competence.addAll(skills);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((competence == null) ? 0 : competence.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Employee other = (Employee) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (competence == null) {
            if (other.competence != null)
                return false;
        } else if (!competence.equals(other.competence))
            return false;
        return true;
    }
    
}
