<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:import url = "topo.jsp" />

<div class="alert-success text-center espaco">
    Cadastrar Aluno
</div>
<form name="cadastrar" method="post" action="AlunosControle" >
    <div class="row" >
        <div class="col-md-5 mb-3">
            <label>RA</label>
            <input 
                type="text"
                class="form-control"
                name="ra"
                placeholder="Ex.: 123456 (somente números)"
                value="" required>
        </div>
    </div>

    <div class="row">
        <div class="col-md-6 mb-3">
            <label>Nome</label>
            <input
                type="text"
                class="form-control"
                name="nome" placeholder="João da Silva"
                value="" required>
        </div>
    </div>

    <div class="row">
        <div class="col-md-6 mb-3">
            <label>Curso</label>
            <input
                type="text"
                class="form-control"
                name="curso"
                placeholder="TADS"
                value="" required>
        </div>
    </div>

    <div class="row">
        <div class="col-md-6 mb-3">
            <input type="hidden" name="operacao" value="Inserir">
            <input
                class="form-control btn btn-primary"
                type="submit"
                value="Cadastrar" />
        </div>
    </div>
</form>
<c:import url = "rodape.jsp" />