package com.novi.gymmanagementapi.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "members")
public class Member extends User {

    @NotNull
    private String password;
    @Column(nullable = false)
    private boolean enabled = true;
    @OneToMany(
            targetEntity = Authority.class,
            mappedBy = "email",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    private Set<Authority> authorities = new HashSet<>();
    @ManyToOne(fetch = FetchType.EAGER)
    private Membership membership;
    @ManyToOne(fetch = FetchType.EAGER)
    private Trainer trainer;


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    public void addAuthority(Authority authority) {
        this.authorities.add(authority);
    }

    public void removeAuthority(Authority authority) {
        this.authorities.remove(authority);
    }

    public Membership getMembership() {
        return membership;
    }

    public void setMembership(Membership membership) {
        this.membership = membership;
    }

    public Trainer getTrainer() { return trainer; }

    public void setTrainer(Trainer trainer) { this.trainer = trainer; }
}
