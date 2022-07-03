package com.enesseven.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="Animals")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String strain;

    private String breed;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date_of_birth;

    private String description;

    @ManyToOne
    private Person person;
}
