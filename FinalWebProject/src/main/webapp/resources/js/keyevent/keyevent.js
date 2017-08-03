var key;
var speedUpInterval = null;
var speedDownInterval = null;
var speedStopInterval = null;
var turnLeftInterval = null;
var turnCenterInterval = null;
var turnRightInterval = null;
var command;
var speed = 1500;
var angle = 65;

function onKeyDown_Event(event) {

	key = event.keyCode;
	console.log(key);

	if (key == 104) {
		speedUpSetInterval();
	} else if (key == 98) {
		speedDownSetInterval();
	} else if (key == 105) {
		speedStopSetInterval();
	} else if (key == 100) {
		turnLeftSetInterval();
	} else if (key == 101) {
		turnCenterSetInterval();
	} else if (key == 102) {
		turnRightSetInterval();
	}

}

function speedUpSetInterval() {

	if (speedUpInterval == null) {
		speedUpInterval = setInterval("speedUp()", 15);
	}
}

function speedUp() {
	if (speed < 1600) {
		command = "motor";
		speed += 2;
		var json = {
			"command" : command,
			"value" : speed
		};
		$
				.ajax({
					url : "http://" + location.host
							+ "/FinalWebProject/actuator/motor",
					data : json,
					method : "post",
				// success : function(data) {
				// if (data.result == "success") {
				// $("#buzzerStatus").html(data.status);
				// }
				// }
				});
	}

}

function speedDownSetInterval() {
	if (speedDownInterval == null) {
		speedDownInterval = setInterval("speedDown()", 15);
	}
}

function speedDown() {
	if (speed > 1400) {
		command = "motor";
		speed -= 2;
		var json = {
			"command" : command,
			"value" : speed
		};
		$
				.ajax({
					url : "http://" + location.host
							+ "/FinalWebProject/actuator/motor",
					data : json,
					method : "post"

				// success : function(data) {
				// if (data.result == "success") {
				// $("#buzzerStatus").html(data.status);
				// }
				// }
				});
	}
}

function speedStopSetInterval() {
	if (speedStopInterval == null) {
		speedStopInterval = setInterval("speedStop()", 15);
	}
}

function speedStop() {
	command = "motor";
	speed = 1500;
	var json = {
		"command" : command,
		"value" : 1500
	};
	$.ajax({
		url : "http://" + location.host + "/FinalWebProject/actuator/motor",
		data : json,
		method : "post",

	// success : function(data) {
	// if (data.result == "success") {
	// $("#buzzerStatus").html(data.status);
	// }
	// }
	});
}

function turnLeftSetInterval() {
	if (turnLeftInterval == null) {
		turnLeftInterval = setInterval("turnLeft()", 15);
	}
}

function turnLeft() {
	if (angle < 100) {
		command = "fronttire";
		angle += 1;
		var json = {
			"command" : command,
			"value" : angle
		};
		$.ajax({
			url : "http://" + location.host
					+ "/FinalWebProject/actuator/fronttire",
			data : json,
			method : "post",

		// success : function(data) {
		// if (data.result == "success") {
		// $("#buzzerStatus").html(data.status);
		// }
		// }
		});
	}
}

function turnCenterSetInterval() {
	if (turnCenterInterval == null) {
		turnCenterInterval = setInterval("turnCenter()", 15);
	}
}

function turnCenter() {
	command = "fronttire";
	angle = 65;
	var json = {
		"command" : command,
		"value" : angle
	};
	$
			.ajax({
				url : "http://" + location.host
						+ "/FinalWebProject/actuator/fronttire",
				data : json,
				method : "post",

				success : function(data) {
					if (data.result == "success") {
						$("#buzzerStatus").html(data.status);
					}
				}
			});
}

function turnRightSetInterval() {
	if (turnRightInterval == null) {
		if (angle > 30)
			turnRightInterval = setInterval("turnRight()", 15);
	}
}

function turnRight() {
	if (angle > 30) {
		command = "fronttire";
		angle -= 1;
		var json = {
			"command" : command,
			"value" : angle
		};
		$.ajax({
			url : "http://" + location.host
					+ "/FinalWebProject/actuator/fronttire",
			data : json,
			method : "post",

		// success : function(data) {
		// if (data.result == "success") {
		// $("#buzzerStatus").html(data.status);
		// }
		// }
		});
	}
}

function onKeyUp_Event(event) {
	if (key == 104) {
		clearInterval(speedUpInterval);
		speedUpInterval = null;
	} else if (key == 98) {
		clearInterval(speedDownInterval);
		speedDownInterval = null;
	} else if (key == 105) {
		clearInterval(speedStopInterval);
		speedStopInterval = null;
	} else if (key == 100) {
		clearInterval(turnLeftInterval);
		turnLeftInterval = null;
	} else if (key == 101) {
		clearInterval(turnCenterInterval);
		turnCenterInterval = null;
	} else if (key == 102) {
		clearInterval(turnRightInterval);
		turnRightInterval = null;
	}

}