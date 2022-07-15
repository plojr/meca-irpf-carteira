<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="header.jsp" />
<style>
td, th {
	text-align: center
}
</style>
<title>Gerenciar carteiras</title>
</head>
<body>
<div class="container-fluid">
	<div class="row flex-nowrap">
		<jsp:include page="sidebar.jsp" />
		<div class="col py-3">
			<h3>Carteiras existentes</h3>
			<c:forEach items="${carteiras}" var="carteira">
				<span>Carteira</span>
				<div><label>Data:</label> <span><c:out value="${carteira.data}"></c:out></span></div>
				<div><label>Custo total:</label> <span><fmt:formatNumber minFractionDigits="2" maxFractionDigits="2">${carteira.custoTotal}</fmt:formatNumber> </span></div>
				<span>Itens da carteira</span>
				<table class="table table-bordered">
				<tr>
					<th>Quantidade</th>
					<th>Ticker</th>
					<th>Custo total</th>
				</tr>
				<c:forEach items="${carteira.itens}" var="item">
				<c:if test="${item.quantidade ne 0 }">
					<tr>
						<td><c:out value="${item.quantidade}"></c:out></td>
						<td><c:out value="${item.ticker.codigo}"></c:out></td>
						<td><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${item.custoTotal}" /></td>
					</tr>
				</c:if>
				</c:forEach>
				</table>
				<br />
			</c:forEach>
			<form action="carteira" method="post">
				<div>
					<button type="submit" class="btn btn-primary btn-sm">Recalcular carteiras</button>
				</div>
			</form>
			<button class="btn" onclick="document.body.scrollTop = 0; document.documentElement.scrollTop = 0;">Ir para o topo</button>
		</div>
	</div>
</div>
</body>
</html>