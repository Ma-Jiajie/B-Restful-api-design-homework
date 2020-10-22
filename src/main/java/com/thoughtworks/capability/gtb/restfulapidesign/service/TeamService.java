package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.dataBaseTest.TeamStudentInit;
import com.thoughtworks.capability.gtb.restfulapidesign.model.Team;
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
        return teams.stream().filter(team -> team.getId().equals(id)).findFirst().get();
    }
    public Team updateTeamById(String id, String name) throws Exception {
        return TeamStudentInit.updateTeamByIdWithName(id, name);
    }
}
