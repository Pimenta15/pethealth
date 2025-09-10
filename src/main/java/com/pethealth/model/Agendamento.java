package com.pethealth.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataConsulta;

    private String status; // AGENDADO, CANCELADO, CONCLUIDO

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;
}
