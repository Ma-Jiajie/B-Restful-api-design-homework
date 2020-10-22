package com.thoughtworks.capability.gtb.restfulapidesign.dataBaseTest;

import com.thoughtworks.capability.gtb.restfulapidesign.model.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.model.Team;

import java.util.ArrayList;
import java.util.List;

public class TeamStudentInit {
    private static List<Team> teams = new ArrayList<>();
    private static boolean isInited = false;
    private static void makeTeams() {
        List<Student> team1Stus = new ArrayList<>();
        Team team1 = new Team("1","team 1","",team1Stus);
        List<Student> team2Stus = new ArrayList<>();
        Team team2 = new Team("1","team 1","",team2Stus);
        List<Student> team3Stus = new ArrayList<>();
        Team team3 = new Team("1","team 1","",team3Stus);
        List<Student> team4Stus = new ArrayList<>();
        Team team4 = new Team("1","team 1","",team4Stus);
        List<Student> team5Stus = new ArrayList<>();
        Team team5 = new Team("1","team 1","",team5Stus);
        List<Student> team6Stus = new ArrayList<>();
        Team team6 = new Team("1","team 1","",team6Stus);
    }
    public static List<Team> initTeams() {
        if(!isInited) makeTeams();
        return teams;
    }
}
