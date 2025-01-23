package com.example.jobapp.service;

import com.example.jobapp.entity.Job;
import com.example.jobapp.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public Job addjob(Job job) {

        return jobRepository.save(job);
    }

    public Job getJobById(Long id) {

        return jobRepository.findById(id).orElse(null);
    }

    public Job updateJob(Job job1) {

        return jobRepository.save(job1);
    }


    public List<Job> getAllJobs() {

        return jobRepository.findAll();
    }

    public void deleteJob(Job job) {
        jobRepository.delete(job);
    }
}
