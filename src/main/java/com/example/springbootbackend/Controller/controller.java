package com.example.springbootbackend.Controller;

import com.example.springbootbackend.Repo.jobRep;
import com.example.springbootbackend.exception.ResNotFoundException;
import com.example.springbootbackend.model.job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping({"/api/jobs"})
public class controller {
    @Autowired
    private jobRep jobRep;

    @GetMapping()
    public List<job> getJobs(){
        return jobRep.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<job> getJobs(@PathVariable Long id){
        job jj = jobRep.findById(id).orElseThrow(()->new ResNotFoundException("Job with" +id + "not Found"));
        return ResponseEntity.ok(jj);
    }
    @PostMapping()
    public job AddJob(@RequestBody job job){
        return jobRep.save(job);
    }

    @PutMapping("/{id}")
    public ResponseEntity<job> updateJobs(@PathVariable Long id, @RequestBody job job){
        job jj = jobRep.findById(id).orElseThrow(()->new ResNotFoundException("Job with" +id + "not Found"));
       jj.setJobTitle(job.getJobTitle());
       jj.setCompany(job.getCompany());
       jj.setLocation(job.getLocation());
       jj.setRole(job.getRole());
       jj.setSalary(job.getSalary());

       job updatedJob = jobRep.save(jj);
        return ResponseEntity.ok(updatedJob);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String,Boolean>> delteJob(@PathVariable Long id){
        job jj = jobRep.findById(id).orElseThrow(()->new ResNotFoundException("Job with" +id + "not Found"));
       jobRep.delete(jj);
       Map<String,Boolean> map =new HashMap<>();
       map.put("deleted",Boolean.TRUE);
        return ResponseEntity.ok(map);
    }

}
