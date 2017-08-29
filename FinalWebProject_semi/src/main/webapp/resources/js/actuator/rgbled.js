var currRed;
var currGreen;
var currBlue;

function rgbled(command, red, green, blue) {
	$("#rgbledStatus").css("background-color","rgb(" + red + "," + green + ","+ blue + ")")	
	currRed = red;
	currGreen = green;
	currBlue = blue;
	var json = {
		"command" : command,
		"value1" : red,
		"value2" : green,
		"value3" : blue
	};
	$.ajax({
		url : "http://" + location.host + "/FinalWebProject/actuator/rgbled",
		data : json,
		method : "post",
		success : function(data) {
		}
	});

}

var ws = new WebSocket("ws://" + location.host + "/FinalWebProject/websocket/rgbled");
ws.onmessage = function(event) {		
	var json = JSON.parse(event.data);
	$.ajax({
		url : "http://" + location.host + "/FinalWebProject/status/rgbled",
		data : json,
		method : "post",
		success : function(data) {
			//console.log("====" + data.rgbRed +"====" + data.rgbGreen +"====" + data.rgbBlue);
			//console.log("++++" + currRed +"++++" + currGreen +"++++" + currBlue);
			if((currRed == data.rgbRed) && (currGreen == data.rgbGreen) && (currBlue == data.rgbBlue)){
				$("#rgbledStatus").css("background-color","rgb(" + data.rgbRed + "," + data.rgbGreen + ","+ data.rgbBlue + ")")	
			}
			currRed = data.rgbRed;
			currGreen = data.rgbGreen;
			currBlue = data.rgbBlue;
		}		
	});
}
