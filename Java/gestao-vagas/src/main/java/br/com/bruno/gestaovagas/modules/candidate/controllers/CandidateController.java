package br.com.bruno.gestaovagas.modules.candidate.controllers;

import org.springframework.web.bind.annotation.RestController;

import br.com.bruno.gestaovagas.exceptions.UserFoundException;
import br.com.bruno.gestaovagas.modules.candidate.CandidateEntity;
import br.com.bruno.gestaovagas.modules.candidate.CandidateRepository;
import br.com.bruno.gestaovagas.modules.candidate.useCases.CreateCandidateUseCase;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/candidate")

public class CandidateController {
  
  // Irá instanciar um objeto CreateCandidateUseCase
  @Autowired
  private CreateCandidateUseCase createCandidateUseCase;
  
  @PostMapping("/")

  //@valid irá informar ao Spring para validar os dados da Entity no momento da criação através do jakarta.validation.Valid
  public ResponseEntity<Object> create(@Valid @RequestBody CandidateEntity candidateEntity) {
    try {
      var result = this.createCandidateUseCase.execute(candidateEntity);
      return ResponseEntity.ok().body(result);
    } catch(Exception e){
      return ResponseEntity.badRequest().body(e.getMessage());
    }
    
  }
}



