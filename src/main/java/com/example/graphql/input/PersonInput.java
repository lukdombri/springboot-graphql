package com.example.graphql.input;

import com.example.graphql.model.Project;
import lombok.Data;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Data
public class PersonInput {
    private String name;
    private String lastname;
    private String originCountry;
    private ProjectInput project;
}
