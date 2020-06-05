<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:import url = "topo.jsp" />

<div class="alert-success text-center espaco">
    Editar Aluno
</div>
<c:forEach var="aluno" items="${listaAlunos}">
    <form name="cadastrar" method="post" action="AlunosControle" >
        <div class="row" >
            <div class="col-md-5 mb-3">
                <label>RA</label>
                <input type="text" class="form-control" name="ra" value="${aluno.ra}" disabled="">
            </div>
        </div>

        <div class="row">
            <div class="col-md-6 mb-3">
                <label>Nome</label>
                <input type="text" class="form-control" name="nome" value="${aluno.nome}" required>
            </div>
        </div>

        <div class="row">
            <div class="col-md-6 mb-3">
                <label>Curso</label>
                <input type="text" class="form-control" name="curso" value="${aluno.curso}" required>
            </div>
        </div>

        <div class="row">
            <div class="col-md-6 mb-3">
                <input type="hidden" name="operacao" value="Atualizar">
                <input type="hidden" name="ra" value="${aluno.ra}">
                <input class="form-control btn btn-primary" type="submit" value="Atualizar" />
            </div>
        </div>
    </form>
</c:forEach>
<c:import url = "rodape.jsp" />