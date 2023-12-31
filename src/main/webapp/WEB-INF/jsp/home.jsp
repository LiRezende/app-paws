<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<meta charset="ISO-8859-1">
<title>AppVenda</title>
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<div class="container-fluid">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link active" href="/">AppVenda</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="/vendedor/list">Vendedores</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="/produto/list">Produtos</a>
				</li>
				<li class="nav-item"><a class="nav-link"
					href="/alimenticio/list">Aliment�cios</a></li>
				<li class="nav-item"><a class="nav-link"
					href="/eletronico/list">Eletr�nicos</a></li>
			</ul>
			<c:if test="${not empty list}">
				<form class="d-flex" action="/${route}/pesquisar">
					<input class="form-control me-2" type="text" name="campoBusca"
						placeholder="Search">
					<button class="btn btn-primary" type="submit">Search</button>
				</form>
			</c:if>
		</div>
	</nav>

	<div class="container mt-3">

		<span class="badge rounded-pill bg-primary">Vendedor:
			${qtdeVendedor}</span> <span class="badge rounded-pill bg-secondary">Produto:
			${qtdeProduto}</span> <span class="badge rounded-pill bg-success">Aliment�cio:
			${qtdeAlimenticio}</span> <span class="badge rounded-pill bg-danger">Eletr�nico:
			${qtdeEletronico}</span>

		<c:if test="${not empty listgem}">
			<h2>AppVenda</h2>
			<p>Gest�o de vendas de produtos:</p>
			<table class="table">
				<thead class="table-dark">
					<tr>
						<th>${titulo}</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${listgem}">
						<tr>
							<td>${item}</td>
							<td><a href="/${route}/${item.id}/excluir">excluir</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>


		<c:if test="${empty list}">
			<hr>
			<form action="/informacao/incluir" method="post">
				<div class="row">
					<div class="col">
						<input type="text" class="form-control"
							placeholder="Entre com o campo" name="campo">
					</div>
					<div class="col">
						<input type="text" class="form-control"
							placeholder="Entre com a descri��o" name="descricao">
					</div>
					<div class="col">
						<button class="btn btn-primary" type="submit">Cadastrar</button>
					</div>
				</div>
			</form>

			<c:if test="${not empty info}">
				<hr>
				<table class="table">
					<thead class="table-dark">
						<tr>
							<th>Informa��es:</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${info}">
							<tr>
								<td>${item}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
		</c:if>

		<c:if test="${not empty obj}">
			<hr>
			<div class="alert alert-success">
				<strong>Sucesso!</strong> ${obj}
			</div>
		</c:if>
	</div>
</body>
</html>