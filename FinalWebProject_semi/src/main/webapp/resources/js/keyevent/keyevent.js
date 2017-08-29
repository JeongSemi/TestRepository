var downKey;
var upKey;
var command;
var speed = 1500;
var angle = 65;
var leftRightAngle = 92;
var upDownAngle = 10;

var speedUpInterval = null;
var speedDownInterval = null;
var speedStopInterval = null;
var turnLeftInterval = null;
var turnCenterInterval = null;
var turnRightInterval = null;

var cameraAngleUpInterval = null;
var cameraAngleDownInterval = null;
var cameraAngleCenterInterval = null;
var cameraAngleLeftInterval = null;
var cameraAngleRightInterval = null;

function onKeyDown_Event(event) {
    downKey = event.keyCode;
    //console.log(downKey);

    if (downKey == 104) {
        speedUpSetInterval();
    } else if (downKey == 98) {
        speedDownSetInterval();
    } else if (downKey == 105) {
        speedStopSetInterval();
    } else if (downKey == 100) {
        turnLeftSetInterval();
    } else if (downKey == 101) {
        turnCenterSetInterval();
    } else if (downKey == 102) {
        turnRightSetInterval();
    } else if (downKey == 87) {
        angleUpSetInterval();
    } else if (downKey == 88) {
        angleDownSetInterval();
    } else if (downKey == 83) {
        angleCenterSetInterval();
    } else if (downKey == 65) {
        angleLeftSetInterval();
    } else if (downKey == 68) {
        angleRightSetInterval();
    }

}

function speedUpSetInterval() {
    if (speedUpInterval == null) {
        speedUpInterval = setInterval("speedUp()", 10);
    }
}

function speedUp() {
    if (speed < 1600) {
        command = "motor";
        speed += 2;
        var json = {
            "command": command,
            "value": speed
        };
        $
            .ajax({
                url: "http://" + location.host +
                    "/FinalWebProject/actuator/motor",
                data: json,
                method: "post",
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
        speedDownInterval = setInterval("speedDown()", 10);
    }
}

function speedDown() {
    if (speed > 1400) {
        command = "motor";
        speed -= 2;
        var json = {
            "command": command,
            "value": speed
        };
        $
            .ajax({
                url: "http://" + location.host +
                    "/FinalWebProject/actuator/motor",
                data: json,
                method: "post"

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
        speedStopInterval = setInterval("speedStop()", 10);
    }
}

function speedStop() {
    command = "motor";
    speed = 1500;
    var json = {
        "command": command,
        "value": 1500
    };
    $.ajax({
        url: "http://" + location.host + "/FinalWebProject/actuator/motor",
        data: json,
        method: "post",

        // success : function(data) {
        // if (data.result == "success") {
        // $("#buzzerStatus").html(data.status);
        // }
        // }
    });
}

function turnLeftSetInterval() {
    if (turnLeftInterval == null) {
        turnLeftInterval = setInterval("turnLeft()", 10);
    }
}

function turnLeft() {
    if (angle < 100) {
        command = "fronttire";
        angle += 2;
        var json = {
            "command": command,
            "value": angle
        };
        $.ajax({
            url: "http://" + location.host +
                "/FinalWebProject/actuator/fronttire",
            data: json,
            method: "post",

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
        turnCenterInterval = setInterval("turnCenter()", 10);
    }
}

function turnCenter() {
    command = "fronttire";
    angle = 65;
    var json = {
        "command": command,
        "value": angle
    };
    $
        .ajax({
            url: "http://" + location.host +
                "/FinalWebProject/actuator/fronttire",
            data: json,
            method: "post",

            success: function(data) {
                if (data.result == "success") {
                    $("#buzzerStatus").html(data.status);
                }
            }
        });
}

function turnRightSetInterval() {
    if (turnRightInterval == null) {
        turnRightInterval = setInterval("turnRight()", 10);
    }
}

function turnRight() {
    if (angle > 30) {
        command = "fronttire";
        angle -= 2;
        var json = {
            "command": command,
            "value": angle
        };
        $.ajax({
            url: "http://" + location.host +
                "/FinalWebProject/actuator/fronttire",
            data: json,
            method: "post",

            // success : function(data) {
            // if (data.result == "success") {
            // $("#buzzerStatus").html(data.status);
            // }
            // }
        });
    }
}


function angleUpSetInterval() {
    if (cameraAngleUpInterval == null) {
        cameraAngleUpInterval = setInterval("angleUp()", 10);
    }
}

function angleUp() {
    if (upDownAngle < 100)
        upDownAngle += 1;
    var json = {
        "command": "camera",
        "value1": leftRightAngle,
        "value2": upDownAngle
    };
    $.ajax({
        url: "http://" + location.host +
            "/FinalWebProject/actuator/camera",
        data: json,
        method: "post",

        // success : function(data) {
        // if (data.result == "success") {
        // $("#buzzerStatus").html(data.status);
        // }
        // }
    });
}

function angleDownSetInterval() {
    if (cameraAngleDownInterval == null) {
    	cameraAngleDownInterval = setInterval("angleDown()", 10);
    }
}

function angleDown() {
    if (upDownAngle > 5)
        upDownAngle -= 1;
    var json = {
        "command": "camera",
        "value1": leftRightAngle,
        "value2": upDownAngle
    };
    $.ajax({
        url: "http://" + location.host +
            "/FinalWebProject/actuator/camera",
        data: json,
        method: "post",

        // success : function(data) {
        // if (data.result == "success") {
        // $("#buzzerStatus").html(data.status);
        // }
        // }
    });
}

function angleCenterSetInterval() {
    if (cameraAngleCenterInterval == null) {
    	cameraAngleCenterInterval = setInterval("angleCenter()", 10);
    }
}

function angleCenter() {
        upDownAngle = 10;
        leftRightAngle = 92;
    var json = {
        "command": "camera",
        "value1": leftRightAngle,
        "value2": upDownAngle
    };
    $.ajax({
        url: "http://" + location.host +
            "/FinalWebProject/actuator/camera",
        data: json,
        method: "post",

        // success : function(data) {
        // if (data.result == "success") {
        // $("#buzzerStatus").html(data.status);
        // }
        // }
    });
}

function angleLeftSetInterval() {
    if (cameraAngleLeftInterval == null) {
    	cameraAngleLeftInterval = setInterval("angleLeft()", 10);
    }
}

function angleLeft() {
	if(leftRightAngle < 170)
        leftRightAngle += 1;
    var json = {
        "command": "camera",
        "value1": leftRightAngle,
        "value2": upDownAngle
    };
    $.ajax({
        url: "http://" + location.host +
            "/FinalWebProject/actuator/camera",
        data: json,
        method: "post",

        // success : function(data) {
        // if (data.result == "success") {
        // $("#buzzerStatus").html(data.status);
        // }
        // }
    });
}

function angleRightSetInterval() {
    if (cameraAngleRightInterval == null) {
    	cameraAngleRightInterval = setInterval("angleRight()", 10);
    }
}

function angleRight() {
	if(leftRightAngle > 10)
		leftRightAngle -= 1;
    var json = {
        "command": "camera",
        "value1": leftRightAngle,
        "value2": upDownAngle
    };
    $.ajax({
        url: "http://" + location.host +
            "/FinalWebProject/actuator/camera",
        data: json,
        method: "post",

        // success : function(data) {
        // if (data.result == "success") {
        // $("#buzzerStatus").html(data.status);
        // }
        // }
    });
}





function onKeyUp_Event(event) {
    upKey = event.keyCode;

    if (upKey == 104) {
        clearInterval(speedUpInterval);
        speedUpInterval = null;
    } else if (upKey == 98) {
        clearInterval(speedDownInterval);
        speedDownInterval = null;
    } else if (upKey == 105) {
        clearInterval(speedStopInterval);
        speedStopInterval = null;
    } else if (upKey == 100) {
        clearInterval(turnLeftInterval);
        turnLeftInterval = null;
    } else if (upKey == 101) {
        clearInterval(turnCenterInterval);
        turnCenterInterval = null;
    } else if (upKey == 102) {
        clearInterval(turnRightInterval);
        turnRightInterval = null;
    }
    
    else if (upKey == 87) {
        clearInterval(cameraAngleUpInterval);
        cameraAngleUpInterval = null;
    } else if (upKey == 88) {
        clearInterval(cameraAngleDownInterval);
        cameraAngleDownInterval = null;
    } else if (upKey == 83) {
        clearInterval(cameraAngleCenterInterval);
        cameraAngleCenterInterval = null;
    } else if (upKey == 65) {
        clearInterval(cameraAngleLeftInterval);
        cameraAngleLeftInterval = null;
    } else if (upKey == 68) {
        clearInterval(cameraAngleRightInterval);
        cameraAngleRightInterval = null;
    }

}