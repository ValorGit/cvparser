package com.skillmanagement.cvparser.Competence;

import java.util.List;

import com.skillmanagement.cvparser.Employee.Employee;
import com.skillmanagement.cvparser.Skill.Skill;
import com.skillmanagement.cvparser.Skillproficiency.Skillproficiency;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


// public class Competence {

//     @Id
//     @SequenceGenerator(
//         name = "competence_sequence",
//         sequenceName = "competence_sequence",
//         allocationSize = 1
//     )
//     @GeneratedValue(
//         strategy = GenerationType.SEQUENCE,
//         generator = "competence_sequence"
//     )
//     @Column(name = "id")
//     private Long id;

//     @OneToOne(mappedBy = "competence")
//     private Employee employeeId;
//     private List<Skillproficiency> skills;
    
//     public Competence(Employee employeeId) {
//         this.employeeId = employeeId;
//     }

//     public Competence(Long id, Employee employeeId, List<Skillproficiency> skills) {
//         this.id = id;
//         this.employeeId = employeeId;
//         this.skills = skills;
//     }

//     public Competence(Employee employeeId, List<Skillproficiency> skills) {
//         this.employeeId = employeeId;
//         this.skills = skills;
//     }

//     public Long getId() {
//         return id;
//     }

//     public Employee getEmployeeId() {
//         return employeeId;
//     }

//     public List<Skillproficiency> getskills() {
//         return skills;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public void setEmployeeId(Employee employeeId) {
//         this.employeeId = employeeId;
//     }

//     public void setskills(List<Skillproficiency> skills) {
//         this.skills = skills;
//     }

    
// }
