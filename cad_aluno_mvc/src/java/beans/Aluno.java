package beans;

import java.io.Serializable;

/**
 *
 * @author Edson Melo de Souza
 * @date 20/03/2020
 *
 */
public class Aluno implements Serializable {

    private int id;
    private int ra;
    private String nome;
    private String curso;

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
