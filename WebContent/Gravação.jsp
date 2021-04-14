<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/MeusDados.css" rel="stylesheet">
	<link href="css/Header.css" rel="stylesheet">
	<link href="css/style.css" rel="stylesheet">
  	<link rel="stylesheet" href="./css/footer.css">
  	<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;700&display=swap" rel="stylesheet">
  	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/material-design-icons/3.0.1/iconfont/material-icons.min.css" integrity="sha256-x8PYmLKD83R9T/sYmJn1j3is/chhJdySyhet/JuHnfY=" crossorigin="anonymous" />
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>
	<c:import url="header.jsp" />
	<div class="cadastroletraLogin">
		<div class="container">
			<br>
			<br>
  			<p><strong>Gravacoes:</strong></p>
  			<form action="controller.do" enctype="multipart/form-data" method="post">
				<hr />
				<input type="hidden" id="teste" name="Arquivo">
				<input type="hidden" name="idUsuario" value="${usuario.idUsuario}"/>
				<div class="form-group audio">
					<button type="button" style="margin-bottom: 15px" class="btn btn-success" id="btn">Gravar</button>
				</div>
				<div class="form-group">
					<label>Nome do audio:</label>
					<input class="form-control" type="text" name="nomeAudio"/>
				</div>
				<div id="actions" class="row">
					<div class="md-col-12">
						<button type="submit" class="btn btn-primary" name="command" value="InserirAudio">Inserir audio</button>
						<a href="index.jsp" class="btn btn-danger" role="button" aria-pressed="true">Voltar</a>
					</div>
				</div>
			</form>
		</div>
	</div>
	<br>
	
	
<script>
    $(function(){
        let mediaRecorder;
        navigator
        	.mediaDevices.getUserMedia({ audio: true })
            .then( stream => {
                mediaRecorder = new MediaRecorder(stream)
                let chunks = [];
                mediaRecorder.ondataavailable = data => {
                    chunks.push(data.data);
                }
                mediaRecorder.onstop = () => {
                    const blob = new Blob(chunks, { type: 'audio/ogg; code=opus' })
                    const reader = new window.FileReader()
                    reader.readAsDataURL(blob)
                    reader.onloadend = () => {
                        const audio = document.createElement('audio');
                        audio.src = reader.result;
                        audio.controls = true;
                        console.log(reader.result);
                        $('.audio').append(audio);
                        $('#teste').val(reader.result);
                    }
                }
            }, err => {
                $('body').append('<p>Você deve permitir o áudio</p>');
            });

            $('#btn').click(function(){
                if($(this).text() === 'Gravar'){
                    mediaRecorder.start()
                    $(this).text('Parar')
                } else{
                    mediaRecorder.stop()
                    $(this).text('Gravar')
                }
            });
    })
</script>
	<c:import url="footer.jsp" /> 
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</HTML>

