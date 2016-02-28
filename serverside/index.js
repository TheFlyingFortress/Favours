var express = require('express');
var app = express();
var server = require('http').Server(app);
var io = require('socket.io')(server);

app.get('/', function(req, res){
  res.sendFile(__dirname + '/index.html');
});

io.on('connection', function (socket) {
  socket.emit('post job', "got the req");
  socket.on('what to do', function (data) {
    console.log(data);
  });
  socket.on('from where', function (data) {
    console.log(data);
  });
  socket.on('starting', function (data) {
    console.log(data);
  });
  socket.on('ending', function (data) {
    console.log(data);
  });
  socket.on('meeting', function (data) {
    console.log(data);
  });
});

server.listen(3000, function(){
  console.log('listening on localhost:3000');
});