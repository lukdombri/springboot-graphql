package com.example.graphql.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.graphql.data.method.annotation.Argument;

@Data
public class ProjectInput {
    private String name;
}
