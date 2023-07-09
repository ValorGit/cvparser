package com.skillmanagement.cvparser.Skill;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skillmanagement.cvparser.Skill.Skill;
import com.skillmanagement.cvparser.Skill.SkillService;

    @RestController
@RequestMapping(path = "api/v1/skill")
public class SkillController {



        private final SkillService SkillService;

    @Autowired
    public SkillController(SkillService SkillService) {
        this.SkillService = SkillService;
    }

    @GetMapping
	public List<Skill> getSkills(){
		return SkillService.getSkills();
	}

    @PostMapping
    public void registerNewSkill(@RequestBody Skill Skill){
        SkillService.addNewSkill(Skill);
    }

    @DeleteMapping(path = "{SkillId}")
    public void deleteSkill(@PathVariable("SkillId") Long SkillId){
        SkillService.deleteSkill(SkillId);

    }

    @PutMapping(path = "{SkillId}")
    public void updateSkill(
        @PathVariable("SkillId") Long SkillId, 
        @RequestParam(required = false) String name, 
        @RequestParam(required = false) String email){
        
        SkillService.updateSkill(SkillId, name, email);
    }
    
}

    

