package com.templates.valens.v1.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Getter
@Setter
public abstract class Member  extends  Person{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @OneToOne
    @JoinColumn(name = "profile_id")
    private User profile;
}
