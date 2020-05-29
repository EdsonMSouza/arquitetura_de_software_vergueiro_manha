package controllers;

import beans.Aluno;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.AlunoModel;

/**
 *
 * @author Edson Melo de Souza
 */
public class AlunoController extends HttpServlet {

    Aluno aluno = new Aluno();
    List<Aluno> alunos = new ArrayList<>();

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

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        // esse método trata TODAS as requisições que forem solicitadas via URL (LINK)
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        // vou escrever só para testar
        //ArrayList<Aluno> al = new ArrayList<>();
        //al.add(new Aluno(1, "Edson Melo", "TADS"));
        //al.add(new Aluno(2, "Tio Patinhas", "ECONOMIA"));
        //al.add(new Aluno(3, "Zé Carioca", "MEDICINA"));
        try {
            AlunoModel am = new AlunoModel();
            alunos = am.listar();
            request.setAttribute("listaAlunos", alunos);
            request.getRequestDispatcher("view_listar.jsp").
                    forward(request, response);
        } catch (SQLException ex) {
            request.setAttribute("listaAlunos", ex.getMessage());
            request.getRequestDispatcher("view_listar.jsp").
                    forward(request, response);
        }

        // variável para identificar o que deve se feito
        //String operacao = request.getParameter("operacao");
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
        // este método trata todas as requisições
        // enviadas via POST (formulário)
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        // variável para identificar o que deve se feito
        String operacao = request.getParameter("operacao");

        // estrutura de seleção
        switch (operacao) {
            case "Inserir":
                aluno.setRa(Integer.parseInt(request.getParameter("ra")));
                aluno.setNome(request.getParameter("nome"));
                aluno.setCurso(request.getParameter("curso"));

                try {
                    /**
                     * Repassa os valores enviados pelo formulário para o nosso
                     * AlunoModel (Model)
                     */
                    AlunoModel am = new AlunoModel();
                    am.inserir(aluno);

                    // Redireciona para a View das mensagens
                    request.setAttribute("mensagem", am.toString());
                    request.getRequestDispatcher("view_mensagem.jsp").
                            forward(request, response);

                } catch (SQLException ex) {
                    request.setAttribute("mensagem", ex.getMessage());
                    request.getRequestDispatcher("view_mensagem.jsp").
                            forward(request, response);
                }
                break;

            case "Pesquisar":
                break;
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
