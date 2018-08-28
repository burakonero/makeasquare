var http = require('http');
var express = require('express');
var app = express();

app.set('port', process.env.OPENSHIFT_NODEJS_PORT || 8080);
app.set('ip', process.env.OPENSHIFT_NODEJS_IP || '127.0.0.1');

http.createServer(app).listen(app.get('port'), app.get('ip'), function(){
  console.log('Express server listening on port ' + app.get('port'));
});

app.get('/', function (req, res) {
	
});

var usernumm = 0;
var usernumm1 = 0;
var usernum1 = [];
var whoturn = [];
var nick3='aa';
var playagain = 0;
io.on('connection', function(socket){
	console.log('biri geldi');
	
	usernumm++;
	io.sockets.emit('usernum', usernumm);
	usernum1[usernumm] =  socket.id;
	for(var i = 0;i<1000;i++){
		whoturn[i] = 0;
		}
	
 	socket.on('doit', function () {
		
		console.log('***yapti');
	});
	 socket.on('doit2', function (data) {
		
		console.log("doit2 says that:  "+data);
	});
	/*
	socket.on('disconnect', function () {
		usernumm--;
		io.sockets.emit('usernum', usernumm);
		console.log('***Client disconnected');
	});
	
	socket.on('getroom', function (data) {
			var roomreal = 0;
			var usera = findusernum();
			for(;usera > 0;usera--){
			if(usera%2 - 1 == 0){roomreal++;}}
		if(data == roomreal){io.sockets.emit('getroomf', roomreal );}else{}
		
	});*/
	socket.on('getbrowser1', function (data) {
		var a=findusernum();
	
		io.sockets.emit('getbrowser1f', a );
	});
	
	socket.on('darkenit', function (data) {
			
		if(data.room3 == findroom()){
		io.sockets.emit('darkenit1', {room2: findroom(), buttonnum1: data.buttonnum, playernum2: findusernum()} );}
		
		else{console.log('buton room - '+data.room3+'real room - '+findroom()+'usenum - '+findusernum());}
	});
	socket.on('getnick', function (data) {
		
		io.sockets.emit('getnick1', {room4: findroom(), nick1: data.nick, nick2:nick3} );
		
	});
	socket.on('playagain1', function (data) {
		if(data==findroom()){
			playagain++;
			if(playagain==2){
				playagain=0;
				io.sockets.emit('playagain', findroom());
				}
			
			}
		
	});
	socket.on('pushnick', function (data) {
		console.log('1111');
		nick3=data;
		console.log('2222');
		//io.sockets.emit('turnchangeA', {playernum1: "0", room1: data.room} );
		
	});
	
	socket.on('turnchange', function (data) {
		if(data.room == findroom()){
			if (data.playernum == findusernum()%2){
				if(data.playernum ==1){io.sockets.emit('turnchangeA', {playernum1: "0", room1: data.room} );}else{io.sockets.emit('turnchangeA', {playernum1: "1", room1: data.room} );}
				}
		

		console.log('whoturn - '+data.playernum);}
	});
	socket.on('disconnect', function () {
		usernumm--;
		console.log('___Client disconnected now ' +usernumm+ ' player is online ');
		io.sockets.emit('disconnuser', findroom());
		console.log('ID NO :'+socket.id);
		
	});
	
	function findusernum(){
		for(var i = 0; i<100;i++){
			if(usernum1[i] == socket.id ){return i;}else{}
			}
	}
	function findroom(){
			var roomreal2 = 0;
			var usera2 = findusernum();
			for(;usera2 > 0;usera2--){
			if(usera2%2 - 1 == 0){roomreal2++;}else{}}
			return roomreal2;
	}
  
  	//finds number of online users
	
});

http.listen(port, function(){
  console.log('listening on *:' + port);
});
	
