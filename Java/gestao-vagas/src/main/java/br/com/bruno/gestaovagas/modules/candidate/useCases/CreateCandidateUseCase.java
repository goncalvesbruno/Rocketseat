package br.com.bruno.gestaovagas.modules.candidate.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bruno.gestaovagas.exceptions.UserFoundException;
import br.com.bruno.gestaovagas.modules.candidate.CandidateEntity;
import br.com.bruno.gestaovagas.modules.candidate.CandidateRepository;

/*
 * @Service annotation para designar a camada de serviço onde ocorrerão regras de negócio
 */

@Service
public class CreateCandidateUseCase {
    
    @Autowired
    private CandidateRepository candidateRepository;
    
    public CandidateEntity execute (CandidateEntity candidateEntity) {
        // Testa se o usuário ou e-mail já existem. Caso existam, lança exceção
        this.candidateRepository
            .findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail())
            .ifPresent((user) -> {
                throw new UserFoundException();
            });
 
    return this.candidateRepository.save(candidateEntity);
    }
}
