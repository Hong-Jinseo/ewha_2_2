//node.js의 http모듈을 변수 http로 추출
var http = require("http");

//http모듈의 createServer 함수를 호출하여 서버를 생성
//request: 웹 요청 매개변수, response: 웹 응답 매개변수
http.createServer(function (request, response) { 
    // Send the HTTP header 
    // HTTP Status: 200 : OK -> 응답 성공
    // Content Type: text/plain 
    //writeHead: 응답 헤더를 작성. 
    response.writeHead(200, {'Content-Type': 'text/plain'}); 

    // Send the response body as "Hello World" 
    //end : 응답 본문 작성
    //listen : 매개변수로 포트와 호스트 지정
    response.end('Hello World\n'); 
}).listen(8081);

// Console will print the messge
console.log('Server running at http://127.0.0.1:8081/');
