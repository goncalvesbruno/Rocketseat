package br.com.bruno.gestaovagas.modules.candidate;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

/*  Annotation @Data com lombok adiciona automaticamente os getters e setters da classe
*   O campo de e-mail ... será validados através da dependência spring-boot-starter-validation com a annotation @Email
*   Annotation @Pattern padroniza a entrada, dependência spring-boot-starter-validation
*   Annotation @Email valida se é um e-mail válido
*   Annotation @Length limita o tamanho da senha
*   @Entity irá transformar o objeto em uma tabela para adicionar no DB. Parâmetro name é o nome da tabela. 
*   Autimaticamente com o @Entity os atributos serão transformados em colunas
*   @Column altera o nome da coluna no banco de dados caso necessário
*   @Id irá informar que o atributo será o ID das entradas na tabela (precisa ser do jakarta)
*   @GeneratedValue toda vez que for criado um objeto, será criado um ID único para a tabela
*/
@Data
@Entity(name = "candidate")
public class CandidateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;

    @Pattern(regexp = "\\S+", message = "O campo [username] não deve conter espaços")
    private String username;

    @Email(message = "O campo [email] deve conter um e-mail válido.")
    private String email;

    @Length(min = 10, max = 100, message = "O campo [senha] deve conter entre (10) e (100) caracteres")
    private String password;
    private String description;
    private String curriculum;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
