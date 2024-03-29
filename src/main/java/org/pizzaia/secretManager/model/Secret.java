package org.pizzaia.secretManager.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "SECRET")
@AllArgsConstructor
@NoArgsConstructor
public class Secret implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SECRET_ID", nullable = false, unique = true)
    private Integer id;

    @Column(name = "VALUE", nullable = false)
    private String value;

    @Column(name = "NAME", nullable = false, unique = true)
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @ManyToOne
    @JoinColumn(name="OWNER_ID", nullable=false)
    private Owner owner;
}
