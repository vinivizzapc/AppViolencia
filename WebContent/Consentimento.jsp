<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
	<meta charset="utf-8">
  		<meta name="viewport" content="width=device-width, initial-scale=1">
  		<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/Consetimento.css" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;700&display=swap" rel="stylesheet">
	<!-- Adicionando JQuery -->
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

<!-- Adicionando Javascript -->
</head>
<body>
	<div id="main" class="container">
	<h3 class="page-header" align="center"> <strong>Consentimento do Usuário</strong></h3>
	
		<div class=page-Text>
		<span class="TextAP">
			1. Acesso ao Aparelho :
		</span>
		
		<span class="TextAp">
			Vamos pedir permissão para entrar em seu aparelho, para gravar áudios e gravar uma Palavra-Chave, para quando achar que irá sofrer algum tipo de violencia, apenas fale a Palavra-Chave e o aplicativo começara a gravar seu audio.
		</span>
		<br>
		<br>
		<span class="TextAP">
			2. Acesso ao Google Drive :
		</span>
		
		<span class="TextAp">
			Pedimos para que entre com uma conta Google que tenha fácil acesso, pois alem dos áudios estarem no aplicativo eles serão enviados para seu google Drive, para com isso você tera um backup de todos os seus áudios gravados.
		</span>
		<br>
		<br>
		<span class="TextAP">
			3. Operar em segundo plano :
		</span>
		
		<span class="TextAp">
			O aplicativo funcionara em segundo plano, com isso a partir do momento em que dizer a Palavra Chave o aplicativo irá iniciar a gravação  do momento que tem duração de 15 segundos, o aplicativo para de funcionar quando faça o logOut do App.
		</span>
		<br>
		<br>
		<span class="TextAP">
			4. Uso de Dados :
		</span>
		
		<span class="TextAp">
			Com o uso do Aplicativo pode ter um fluxo de Dados moderado e pode usar pouco da memoria de seu celular, o desempenho de seu celular não será comprometido com o uso do aplicativo em segundo plano.
		</span>
		<br>
		<br>
		<span class="TextAP">
			5. Desempenho do APP :
		</span>
		
		<span class="TextAp">
			Considerando  que o aplicativo tem o uso baixo de memoria, o desempenho dele é semelhante ao seu uso não atrapalhando na navegação do mesmo.
		</span>
		<br>
		<br>
		<span class="TextAP">
			6. Contato com Suporte :
		</span>
		
		<span class="TextAp">
			Se observar algum tipo de BUG em nosso aplicativo contate o nosso suporte para que consigamos arrumar o mais rápido possível para que não haja nenhum erro maior em seu uso.
		</span>
		<br>
		<br>
		<span class="TextAP">
			7. Sugestões :
		</span>
		
		<span class="TextAp">
			Se você usuário tiver algum tipo de sugestão para que tenhamos um app mais completo e mais interativo, contate o numero que está localizado na página inicial, no horários de segunda a sexta das 8:00 as 18:00.
		</span>
		
	</div>	
	
	
	<div class="check">
		<!-- Default unchecked -->
		<div class="custom-control custom-checkbox">
	    	<input name="checkAceitar" type="checkbox"  id="checkID" onclick="myFunction()">
	    	<label  for="defaultUnchecked">Eu li e concordo com os termos de uso, descristos acima e libero a utilização dos áudios apenas para fins de ajuda.</label>
		</div>
		<div class="btn-prosseguir input-group">
			<form action="controller.do" method="post" style="margin-left: 15px; margin-bottom: 20px">
				<button class="btn btn-success" name="command" value="AccTermo" type="submit" id="Next">Prosseguir</button>			
				<button name="command" value="EfetuarLogoffCli" class="btn btn-danger" aria-pressed="true">cancelar</button>
			</form>
		</div> 
	</div>
</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script>
		document.getElementById("Next").disabled = true;
		function myFunction() {
		  var checkBox = document.getElementById("checkID");
		  
		  if (checkBox.checked == true){
		    document.getElementById("Next").disabled = false;
		  } else {
		      document.getElementById("Next").disabled = true;
		  }
		}
	</script>
</body>
</HTML>