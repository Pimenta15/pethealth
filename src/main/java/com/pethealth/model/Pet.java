package com.pethealth.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String especie; // cachorro, gato etc.
    private Integer idade;

    @ManyToOne
    @JoinColumn(name = "tutor_id")
    private Tutor tutor;
}
