var http = require("http");
var module = require('./myfirstmodule.js');

http.createServer(function (request, response) { 
    response.writeHead(200, {'Content-Type': 'text/plain; charset=utf-8'});
    response.end('The date and time are currently: '+module.myDateTime()); 
}).listen(8080);

console.log('Server running at http://localhost:8080/');