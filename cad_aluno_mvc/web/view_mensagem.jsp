<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%-- A linha abaixo faz a inserção do arquivo topo.jsp --%>
<c:import url="topo.jsp" />

<div class="alert-success text-center espaco">
    Tela de Mensagens
</div>

<!--
    A linha abaixo vai receber o valor do atributo "mensagem"
    e imprimirá no HTML (na tela)
-->
<c:out value="${mensagem}" />

<c:import url="rodape.jsp" />