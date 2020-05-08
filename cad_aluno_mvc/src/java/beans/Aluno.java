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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRa() {
        return ra;
    }

    public void setRa(int ra) {
        this.ra = ra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

}
