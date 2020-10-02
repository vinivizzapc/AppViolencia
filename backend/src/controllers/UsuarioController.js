const mysql = require('../mysql');

module.exports = {
    async CadastrarUsuario(req,res){
        const {
            id,
            nome,
            telefone,
            email,
            senha,
            frasechave
        } = req.body;
        
        mysql.query(`INSERT INTO usuario(id, nome, telefone, email, senha, FraseChave) VALUES(${id}, '${nome}', '${telefone}', '${email}', '${senha}', '${frasechave}')`);
    
        return res.json({nome, telefone, email, senha, frasechave});
    }
}