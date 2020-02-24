package dev.intranet.exampleapp.application.domain;


import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "phone")
public class Phone implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_id_phone", sequenceName = "seq_id_phone", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_id_phone")
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
