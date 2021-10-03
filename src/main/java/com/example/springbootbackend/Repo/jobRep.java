package com.example.springbootbackend.Repo;

import com.example.springbootbackend.model.job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface jobRep extends JpaRepository<job, Long> {
}
