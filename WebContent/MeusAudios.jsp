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
		crossorigin="anonymous" 
	/>
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>
	<c:import url="header.jsp" />
	<div class="cadastroletraLogin">
		<div class="container">
		<br>
			<h3 class="page-header" align="center"><strong>Minhas Gravações</strong></h3>
			<br>
			<form action="controller.do " method="post">
				<h3>Áudios do Usuário</h3>
				<div id="actions" class="row">
					<div class="md-col-12">
						<c:forEach var="audio" items="${lista}">
							<hr>
							<p style="font-weight: bold">${audio.nomeAudio}</p>
							<audio controls src="${audio.base64}">
							</audio>
							<p style="font-size: 12px">${audio.data}</p>
						</c:forEach>
						<br>
						<br>
						<a href="index.jsp" class="btn btn-danger" role="button" aria-pressed="true">Voltar</a>
					</div>
				</div>
			</form>
		</div>
	</div>
	<br>
	<c:import url="footer.jsp" />
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</HTML>

