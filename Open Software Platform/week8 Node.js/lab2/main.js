var http = require("http");
const url = require("url");
const fs = require("fs");

var data1;
var data2;

http.createServer(function (request, response) { 
    //const path = url.parse(request.url, true).pathname;
    
    fs.readFile(__dirname + '/vieworders.html', (err, data) => {
        if (err) {
            return console.error(err);
        }
        else{
            fs.readFile(__dirname + '/orders.txt', (err, orders) => {
                if (err){
                    return console.error(err);
                }
                else{
                    response.writeHead(200, {'Content-Type': 'text/html; charset=utf-8'});
                    response.end(data+orders, 'utf-8');
                    
                }
            })
        }
    })
}).listen(8081);

console.log('Server running at http://localhost:8081/');