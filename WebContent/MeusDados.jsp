<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
	<meta charset="utf-8">
  		<meta name="viewport" content="width=device-width, initial-scale=1">
  		<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;700&display=swap" rel="stylesheet">
  		<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/MeusDados.css" rel="stylesheet">
	<link href="css/Header.css" rel="stylesheet">
  		<link rel="stylesheet" href="./css/footer.css">
  		<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/material-design-icons/3.0.1/iconfont/material-icons.min.css"
	integrity="sha256-x8PYmLKD83R9T/sYmJn1j3is/chhJdySyhet/JuHnfY="
	crossorigin="anonymous" />
	<!-- Adicionando JQuery -->
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

<!-- Adicionando Javascript -->
</head>
<body>
	<c:import url="header.jsp" />
<div class="cadastroletraLogin">
	<div class="container">
	<br>
		<h3 class="page-header" align="center"> <strong>Meus Dados</strong></h3>
		<br>
		<form action="controller.do " method="post">
			<h2>Informações do Usuário</h2>
			<br>
			<input type="hidden" name="idUsuario" value="${usuario.idUsuario}"/>
			<div class="row">
				<div class="form-group col-md-12 linha">
					<label class="tit" for="nome">Nome:	</label> 
					<input value="${usuario.nome}" type="text" class="form-control"	name="nome" id="nome" maxlength="50" />
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-12">
					<label class="tit" for="email">E-mail:</label> 
					<input value="${usuario.email}" type="text" class="form-control" name="email" id="email" maxlength="50" />
				</div>
				</div>
					<div class="row">
				<div class="form-group col-md-12">
					<label for="senha">Senha:</label> 
					<input value="${usuario.senha}" type="password" class="form-control"	name="senha" id="senha" maxlength="50" />
				</div>
				<input class="check" type="checkbox" onclick="mostrarSenha()" /><label class="mostSenha" for="mostsenha">Mostrar Senha</label>
				</div>
			<hr />
			<div class="containerLogin">
				<div id="actions" class="row">
					<div class="md-col-12">
					<button type="submit" class="btn btn-primary" name="command" value="AlterarMeusDados">Salvar</button>
						<a href="index.jsp" class="btn btn-danger"
							role="button" aria-pressed="true">Voltar</a>
					</div>
				</div>
			</div>
		</form>
	</div>
</div>
<br>
		<c:import url="footer.jsp" />
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

