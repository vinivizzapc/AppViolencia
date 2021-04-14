<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta charset="UTF-8">

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container header">
			<a class="linkPrin" href="index.jsp">
				<img class="imgtop" src="imagens/logo1.png"/>
			<span class="navbar-brand">METENDO A COLHER</span></a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSite" aria-controls="navbarSite"
				aria-expand="true" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSite">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item seila"><a class="nav-link"
						href="index.jsp"><i class="material-icons icon">home</i> Pagina
							Inicial</a></li>
					
					<li class="nav-item seila"><a class="nav-link" href="controller.do?command=GravarAudio&idUsuario=${usuario.idUsuario}">
							<i class="material-icons icon">mic</i> Gravar Áudio 
					</a></li>

					<li class="nav-item seila"><a class="nav-link"
						href="controller.do?command=ListarAudios&idUsuario=${usuario.idUsuario}"><i class="material-icons icon">volume_up</i> Ouvir seus Áudios</a></li>
					<li class="nav-item seila"><a class="nav-link"
						href="controller.do?command=VisualizarMeusDados&idUsuario=${usuario.idUsuario}"><i class="material-icons icon">person</i> Editar Conta</a></li>
					<li class="nav-item seila"><a class="nav-link"
						href="controller.do?command=EfetuarLogoffCli"><i class="material-icons icon">exit_to_app</i> Logoff</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<script src="bootstrap.js"></script>
	<script src="https://unpkg.com/@popperjs/core@2/dist/umd/popper.js"></script>
	<script src="js/jquery.min.cs"></script>