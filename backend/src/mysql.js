const mysql = require('mysql');

const connection = mysql.createConnection({
    host: 'localhost',
    user: 'vitor',
    password: '080401',
    database: 'appviolencia'
});

module.exports = connection;