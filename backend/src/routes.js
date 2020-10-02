const express = require('express');

const UsuarioController = require('./controllers/UsuarioController');

const routes = express.Router();

routes.post('/cadastro', UsuarioController.CadastrarUsuario);

module.exports = routes;