function lcd(command) {
	var line0 = $("#line0").val();
	var line1 = $("#line1").val();
	var json = {"command":command, "value1":line0, "value2":line1};

	$.ajax({
		url:"http://" + location.host + "/FinalWebProject/actuator/lcd",
		data: json,
		method: "post",
		success: function(data) {
			if(data.result == "success") {
				$("#lcdStatus").html("<br/>line0=" + data.line0 + "<br/>line1=" + data.line1);
			}
		}
	});	
	
}

function lcdData() {
	var ws = new WebSocket("ws://" + location.host
			+ "/FinalWebProject/websocket/lcd");
	ws.onmessage = function(event) {
		var json = {
			"command" : "status"
		};
		$.ajax({
			url : "http://" + location.host + "/FinalWebProject/status/lcd",
			data : json,
			method : "post",
			success : function(data) {
				if (data.result == "success") {
					$("#line0").val(data.line0);
					$("#line1").val(data.line1);
				}
			}
		});
	}
}