package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.databasetest.TeamStudentInit;
import com.thoughtworks.capability.gtb.restfulapidesign.model.Team;
import com.thoughtworks.capability.gtb.restfulapidesign.exception.TeamNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamService {
    private List<Team> teams = new ArrayList<>();

    public TeamService() {
        teams = TeamStudentInit.initTeams();
    }
    public List<Team> initTeams() {
        return teams;
    }
    public Team getTeamByid(String id) {
        Team team = teams.stream().filter(te -> te.getId().equals(id)).findFirst().orElse(null);
        if(team == null) throw new TeamNotFoundException("该组不存在");
        return team;
    }
    public Team updateTeamById(String id, String name){
        return TeamStudentInit.updateTeamByIdWithName(id, name);
    }
}
