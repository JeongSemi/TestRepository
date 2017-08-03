var ws = new WebSocket("ws://" + location.host + "/FinalWebProject/websocket/buzzer");
ws.onmessage = function(event) {
	console.log(event.data);

//	var json = {
//		"command" : command,
//		"value" : value
//	};

//	$.ajax({
//				url : "http://" + location.host
//						+ "/FinalWebProject/status/buzzer",
//				data : json,
//				method : "post",
//				success : function(data) {
//					if (data.result == "success") {
//						if (command.equals("buzzer")) {
//							if (value.equals("on")) {
//								image.src = "<%=application.getContextPath()%>/resources/images/actuators/buzzer_highlight.png";
//
//							} else if (value.equals("off")) {
//								image.src = "<%=application.getContextPath()%>/resources/images/actuators/buzzer.png";
//							}
//
//						}
//					}
//				}
//			});
};

function buzzer(command, value) {
	var json = {
		"command" : command,
		"value" : value
	};
	$.ajax({
		url : "http://" + location.host + "/FinalWebProject/actuator/buzzer",
		data : json,
		method : "post",
		success : function(data) {
			if (data.result == "success") {
				$("#buzzerStatus").html(data.status);
			}
		}
	});
}
