package com.dung2_backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    @Column
    private String role;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;
}
