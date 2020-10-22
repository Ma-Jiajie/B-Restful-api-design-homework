package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.dataBaseTest.StudentsDataBase;
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
    public void separate() {
        //分组
        for(int index=0,teamNo=0;index < StudentsDataBase.studentsProvider().size();index++) {

        }
    }
}
