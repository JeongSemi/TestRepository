var currline0;
var currline1;

function lcd(command) {
	if(command == "refresh"){
		$("#line0").val(currline0);
		$("#line1").val(currline1);
	}
	else{
		var line0 = $("#line0").val();
		var line1 = $("#line1").val();
		var json = {"command":command, "value1":line0, "value2":line1};
	
		$.ajax({
			url:"http://" + location.host + "/FinalWebProject/actuator/lcd",
			data: json,
			method: "post",
			success: function(data) {			
			}
		});	
	}
	
}

var ws = new WebSocket("ws://" + location.host + "/FinalWebProject/websocket/lcd");
ws.onmessage = function(event) {
	var json = JSON.parse(event.data);
	$.ajax({
		url : "http://" + location.host + "/FinalWebProject/status/lcd",
		data : json,
		method : "post",
		success : function(data) {
			if (!(currline0 == data.lcdline0)){
				currline0 = data.lcdline0;
				$("#line0").val(data.lcdline0);
			}
			if (!(currline1 == data.lcdline1)){
				currline1 = data.lcdline1;
				$("#line1").val(data.lcdline1);
			}
		}
	});
}
