package models;

import beans.Aluno;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import utils.DBConnection;

/**
 *
 * Classe responsável pela gestão do Model do Aluno
 *
 * @author Edson Melo de Souza
 *
 */
public class AlunoModel implements Serializable {
    // declaração das variáveis globais da classe

    private Connection conexao = null;
    private String status;

    /**
     * Método construtor da classe.
     *
     * Toda vez que a classe for instanciada, esse método será executado.
     *
     * @throws SQLException
     */
    public AlunoModel() throws SQLException {
        // Recebe a conexão do banco de dados
        this.conexao = DBConnection.getInstance().getConnection();
    }

    // Métodos para manipular os dados no Banco de Dados
    public void inserir(Aluno aluno) {
        try {
            // Variável para a instrução SQL
            String sql = "INSERT INTO alunos (ra,nome,curso) "
                    + "VALUES (?,?,?)";
            // faz a conexão com o banco de dados, preparando
            // a string SQL
            PreparedStatement ps = conexao.prepareStatement(sql);

            // atribuir os valores aos campos (?,?,?)
            ps.setInt(1, aluno.getRa());
            ps.setString(2, aluno.getNome());
            ps.setString(3, aluno.getCurso());

            // executar a instrução para incluir no banco
            ps.execute();
            // fecha a aconexão do ps
            ps.close();
            // fechar a conexão com o banco de dados
            conexao.close();
            // mensagem se deu "bom"
            this.status = "Aluno inserido com sucesso";

        } catch (SQLException ex) {
            this.status = "Erro ao inserir.";
        }
    }

    public void excluir(Aluno aluno) {
    }

    public void atualizar(Aluno aluno) {
    }

    public List<Aluno> pesquisar(Aluno aluno, String campo) {
        return null;
    }

    public List<Aluno> listar() {
        return null;
    }

    @Override
    public String toString() {
        return status;
    }

}
