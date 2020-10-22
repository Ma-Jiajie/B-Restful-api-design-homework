package com.thoughtworks.capability.gtb.restfulapidesign.dataBaseTest;

import com.thoughtworks.capability.gtb.restfulapidesign.model.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.model.Team;

import java.util.ArrayList;
import java.util.List;

public class TeamStudentInit {
    private static final List<Team> teams = new ArrayList<>();
    private static final boolean isInited = false;
    private static void makeTeams() {
        List<Student> team1Stus = new ArrayList<>();
        Team team1 = new Team("1","team 1","",team1Stus);
        List<Student> team2Stus = new ArrayList<>();
        Team team2 = new Team("2","team 2","",team2Stus);
        List<Student> team3Stus = new ArrayList<>();
        Team team3 = new Team("3","team 3","",team3Stus);
        List<Student> team4Stus = new ArrayList<>();
        Team team4 = new Team("4","team 4","",team4Stus);
        List<Student> team5Stus = new ArrayList<>();
        Team team5 = new Team("5","team 5","",team5Stus);
        List<Student> team6Stus = new ArrayList<>();
        Team team6 = new Team("6","team 6","",team6Stus);
        teams.add(team1);
        teams.add(team2);
        teams.add(team3);
        teams.add(team4);
        teams.add(team5);
        teams.add(team6);
    }
    public static List<Team> initTeams() {
        if(!isInited) makeTeams();
        return teams;
    }

    public static Team findTeamById(String id) {
        if(!isInited) makeTeams();
        return teams.stream().filter(team -> team.getId().equals(id)).findFirst().orElse(null);
    }

    public static void deleteTeam(String id){
        if(!isInited) makeTeams();
        teams.removeIf(team -> team.getId().equals(id));
    }

    public static Team updateTeamByIdWithName(String id, String name) {
        if(!isInited) makeTeams();
        Team team = findTeamById(id);
        deleteTeam(id);
        team.setName(name);
        teams.add(team);
        return team;
    }
}
