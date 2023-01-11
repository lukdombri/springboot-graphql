package com.example.graphql.controller;

import com.example.graphql.input.PersonInput;
import com.example.graphql.input.ProjectInput;
import com.example.graphql.model.Person;
import com.example.graphql.model.Project;
import com.example.graphql.repository.PersonRepository;
import com.example.graphql.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ProjectController {
    private final PersonRepository personRepository;
    private final ProjectRepository projectRepository;

    @QueryMapping
    Iterable<Project> projects() {
        return projectRepository.findAll();
    }

    @QueryMapping
    Optional<Project> projectById(@Argument Long id) {
        return projectRepository.findById(id);
    }

    @MutationMapping
    Project addProject(@Argument ProjectInput project) {
        Project projectEntity = new Project();
        projectEntity.setName(project.getName());
        return projectRepository.save(projectEntity);
    }

    @MutationMapping
    Person addPerson(@Argument PersonInput person) {
        Project projectEntity = projectRepository.findByName(person.getProject().getName());

        Person personEntity = new Person();
        personEntity.setName(person.getName());
        personEntity.setLastname(person.getLastname());
        personEntity.setOriginCountry(person.getOriginCountry());
        personEntity.setProject(projectEntity);
        return personRepository.save(personEntity);
    }
}
