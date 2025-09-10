package com.pethealth.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AgendamentoDTO {

    private Long id;
    private LocalDateTime dataConsulta;
    private String status;
    private Long petId;      // somente o ID do pet
    private String petNome;  // opcional, só para mostrar
}
