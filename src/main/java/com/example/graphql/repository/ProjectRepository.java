package com.example.graphql.repository;

import com.example.graphql.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {
    public Project findByName(String name);
}
