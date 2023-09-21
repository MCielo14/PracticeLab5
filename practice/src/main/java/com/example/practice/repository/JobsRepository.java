package com.example.practice.repository;

import com.example.practice.entity.Employee;
import com.example.practice.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobsRepository  extends JpaRepository<Job, Integer> {
}
