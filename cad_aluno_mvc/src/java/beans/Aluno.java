package beans;

import java.io.Serializable;

/**
 *
 * @author Edson Melo de Souza
 *
 */
public class Aluno implements Serializable {

    private static final long serialVersionUID = 1L;

    // criação dos atributos da classe
    private int id;
    private int ra;
    private String nome;
    private String curso;

    // método construtor da classe
    public Aluno() {
    }

}
