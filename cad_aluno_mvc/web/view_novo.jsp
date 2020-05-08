<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%-- A linha abaixo faz a inserção do arquivo topo.jsp --%>
<c:import url="topo.jsp" />

<div class="alert-success text-center espaco">
    Novo Aluno
</div>

<form name="novo" method="post" action="AlunosController">
    <div class="row">
        <div class="col-md-4 mb-3">
            <label>RA</label>
            <input
                type="text"
                class="form-control"
                name="ra"
                value="" />
        </div>
    </div>
    <div class="row">
        <div class="col-md-4 mb-3">
            <label>NOME</label>
            <input
                type="text"
                class="form-control"
                name="nome"
                value="" />
        </div>
    </div>
    <div class="row">
        <div class="col-md-4 mb-3">
            <label>CURSO</label>
            <input
                type="text"
                class="form-control"
                name="curso"
                value="" />
        </div>
    </div>
    <div class="row">
        <div class="col-md-4 mb-3">
            <input
                type="submit"
                class="form-control btn btn-primary"
                name="bt_novo"
                value="Cadastrar" />
        </div>
    </div>
    <input 
        type="hidden"
        name="operacao"
        value="Inserir" />
</form>
<c:import url="rodape.jsp" />