/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import beans.Aluno;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.DBConnection;

/**
 *
 * @author Edson Melo de Souza
 * @date 20/03/2020
 *
 */
public class AlunosModel implements Serializable {

    // Declaração das variáveis globais
    private Connection conexao = null;
    private String status;

    /**
     * Método construtor da classe
     *
     * @throws SQLException
     */
    public AlunosModel() throws SQLException {
        // Retorna a conexao no momento da chamada da classe
        this.conexao = DBConnection.getInstance().getConnection();
    }

    /**
     * Realiza a listagem de TODOS os registros existentes no banco de dados
     *
     * @return Aluno
     */
    public List<Aluno> listar() {
        List<Aluno> alunos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM alunos ORDER BY nome";
            try (
                    PreparedStatement ps = conexao.prepareStatement(sql);
                    ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    Aluno aluno = new Aluno();
                    aluno.setId(rs.getInt("id"));
                    aluno.setRa(Integer.parseInt(rs.getString("ra")));
                    aluno.setNome(rs.getString("nome"));
                    aluno.setCurso(rs.getString("curso"));

                    alunos.add(aluno);
                }
            }
            return alunos;

        } catch (SQLException ex) {
            throw new RuntimeException("Falha ao listar os alunos.", ex);
        }
    }

    public List<Aluno> pesquisar(Aluno aluno) {
        List<Aluno> alunos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM alunos WHERE ra = ? ORDER BY nome";
            PreparedStatement ps = conexao.prepareStatement(sql);

            // atribui o valor do parâmetro à string SQL
            ps.setInt(1, aluno.getRa());

            // executa a consulta
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                // não há necessidade instanciar um novo objeto, pois
                // o parâmetro do método já é um objeto Aluno.
                aluno = new Aluno();
                aluno.setId(rs.getInt("id"));
                aluno.setRa(Integer.parseInt(rs.getString("ra")));
                aluno.setNome(rs.getString("nome"));
                aluno.setCurso(rs.getString("curso"));

                alunos.add(aluno);
            }

            return alunos;

        } catch (SQLException ex) {
            throw new RuntimeException("Falha ao pesquisar.", ex);
        }
    }

    public void inserir(Aluno aluno) {
        //status = "Aluno [" + aluno.getNome() + "] inserido com sucesso";
        try {
            // Declaração da variável para a instrução SQL
            String sql = "insert INTO alunos (ra, nome, curso) "
                    + "VALUES (?, ?, ?)";

            // Atribui os valores ao objeto ps
            try (PreparedStatement ps = conexao.prepareStatement(sql)) {
                // seta os valores
                ps.setInt(1, aluno.getRa());
                ps.setString(2, aluno.getNome());
                ps.setString(3, aluno.getCurso());

                // Executa o sql (execute)
                ps.execute();

                // Fecha o ps
                ps.close();
            }

            // Fecha a conexão
            conexao.close();

            // Retorna o status da inserção
            status = "Aluno [" + aluno.getNome() + "] inserido com sucesso";

        } catch (SQLException ex) {
            // Captura o erro ocorrido e retorna para o Controller
            status = "Erro ao inserir o aluno [" + ex.getMessage() + "]";
        }
    }

    public void atualizar(Aluno aluno) {
        //status = "Aluno [" + aluno.getNome() + "] atualizado com sucesso";
        try {
            // Declaração da variável para a instrução SQL
            String sql = "UPDATE alunos SET nome = ?, curso = ? "
                    + "WHERE ra = ?";

            // Atribui os valores ao objeto ps
            try (PreparedStatement ps = conexao.prepareStatement(sql)) {
                // seta os valores
                ps.setString(1, aluno.getNome());
                ps.setString(2, aluno.getCurso());
                ps.setInt(3, aluno.getRa());

                // Executa o sql (execute)
                ps.executeUpdate();

                // Fecha o ps
                ps.close();
            }

            // Fecha a conexão
            conexao.close();

            // Retorna o status da inserção
            status = status = "Aluno [" + aluno.getNome() + "] atualizado com sucesso";

        } catch (SQLException ex) {
            // Captura o erro ocorrido e retorna para o Controller
            status = "Erro ao atualizar o aluno [" + ex.getMessage() + "]";
        }
    }

    public void excluir(Aluno aluno) {
        status = "Aluno [" + aluno.getNome() + "] excluído com sucesso";
    }

    /**
     * Método que retorna o status da operação realizada
     *
     * @return String
     */
    @Override
    public String toString() {
        return status;
    }
}
