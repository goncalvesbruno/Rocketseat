package br.com.bruno.gestaovagas.modules.candidate.controllers;

import org.springframework.web.bind.annotation.RestController;

import br.com.bruno.gestaovagas.modules.candidate.CandidateEntity;
import br.com.bruno.gestaovagas.modules.candidate.CandidateRepository;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/candidate")

public class CandidateController {
  
  @Autowired
  private CandidateRepository candidateRepository;
  
  @PostMapping("/")

  //@valid irá informar ao Spring para validar os dados da Entity no momento da criação através do jakarta.validation.Valid
  public CandidateEntity create(@Valid @RequestBody CandidateEntity candidateEntity) {
    return this.candidateRepository.save(candidateEntity);
  }
}



