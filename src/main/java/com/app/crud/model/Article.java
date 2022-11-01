package com.app.crud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name = "article")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min=1, max=30, message = "Name should be from 1 to 30 symbols")
    private String name;

    @Size(min=1, max=60, message = "shortdescription should be from 1 to 60 symbols")
    private String shortdescription;



    @Size(min=1, max=300, message = "Text should be from 1 to 300 symbols")
    private String text;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    private User user;
}

