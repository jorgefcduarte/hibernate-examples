package dev.intranet.exampleapp.application.domain;


import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "phone")
public class Phone implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private int id;

    @Column(name = "number", length = 13, nullable = false)
    @Getter
    private String number;

    public Phone() {

    }

    public Phone(String number) {
        this.number = number;
    }

}
