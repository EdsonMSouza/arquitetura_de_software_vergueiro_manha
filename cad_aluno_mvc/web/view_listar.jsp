<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%-- A linha abaixo faz a inserção do arquivo topo.jsp --%>
<c:import url="topo.jsp" />

<div class="alert-success text-center espaco">
    Listagem dos Alunos
</div>
<!-- Criar aqui a tabela -->
<table class="table text-center">
    <thead> <!-- Cabeçalho da tabela -->
        <tr>
            <th>RA</th>
            <th>NOME</th>
            <th>CURSO</th>
            <th colspan="2">Operações</th>
        </tr>
    </thead>
    <tbody><!-- Corpo da tabela -->
        <c:forEach var="aluno" items="${listaAlunos}">
        <form method="post" action="AlunoController">
            <tr><!-- Uma linha da tabela -->
                <td class="align-middle">${aluno.ra}</td>
                <td class="align-middle text-justify">${aluno.nome}</td>
                <td class="align-middle">${aluno.curso}</td>
                <td><input class="btn btn-primary btn-sm text-center"
                           type="submit" name="operacao" value="Editar"/></td>
                <td><input class="btn btn-danger btn-sm text-center"
                           type="submit" name="operacao" value="Excluir"/></td>
            </tr>
            <!-- Cria um campo oculto com o valor do RA para ser usado na edição ou exclusão -->
            <input type="hidden" name="ra" value="${aluno.ra}" />
        </form>
    </c:forEach>
</tbody>
</table>
<c:import url="rodape.jsp" />