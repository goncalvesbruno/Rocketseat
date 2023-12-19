package br.com.bruno.gestaovagas.modules.candidate;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;



// É a camada de comunicação com banco de dados
// findByUsernameOrEmail() Este método será criado automaticamente pelo Spring devido ao formato da escrita, iniciando por "findBy"
// Optional dá suporte a outros métodos além do que se usasse somente o tipo "CandidateEntity"
public interface CandidateRepository extends JpaRepository<CandidateEntity, UUID>{
    Optional<CandidateEntity> findByUsernameOrEmail(String username, String email);
}
