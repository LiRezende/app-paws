<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
	<meta charset="ISO-8859-1">
	<title>App Paws</title>
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	  <div class="container-fluid">
	    <ul class="navbar-nav">
	      <li class="nav-item">
	        <a class="nav-link active" href="/">App Paws</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="/vendedor/lista">Vendedores</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="/produto/lista">Produtos</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="/brinquedo/lista">Brinquedos</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="/farmaceutico/lista">Farmacêuticos</a>
	      </li>
	    </ul>
	  </div>
	</nav>

	<div class="container mt-3">

		<span class="badge rounded-pill bg-primary">Vendedor: ${qtdSalesman}</span>
	  	<span class="badge rounded-pill bg-secondary">Produto: ${qtdProduct}</span>
	  	<span class="badge rounded-pill bg-success">Brinquedo: ${qtdToy}</span>
	  	<span class="badge rounded-pill bg-danger">Farmacêutico: ${qtdFarmacy}</span>

  		<c:if test="${not empty list}">
			<h2>App Paws</h2>
			<p>Gest�o de vendas de produtos:</p>
			<table class="table">
				<thead class="table-dark">
					<tr>
					  <th>${title}</th>
					  <th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${list}">
						<tr>
						  <td>${item}</td>
						  <td><a href="/${rota}/${item.id}/excluir">excluir</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
</body>
</html>