var eventData;
var realTimeLightStatus;
var lightStatus;

var ws = new WebSocket("ws://" + location.host + "/FinalWebProject/websocket/light");
ws.onmessage = function(event) {
    eventData = JSON.parse(event.data);
    
    $.ajax({
        url: "http://" + location.host + "/FinalWebProject/status/light",
        data: eventData,
        method: "post",
        success: function(data) {
            realTimeLightStatus = data.light;
            if (lightStatus == realTimeLightStatus) {
                if (realTimeLightStatus == "on") {
                    $("#currLightImage").attr('src', '/FinalWebProject/resources/images/actuators/light_highlight.png');
                } else if (realTimeLightStatus == "off") {
                    $("#currLightImage").attr('src', '/FinalWebProject/resources/images/actuators/light.png');
                }
            }
            lightStatus = realTimeLightStatus;
        }
    });
};

function light(command, value) {
    var json = {
        "command": command,
        "value": value
    };
    $.ajax({
        url: "http://" + location.host + "/FinalWebProject/actuator/light",
        data: json,
        method: "post",
        success: function(data) {
        	lightStatus = data.light;
            if (lightStatus == "on") {
                $("#currLightImage").attr('src', '/FinalWebProject/resources/images/actuators/light_highlight.png');
            } else if (lightStatus == "off") {
                $("#currLightImage").attr('src', '/FinalWebProject/resources/images/actuators/light.png');
            }

        }
    });
}