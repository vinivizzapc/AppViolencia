<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/LoginPrincipal.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;700&display=swap" rel="stylesheet">
</head>
<body>
	<div class="ladoEsquerdo"> <img src="imagens/logo1.png"/></div>
	<div class="cadastroletraLogin">
		<div id="main" class="container">
		<br>
		<br>
		<c:if test="${not empty err}">
			<div class="alert alert-danger" role="alert">${err}</div>
		</c:if>
		<c:out value="${msg}"></c:out>
			<h1 class="page-header">Cadastro</h1>
			<hr>
			<form action="controller.do" method="post">
							<div class="row">
					<div class="form-group col-md-12">
					
						<label class="tit" for="email">Nome:</label>
						<input type="text" class="form-control" name="nome" id="nome" required maxlength="50" placeholder="Digite o Nome" />
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-12">
					
						<label class="tit" for="email">Email:</label>
						<input type="email" class="form-control" name="email" id="email" required maxlength="50" placeholder="Digite o E-mail" />
					</div>
				</div>
					<div class="row">
						<div class="form-group col-md-12">
							<label class="tit" for="senha">Senha:</label>
							<input type="password" class="form-control" name="senha" id="senha" required maxlength="50" placeholder="Digite a Senha" />
						</div>
					<input class="check" type="checkbox" onclick="mostrarSenha()" /><label class="mostSenha" for="mostsenha">Mostrar Senha</label>
				</div>
				
				<hr />
				<div class="containerLogin">
					<div id="actions" class="row">
						<div class="md-col-12">
							<button type="submit" class="btn btn-primary" name="command" value="CriarUsuario">Cadastrar</button>
							<a href="index.jsp" class="btn btn-danger">Cancelar</a>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
	<div class="ladoDireito"></div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script>
			function mostrarSenha(){
				var tipo = document.getElementById("senha");
				if(tipo.type == "password"){
					tipo.type = "text";
				}else{
					tipo.type = "password";
				}
			}
		</script>
</body>
</HTML>