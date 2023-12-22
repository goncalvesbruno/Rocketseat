package br.com.bruno.gestaovagas.modules.company.controllers;

import org.springframework.web.bind.annotation.RestController;

import br.com.bruno.gestaovagas.modules.company.entities.CompanyEntity;
import br.com.bruno.gestaovagas.modules.company.useCases.CreateCompanyUseCase;
import lombok.var;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("/company")

public class CompanyController {

    @Autowired
    private CreateCompanyUseCase createCompanyUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> create(@RequestBody CompanyEntity companyEntity){
        try{
            var result = this.createCompanyUseCase.execute(companyEntity);
            return ResponseEntity.ok().body(result);
        } catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
