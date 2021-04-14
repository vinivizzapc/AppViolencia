<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html lang="pt-br">
	<head>
  		<title>App - Metendo a Colher</title>
  		<link rel="icon" href="logo.ico" type="image/x-icon">
  		<meta charset="utf-8">
  		<meta name="viewport" content="width=device-width, initial-scale=1">
  		<link href="css/bootstrap.min.css" rel="stylesheet">
  		<link href="css/TelaInicial.css" rel="stylesheet">
  		<link href="css/Header.css" rel="stylesheet">
  		<link rel="stylesheet" href="./css/footer.css">

		<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;700&display=swap" rel="stylesheet">
  		<link rel="stylesheet"	href="https://cdnjs.cloudflare.com/ajax/libs/material-design-icons/3.0.1/iconfont/material-icons.min.css" integrity="sha256-x8PYmLKD83R9T/sYmJn1j3is/chhJdySyhet/JuHnfY="	crossorigin="anonymous" />
	</head>
	<body>
		<c:import url="header.jsp"/>

	<div class="container">
		<div class="col-md-11 col-lg-12 col-sm-8 col-xs-8" align="center">
				<p class="titulo1">Violência Doméstica</p>
				<div class="video">
					<video width="870" height="480" controls>
			  			<source src="Videos/Violencia.mp4" type="video/mp4">	</video>
				</div>
		</div>
		
		<div class="container-noticias">
		<p class="noticias">Notícias da Semana</p>
			<div class="col-md-12 col-lg-12 col-sm-12 col-xs-12" align="center">
				<a href="https://jmonline.com.br/novo/?noticias,1,GERAL,197581"><img class="Logo" src="imagens/noticia1.jpg" title="Campanha contra violência doméstica conta com auxílio de farmacias para incentivar denúncias" alt="noticia1"></a>
				<a href="https://secom.to.gov.br/noticias/cidadania-e-justica-alerta-para-o-aumento-da-violencia-domestica-contra-as-mulheres-durante-o-isolamento-social-499713/"><img class="Logo" src="imagens/noticia2.jpg" title="Cidadania e Justiça alerta para o aumento da violência doméstica contra as mulheres durante o isolamento social" alt="noticia2"></a>
				<a href="http://site.serjusmig.org.br/noticia/5208/confinamento-sem-violencia-domestica"><img class="Logo" src="imagens/noticia3.jpg" title="Confinamento sem violência doméstica" alt="noticia3"></a>
			</div>
		</div>
		<div class="texto">
		<p class="tituloTexto">Pelo fim da violência contra a mulher</p>
			<p>A violência contra a mulher é todo ato que resulte em morte ou lesão física, sexual ou psicológica de mulheres, tanto na esfera pública quanto na privada. Às vezes considerado um crime de ódio, este tipo de violência visa um grupo específico, com o gênero da vítima sendo o motivo principal. Este tipo de violência é baseada em gênero, o que significa que os atos de violência são cometidos contra as mulheres expressamente porque são mulheres.</p>
			<p>A violência contra a mulher pode enquadrar-se em várias categorias amplas, que incluem a violência realizada tanto por "indivíduos", como pelos "Estados". Algumas das formas de violência perpetradas por indivíduos são: Estupros, violência doméstica ou familiar, assédio sexual, coerção reprodutiva, infanticídio feminino, aborto seletivo e violência obstétrica, bem como costumes ou práticas tradicionais nocivas, como crime de honra, feminicídio relacionado ao dote, mutilação genital feminina, casamento por rapto, casamento forçado e violência no trabalho, que se manifestam através de agressões físicas, psicológicas e sociais.[5] Algumas formas de violência são perpetradas ou toleradas pelo estado, como estupros de guerra, violência sexual e escravidão sexual durante conflitos, esterilização forçada, aborto forçado, violência pela polícia e por autoridades, apedrejamento e flagelação. Muitas formas de violência contra a mulher, como o tráfico de mulheres e a prostituição forçada, muitas vezes são perpetradas por organizações criminosas. </p>
			<p>No Brasil a Lei Nº 10.778, de 24 de novembro de 2003, estabelece a notificação compulsória, no território nacional, do caso de violência contra a mulher que for atendida em serviços de saúde públicos ou privados. Essa lei é complementada pela Lei Maria da Penha como mais um mecanismo para coibir a violência doméstica e familiar contra a mulher, com medidas mais efetivas (penais) para o seu controle além do dimensionamento do fenômeno. Embora a notificação e investigação de cada agravo em si já proporcione um impacto positivo para reversão da impunidade que goza o agressor, de certo modo, defendido por uma tradição cultural machista além de naturalmente ser um instrumento direcionador das políticas e atuações governamentais em todos os níveis como previsto na legislação em pauta.</p>
			<p>A notificação compulsória das agressões contra a mulher foi resultado da constelação de que a ausência de dados estatísticos adequados, discriminados por sexo sobre o alcance da violência dificulta a elaboração de programas e a vigilância das mudanças efetuadas por ações públicas, conforme explícito na Plataforma de Pequim/95 (parágrafo 120). O Brasil tanto é signatário da Declaração e Plataforma de Ação da IV Conferência Mundial Sobre a Mulher, Pequim, 1995 como da Convenção Interamericana para Prevenir, Punir e Erradicar a Violência Contra a Mulher, Belém do Pará, (1995).</p>
		</div>
	</div>
		<c:import url="footer.jsp" />
		<script src="js/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
	</body>
</html>