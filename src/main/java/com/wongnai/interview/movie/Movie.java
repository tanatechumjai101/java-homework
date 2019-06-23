package com.wongnai.interview.movie;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;


    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> actors = new ArrayList<>();


    /**
     * Required by JPA.
     */
    protected Movie() {

    }

    public Movie(String name, List<String> actors) {
        this.name = name;
        this.actors = actors;

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getActors() {
        return actors;
    }


}
