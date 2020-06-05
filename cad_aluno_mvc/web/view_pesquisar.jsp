<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:import url = "topo.jsp" />

<div class="alert-success text-center espaco">
    Página de Pesquisa
</div>

<form name="pesquisar" method="post" action="AlunosControle">
    <div class="row">
        <div class="form-group col-md-4 mb-2">
            <input class="form-control"
                   type="text"
                   name="ra"
                   placeholder="digite o ra do aluno"
                   required>
        </div>
        <div class="form-group col-md-1 mb-2">
            <input type="hidden" name="operacao" value="Pesquisar">

            <input
                class="btn btn-primary"
                type="submit"
                value="Pesquisar" />
        </div>
    </div>
    <span class="erro"><c:out value = "${mensagem}" /></span>

</form>

<c:import url = "rodape.jsp" />