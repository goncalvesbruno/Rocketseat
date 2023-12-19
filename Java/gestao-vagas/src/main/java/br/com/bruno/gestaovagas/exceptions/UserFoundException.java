package br.com.bruno.gestaovagas.exceptions;

/*
 *  Tratar exceção lançada quando há tentativa de criar um usuário com username ou e-mail já existente 
 */
public class UserFoundException extends RuntimeException {
    public UserFoundException() {
        super("Usuário já existe");
    }
}
