<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:import url = "topo.jsp" />

<div class="alert-success text-center espaco">
    Tela de Mensagens
</div>

<c:out value = "${mensagem}" />
<c:import url = "rodape.jsp" />