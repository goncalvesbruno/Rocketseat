package br.com.bruno.primeiroprojetospringboot.ioc_di;

import org.springframework.stereotype.Component;

@Component
public class MeuComponent {
    
    public String chamarMeuComponent(){
        return "Chamando meu component";
    }
}
