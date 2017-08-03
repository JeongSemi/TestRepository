//function requestLaserData(imageId) { // home.jsp 파일에서 선언한 img의 id명을 매개변수로
//										// 받아온다.
//
//	var ws = new WebSocket("ws://" + location.host
//			+ "/FinalWebProject/websocket/laser");
//	ws.onmessage = function(event) {
//		var image = document.getElementById(imageId); // 이미지 id
//
//		var json = {
//			"command" : command,
//			"value" : value
//		};
//	
//		$.ajax({
//					url : "http://" + location.host
//							+ "/FinalWebProject/websocket/laser",
//					data : json,
//					method : "post",
//					success : function(data) {
//						if (data.result == "success") {
//							if (command.equals("laseremitter")) {
//								if (value.equals("on")) {
//									image.src = "<%=application.getContextPath()%>/resources/images/actuators/laser_highlight.png";
//
//								} else if (value.equals("off")) {
//									image.src = "<%=application.getContextPath()%>/resources/images/actuators/laser.png";
//								}
//
//							}
//						}
//					}
//				});
//
//		laseremitter(command, value);
//
//	};
//}

function laseremitter(command, value) {
	var json = {
		"command" : command,
		"value" : value
	};
	$.ajax({
		url : "http://" + location.host
				+ "/FinalWebProject/actuator/laseremitter",
		data : json,
		method : "post",
		success : function(data) {
			if (data.result == "success") {
				$("#laseremitterStatus").html(data.status);
			}
		}
	});
}

