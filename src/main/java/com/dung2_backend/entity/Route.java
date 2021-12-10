package com.dung2_backend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Route {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private String departure;

    @Column
    private String destination;

    @Column
    private Float distance;

    @Column
    private Integer stops;

    @ManyToMany(mappedBy = "routes")
    private Set<User> users;
}
