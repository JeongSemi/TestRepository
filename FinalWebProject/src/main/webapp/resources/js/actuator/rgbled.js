var eventdata;
var json;
var red;
var green;
var blue;

function rgbled(command, red, green, blue) {

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
			if (data.result == "success") {
				$("#rgbledStatus").css(
						"background-color",
						"rgb(" + data.red + "," + data.green + "," + data.blue
								+ ")")
			}
		}
	});

}

//var ws = new WebSocket("ws://" + location.host
//		+ "/FinalWebProject/websocket/rgbled");
//ws.onmessage = function(event) {
//	console.log(event.data);	
//	eventdata = JSON.parse(event.data);
//	var json = {"rgbRed":eventdata.rgbRed, "rgbGreen":eventdata.rgbGreen, "rgbBlue":eventdata.rgbBlue};
//	
//	
//
//	$.ajax({
//		url : "http://" + location.host + "/FinalWebProject/status/rgbled",
//		data : json,
//		method : "post",
//		success : function(data) {
//			if (data.result == "success") {
//				$("#rgbledStatus").css(
//						"background-color",
//						"rgb(" + data.rgbRed + "," + data.rgbGreen + ","+ data.rgbBlue + ")")
//				console.log(data.rgbRed);
//			}
//		}
//	});
//}
