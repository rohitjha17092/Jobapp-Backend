package com.example.jobapp.controller;

import com.example.jobapp.entity.Job;
import com.example.jobapp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class JobController {

    @Autowired
    private JobService jobService;


    @PostMapping("/job")
    public Job addob(@RequestBody Job job){
        return jobService.addjob(job);
    }



    @GetMapping("/job/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id){
        Job job = jobService.getJobById(id);
        if(job==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(job);
    }


    @PutMapping("/job/{id}")
    public ResponseEntity<Job> updateJob(@RequestBody Job job, @PathVariable Long id){
        Job job1 = jobService.getJobById(id);
        if(job1 == null){
            return ResponseEntity.notFound().build();
        }
        job1.setTitle(job.getTitle());
        job1.setDescription(job.getDescription());
        job1.setSkills(job.getSkills());
        job1.setExperience(job.getExperience());
        job1.setLocation(job.getLocation());
        job1.setSalary(job.getSalary());
        Job updatedJob = jobService.updateJob(job1);
        return ResponseEntity.ok(updatedJob);
    }


    @GetMapping("/jobs")
    public List<Job> getAllJobs(){
        return jobService.getAllJobs();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Job> deleteJob(@PathVariable Long id){
        Job job = jobService.getJobById(id);
        if(job == null){
            return ResponseEntity.notFound().build();
        }
        jobService.deleteJob(job);
        return ResponseEntity.ok().build();
    }

}
