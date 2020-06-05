<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:import url = "topo.jsp" />

<div class="alert-success text-center espaco">
    Listagem dos Alunos
</div>

<table class="table table-bordered table-striped text-center">
    <thead>
        <tr>
            <th>RA</th>
            <th>Nome</th>
            <th>Curso</th>
            <th colspan="2">Operações</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="aluno" items="${listaAlunos}">
        <form method="post" action="AlunosControle">
            <tr>
                <td class="align-middle">${aluno.ra}</td>
                <td class="align-middle text-justify">${aluno.nome}</td>
                <td class="align-middle">${aluno.curso}</td>
                <td class="align-middle"><input class="btn btn-primary btn-sm text-center" type="submit" name="operacao" value="Editar" /></td>
                <td class="align-middle"><input class="btn btn-danger btn-sm" type="submit" name="operacao" value="Excluir" /></td>
            </tr>

            <input type="hidden" name="ra" value="${aluno.ra}" />
        </form>
    </c:forEach>
</tbody>
</table>
<c:import url = "rodape.jsp" />