var eventData;
var realTimeLaserStatus;
var laserStatus;

var ws = new WebSocket("ws://" + location.host + "/FinalWebProject/websocket/laser");
ws.onmessage = function(event) {
    eventData = JSON.parse(event.data);

    $.ajax({
        url: "http://" + location.host + "/FinalWebProject/status/laser",
        data: eventData,
        method: "post",
        success: function(data) {
            realTimeLaserStatus = data.laser;
            //console.log("laserStatus -------------" + laserStatus);
            //console.log("realTimeLaserStatus -------------" + realTimeLaserStatus);
            if (laserStatus == realTimeLaserStatus) {
                if (realTimeLaserStatus == "on") {
                    $("#currLaserImage").attr('src', '/FinalWebProject/resources/images/actuators/laser_highlight.png');
                } else if (realTimeLaserStatus == "off") {
                    $("#currLaserImage").attr('src', '/FinalWebProject/resources/images/actuators/laser.png');
                }
            }
            laserStatus = realTimeLaserStatus;
        }
    });
};


function laseremitter(command, value) {
    var json = {
        "command": command,
        "value": value
    };
    $.ajax({
        url: "http://" + location.host + "/FinalWebProject/actuator/laseremitter",
        data: json,
        method: "post",
        success: function(data) {
            laserStatus = data.laser;
            //console.log(data.laser);
            //console.log("laserStatus -------------" + laserStatus);
            //console.log("realTimeLaserStatus -------------" + realTimeLaserStatus);
            if (laserStatus == "on") {
                $("#currLaserImage").attr('src', '/FinalWebProject/resources/images/actuators/laser_highlight.png');
            } else if (laserStatus == "off") {
                $("#currLaserImage").attr('src', '/FinalWebProject/resources/images/actuators/laser.png');
            }
        }
    });
}