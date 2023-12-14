package br.com.bruno.primeiroprojetospringboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;


//RestController define que a classe é uma Controladora que vai receber as requisições do usuário
//Spring ficará monitorando
@RestController

// RequestMapping define o Path do navegador para acessar o recurso
@RequestMapping("/primeiraController")
public class PrimeiraController {

    // Anotation Get está consultando uma informação no servidor
    @GetMapping("/primeiroMetodo/{id}")
    public String primeiroMetodo(@PathVariable String id) {
        return "Meu primeiro método api rest id" + id;
    }

//URL no formato http://localhost:8080/metodoComQueryParams?id=1
    @GetMapping("/metodoComQueryParams")
    public String metodoComQueryParams(@RequestParam String id) {
        return "O parâmetro com métodoQueryParams é " + id;
    }

// URL no formato http://127.0.0.1:8080/primeiraController/metodoComQueryParams2?id=1&Nome=Bruno
//allParams irá guardar todas as chaves/valor através do entrySet
    @GetMapping("/metodoComQueryParams2")
    public String metodoComQueryParams2(@RequestParam Map<String, String> allParams) {
        return "O parâmetro com métodoQueryParams é " + allParams.entrySet();
    }
    
    @PostMapping("/metodoComBodyParams")
    public String metodoComBodyParams(@RequestBody Usuario usuario) {        
        return "metodoComBodyParams " + usuario.username();
    }
    

    @PostMapping("/metodoComListHeaders")
    public String metodoComListHeaders(@RequestHeader Map<String, String> headers) {        
        return "metodoComListHeaders " + headers.entrySet();
    }

    @GetMapping("/metodoResponseEntity")
    public ResponseEntity<Object> metodoResponseEntity(){
        return ResponseEntity.status(HttpStatus.CREATED).body("Mensagem");
    }

    public record Usuario(String username) {
    }
}
