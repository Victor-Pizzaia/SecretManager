package org.pizzaia.secretManager.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "SECRET")
@AllArgsConstructor
@NoArgsConstructor
public class Secret implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, unique = true)
    private Integer id;

    @Column(name = "VALUE", nullable = false)
    private String value;

    @Column(name = "NAME", nullable = false, unique = true)
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "OWNER", nullable = false, unique = true)
    @OneToMany
    @JoinColumn(name="USER", nullable=false)
    private User owner;
}
