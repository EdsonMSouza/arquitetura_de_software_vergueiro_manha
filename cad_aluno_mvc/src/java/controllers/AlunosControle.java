/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import beans.Aluno;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.AlunosModel;

/**
 *
 * @author souza
 */
public class AlunosControle extends HttpServlet {

    // variáveis para manipulação dos métodos
    Aluno aluno = new Aluno(); // objeto aluno
    List<Aluno> alunoDados; // objeto para recuperar dados de apenas um (01) aluno
    List<Aluno> alunosDados; // objeto para recuperar dados de todos os alunos

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        try {
            AlunosModel alunosModel = new AlunosModel();

            //ArrayList<Aluno> listaAlunos = new ArrayList();
            // Coloca todos os alunos em uma lista
            alunosDados = alunosModel.listar();

            // se não for encontrado nenhum registro, retorna a mensagem
            if (alunosDados.isEmpty()) {
                // Cria um atributo com o aluno para ser utilizado na View
                request.setAttribute("mensagem", "Não há registros para serem listados");

                // Redireciona para a View
                request.getRequestDispatcher("view_mensagem.jsp").
                        forward(request, response);
            } else {
                // Cria um atributo com o aluno para ser utilizado na View
                request.setAttribute("listaAlunos", alunosDados);

                // Redireciona para a View
                request.getRequestDispatcher("view_listar.jsp").
                        forward(request, response);
            }
        } catch (SQLException ex) {
            // Redireciona para a View de mensagens
            request.setAttribute("mensagem", ex);
            request.getRequestDispatcher("view_mensagem.jsp").
                    forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String operacao = request.getParameter("operacao");
        Aluno aluno = new Aluno();
        List<Aluno> alunos;
        int ra;
        String nome;
        String curso;

        switch (operacao) {
            case "Inserir":
                //request.setAttribute("mensagem", "Inserir");
                //request.getRequestDispatcher("view_mensagem.jsp").forward(request, response);

                //Recupera os valores enviados pelo formulário
                ra = Integer.parseInt(request.getParameter("ra"));
                nome = request.getParameter("nome");
                curso = request.getParameter("curso");

                try {
                    // Cria o objeto e atribui os dados recebidos da View
                    aluno = new Aluno();
                    aluno.setRa(ra);
                    aluno.setNome(nome);
                    aluno.setCurso(curso);

                    /**
                     * Repassa os valores dos atributos para o AlunoModel que
                     * irá manipular os dados e gravar no banco
                     */
                    AlunosModel alunoModel = new AlunosModel();
                    alunoModel.inserir(aluno);

                    // Cria um atributo para informar sobre  a inclusão
                    request.setAttribute("mensagem", alunoModel.toString());

                    // Redireciona para a View
                    request.getRequestDispatcher("view_mensagem.jsp").
                            forward(request, response);
                } catch (SQLException ex) {
                    // Redireciona para a View de mensagens
                    request.setAttribute("mensagem", ex);
                    request.getRequestDispatcher("view_mensagem.jsp").
                            forward(request, response);
                }
                break;

            case "Pesquisar":
                try {
                    // cria o objeto para o model
                    AlunosModel alunoModel = new AlunosModel();

                    // cria o objeto Aluno, recupera e atribui o valor enviado pelo formulário
                    //aluno = new Aluno();
                    aluno.setRa(Integer.parseInt(request.getParameter("ra")));

                    // armazena os dados recuperados da consulta, passando o
                    // objeto Aluno (aluno) como parâmetro
                    alunoDados = alunoModel.pesquisar(aluno);

                    // se não for encontrado nenhum registro, retorna a mensagem
                    if (alunoDados.isEmpty()) {
                        // Cria um atributo com o aluno para ser utilizado na View
                        request.setAttribute("mensagem", "Registro não localizado");

                        // Redireciona para a View
                        request.getRequestDispatcher("view_mensagem.jsp").
                                forward(request, response);
                    } else {
                        // Cria um atributo com o aluno para ser utilizado na View
                        request.setAttribute("listaAlunos", alunoDados);

                        // Redireciona para a View
                        request.getRequestDispatcher("view_listar.jsp").
                                forward(request, response);
                    }
                } catch (SQLException ex) {
                    // Redireciona para a View de mensagens
                    request.setAttribute("mensagem", ex);
                    request.getRequestDispatcher("view_mensagem.jsp").
                            forward(request, response);

                } catch (NumberFormatException nf) {
                    // verifica se houve um erro de conversão de tipos ou tamanho
                    request.setAttribute("mensagem", "Informe um RA válido");
                    request.getRequestDispatcher("view_pesquisar.jsp").
                            forward(request, response);
                }

                break;

            case "Editar":
                //request.setAttribute("mensagem", "Editar");
                //request.getRequestDispatcher("view_mensagem.jsp").forward(request, response);
                System.out.println(request.getParameter("ra"));
                try {
                    AlunosModel alunosModel = new AlunosModel();

                    //Aluno aluno = new Aluno();
                    // recupera o valor enviado pelo formulário
                    aluno.setRa(Integer.parseInt(request.getParameter("ra")));

                    // armazena os dados recuperados da consulta, passando o
                    // objeto Aluno (aluno) como parâmetro
                    alunoDados = alunosModel.pesquisar(aluno);

                    // se não for encontrado nenhum registro, retorna a mensagem
                    if (alunoDados.isEmpty()) {
                        // Cria um atributo com o aluno para ser utilizado na View
                        request.setAttribute("mensagem", "Registro não localizado");

                        // Redireciona para a View
                        request.getRequestDispatcher("view_mensagem.jsp").
                                forward(request, response);
                    } else {
                        // Cria um atributo com o aluno para ser utilizado na View
                        request.setAttribute("listaAlunos", alunoDados);

                        // Redireciona para a View
                        request.getRequestDispatcher("view_editar.jsp").
                                forward(request, response);
                    }
                } catch (SQLException ex) {
                    // Redireciona para a View de mensagens
                    request.setAttribute("mensagem", ex);
                    request.getRequestDispatcher("view_mensagem.jsp").
                            forward(request, response);

                } catch (NumberFormatException nf) {
                    // verifica se houve um erro de conversão de tipos ou tamanho
                    request.setAttribute("mensagem", "RA não localizado");
                    request.getRequestDispatcher("view_mensagem.jsp").
                            forward(request, response);
                }
                break;

            case "Atualizar":
                //request.setAttribute("mensagem", "Atualizado com Sucesso!!!");
                //request.getRequestDispatcher("view_mensagem.jsp").forward(request, response);
                //Recupera os valores enviados pelo formulário
                ra = Integer.parseInt(request.getParameter("ra"));
                nome = request.getParameter("nome");
                curso = request.getParameter("curso");

                try {
                    // Cria o objeto e atribui os dados recebidos da View
                    aluno = new Aluno();
                    aluno.setRa(ra);
                    aluno.setNome(nome);
                    aluno.setCurso(curso);

                    /**
                     * Repassa os valores dos atributos para o AlunoModel que
                     * irá manipular os dados e gravar no banco
                     */
                    AlunosModel alunoModel = new AlunosModel();
                    alunoModel.atualizar(aluno);

                    // Cria um atributo para informar sobre  a inclusão
                    request.setAttribute("mensagem", alunoModel.toString());

                    // Redireciona para a View
                    request.getRequestDispatcher("view_mensagem.jsp").
                            forward(request, response);
                } catch (SQLException ex) {
                    // Redireciona para a View de mensagens
                    request.setAttribute("mensagem", ex);
                    request.getRequestDispatcher("view_mensagem.jsp").
                            forward(request, response);
                }
                break;

            case "Excluir":
                try {

                    AlunosModel alunoModel = new AlunosModel();
                    request.setAttribute("mensagem", alunoModel.toString());
                    request.getRequestDispatcher("view_mensagem.jsp").forward(request, response);

                } catch (SQLException ex) {
                    request.setAttribute("mensagem", ex.getMessage());
                    request.getRequestDispatcher("view_mensagem.jsp").forward(request, response);
                }
                break;
        }
    }

}
