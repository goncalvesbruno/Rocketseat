package br.com.bruno.gestaovagas.modules.candidate;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;


// É a camada de comunicação com banco de dados
public interface CandidateRepository extends JpaRepository<CandidateEntity, UUID>{
    
}
