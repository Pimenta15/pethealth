package com.pethealth.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true, nullable = false)
    private String cpf;

    private String telefone;

    private LocalDateTime dataCadastro; // ← adicione este campo

    @OneToMany(mappedBy = "tutor", cascade = CascadeType.ALL)
    private List<Pet> pets;

    @PrePersist
    public void prePersist() {
        this.dataCadastro = LocalDateTime.now(); // auto-popula ao criar tutor
    }
}
