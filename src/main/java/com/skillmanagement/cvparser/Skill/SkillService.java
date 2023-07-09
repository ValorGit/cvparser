package com.skillmanagement.cvparser.Skill;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import com.skillmanagement.cvparser.Skill.Skill;
import com.skillmanagement.cvparser.Skill.SkillRepository;

public class SkillService {

         private final SkillRepository SkillRepository;


	public SkillService(SkillRepository SkillRepository) {
        this.SkillRepository = SkillRepository;
    }


    public List<Skill> getSkills(){
		return SkillRepository.findAll();
	}


    public void addNewSkill(Skill Skill) {
        Optional<Skill> SkillByName =
        SkillRepository.findSkillByName(Skill.getName());
        if(SkillByName.isPresent()) {
            throw new IllegalStateException("Skill name is taken");
        }
        SkillRepository.save(Skill);
        System.out.println(Skill);

    }


    public void deleteSkill(Long SkillId) {
        boolean Skillexists = SkillRepository.existsById(SkillId);
        if(!Skillexists){
            throw new IllegalStateException("Skill with id" + SkillId + "does not exist");
        }
        SkillRepository.deleteById(SkillId);
    }

    @Transactional
    public void updateSkill(Long SkillId, String name, String description) {
          Skill Skill =  SkillRepository.findById(SkillId).orElseThrow(() -> new IllegalStateException("Skill with id" + SkillId + "does not exist"));
        
        if(name != null && name.length() != 0 && !Objects.equals(name, Skill.getName())){
            Skill.setName(name);
        }

        if(description != null && description.length() != 0 && !Objects.equals(description, Skill.getDescription())){
       Skill.setDescription(description);
        }
      
    }
    
    
}
    

