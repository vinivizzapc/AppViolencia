const express = require('express');

const routes = express.Router();

const passport = require('passport');

const mysql = require('./mysql');

const cookieSession = require('cookie-session')
require('./passport-setup');

routes.use(cookieSession({
    name: 'tuto-session',
    keys: ['key1', 'key2']
}));

const isLoggedIn =  (req, res, next) => {
    if (req.user){
        next();
    } else{
        res.sendStatus(401);
    }
}

routes.use(passport.initialize());
routes.use(passport.session());

routes.get('/google', passport.authenticate('google', {scope : ['profile', 'email']}));

routes.get('/google/callback', passport.authenticate('google', { failureRedirect: '/failed'}),
    function(req,res) {
        res.redirect('/login');
    }
);

routes.get('/login', isLoggedIn, (req,res) => {
    const email = req.user._json.email;
    mysql.query('SELECT * FROM usuario WHERE Email = ?', [email] , function (error,results,fields){
        if(results.length == 1) {
            res.json(req.user);
        } else {
            const id = null;
            const nome = req.user._json.name;
            const email = req.user._json.email;
            mysql.query(`INSERT INTO usuario(id, nome, email) VALUES(${id}, '${nome}', '${email}')`);
            res.redirect('/Cfrasechave');
        }
    });
});

routes.put('/Cfrasechave', (req,res) => {
    const frasechave = req.body;
    const email = req.user._json.email;
    mysql.query(`UPDATE usuario SET frasechave = ? WHERE Email = ?`, [frasechave, email], function (error,results,fields){
        res.json(req.user);
    });
});

routes.get('/logout', (req,res) => {
    req.session = null;
    req.logout();
    res.redirect('/google');
});

module.exports = routes;