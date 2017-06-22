function lcd(command, line0, line1) {
	var json = {
		"command" : "change",
		"line0" : line0,
		"line1" : line1
	};

	console.log(line0);
	
	$.ajax({
		url : "http://" + location.host + "/SensingCarRemoteWebControl/lcd",
		data : json,
		method : "post",
		success : function(data) {
			if (data.result == "success") {
				$("#lcdline0").attr("value", data.line0);
				$("#lcdline1").attr("value", data.line1);
				$("#btnLcdline").attr("onclick", "lcd('change', '" + data.line0 + "', '" + data.line1 + "')");
			}
		}
	});
}