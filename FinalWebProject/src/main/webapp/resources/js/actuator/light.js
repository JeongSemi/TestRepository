function light(command, value) {
	var json = {"command":command, "value":value};
	$.ajax({
		url:"http://" + location.host + "/FinalWebProject/actuator/light",
		data: json,
		method: "post",
		success: function(data) {
			if(data.result == "success") {
				$("#buzzerStatus").html(data.status);
			}
		}
	});
}