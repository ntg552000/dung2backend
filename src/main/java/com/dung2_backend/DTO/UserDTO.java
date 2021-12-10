package com.dung2_backend.DTO;

import com.dung2_backend.entity.Role;
import com.dung2_backend.entity.Route;
import com.dung2_backend.entity.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    @JsonProperty
    private Integer id;
    @JsonProperty
    private String account;
    @JsonProperty
    private String name;
    @JsonProperty
    private String address;
    @JsonProperty
    private String level;
    @JsonProperty
    private Set<Role> roles;
    @JsonProperty
    private Set<Route> routes;

    public UserDTO(User user){
        this.account = user.getAccount();
        this.address = user.getAddress();
        this.id = user.getId();
        this.level = user.getLevel();
        this.roles = user.getRoles();
        this.routes = user.getRoutes();
        this.name = user.getName();
    }
}
