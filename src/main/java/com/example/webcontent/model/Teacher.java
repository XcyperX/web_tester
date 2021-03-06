package com.example.webcontent.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "users")
@Data
public class Teacher implements UserDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "teacher", fetch = FetchType.EAGER)
    private List<Group> groups = new ArrayList<>();

    @OneToMany(mappedBy = "owner")
    private List<Test> tests = new ArrayList<>();

    public String getTeacherName() {
        return getName();
    }

    public String getTeacherRole() {
        return role.getNameRole();
    }

    public Boolean isAdmin() {
        return getRole().name().contains("ADMIN");
    }

    public Boolean isOwner() {
        return getRole().name().contains("OWNER");
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(getRole());
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String getUsername() {
        return getEmail();
    }
}
