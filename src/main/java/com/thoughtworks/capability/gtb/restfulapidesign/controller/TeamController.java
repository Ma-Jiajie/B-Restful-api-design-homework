package com.thoughtworks.capability.gtb.restfulapidesign.controller;

import com.thoughtworks.capability.gtb.restfulapidesign.controller.requestdto.TeamRequestDTO;
import com.thoughtworks.capability.gtb.restfulapidesign.dataBaseTest.TeamStudentInit;
import com.thoughtworks.capability.gtb.restfulapidesign.model.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.model.Team;
import com.thoughtworks.capability.gtb.restfulapidesign.service.StudentService;
import com.thoughtworks.capability.gtb.restfulapidesign.service.TeamService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping
@Validated
public class TeamController {

    private final StudentService studentService;
    private final TeamService teamService;

    public TeamController(StudentService studentService, TeamService teamService) {
        this.studentService=studentService;
        this.teamService=teamService;
    }

    @GetMapping("/Teams")
    public List<Team> separate() {
        TeamStudentInit.clearTeamStudents();
        List<Student> students = studentService.getAllStudents();
        Collections.shuffle(students);
        List<Team> teams = teamService.initTeams();

        for (int stuIndex=0,teamIndex=0;stuIndex<students.size();stuIndex++) {
            if(teamIndex==6) teamIndex=0;
            teams.get(teamIndex).getStudent().add(students.get(stuIndex));
            teamIndex++;
        }
        return teams;
    }

    @PatchMapping("/Teams")
    public Team update(@RequestBody @Valid TeamRequestDTO teamRequestDTO) throws Exception {
        return teamService.updateTeamById(teamRequestDTO.getId(), teamRequestDTO.getName());
    }
}
