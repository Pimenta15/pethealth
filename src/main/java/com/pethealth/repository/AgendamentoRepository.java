package com.pethealth.repository;

import com.pethealth.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

    // Conta quantos agendamentos um pet tem em um determinado mês
    @Query("SELECT COUNT(a) FROM Agendamento a WHERE a.pet.id = :petId AND MONTH(a.dataConsulta) = :mes AND YEAR(a.dataConsulta) = :ano")
    int countByPetIdAndDataConsultaMonth(@Param("petId") Long petId, @Param("mes") int mes, @Param("ano") int ano);

    // Verifica se existe agendamento na mesma data/hora para o pet
    boolean existsByPetIdAndDataConsulta(Long petId, LocalDateTime dataConsulta);
}
