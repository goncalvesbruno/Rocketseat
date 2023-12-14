package br.com.bruno.primeiroprojetospringboot.ioc_di;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/component")
public class MeuControllerComponent {
   
// Equivale a meuComponent = new MeuComponent(), no entanto, o Spring que irá fazer a instanciação
// e cuidar do tempo de vida da instância.  Boa prática de Spring
    @Autowired
    MeuComponent meuComponent;

    @GetMapping("/")
    public String chamandoComponent(){
        
        var resultado = meuComponent.chamarMeuComponent();
        return resultado;
    }
    

}
