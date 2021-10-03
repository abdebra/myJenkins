package com.example.springbootbackend.Controller;

import com.example.springbootbackend.Repo.jobRep;
import com.example.springbootbackend.model.job;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.Access;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class controllerTest {
    
        @Autowired
    private jobRep jobRep;

    @Test
    void getJobs() {
        List<job> jobs =jobRep.findAll();
//        ass
    }

    @Test
    void getJobsById() {
        assertEquals(true,false);
    }

    @Test
    void addJob() {
        job jj = new job();
        jj.setJobTitle("tester");
        jj.setCompany("myens");
        jj.setSalary(200);
        jj.setRole("Leader");
        jj.setLocation("MN");

        jobRep.save(jj);
        assertNotNull(jobRep.findById(12L).get());
    }

    @Test
    void updateJobs() {
    }

    @Test
    void delteJob() {
    }
}