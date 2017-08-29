var eventData;
var realTimeBuzzerStatus;
var buzzerStatus;

var ws = new WebSocket("ws://" + location.host + "/FinalWebProject/websocket/buzzer");
ws.onmessage = function(event) {
    eventData = JSON.parse(event.data);

    $.ajax({
        url: "http://" + location.host + "/FinalWebProject/status/buzzer",
        data: eventData,
        method: "post",
        success: function(data) {
            // console.log(buzzerStatus);
            realTimeBuzzerStatus = data.buzzer;
            //            console.log("buzzerStatus -------------" + buzzerStatus);
            //            console.log("realTimeBuzzerStatus -------------" + realTimeBuzzerStatus);

            if (buzzerStatus == realTimeBuzzerStatus) {
                if (realTimeBuzzerStatus == "on") {
                    $("#currBuzzerImage").attr('src', '/FinalWebProject/resources/images/actuators/buzzer_highlight.png');
                } else if (realTimeBuzzerStatus == "off") {
                    $("#currBuzzerImage").attr('src', '/FinalWebProject/resources/images/actuators/buzzer.png');
                }
            }
            buzzerStatus = realTimeBuzzerStatus;
        }
    });
};

function buzzer(command, value) {
    var json = {
        "command": command,
        "value": value
    };
    $.ajax({
        url: "http://" + location.host + "/FinalWebProject/actuator/buzzer",
        data: json,
        method: "post",
        success: function(data) {
            buzzerStatus = data.buzzer;
            //            console.log("buzzerStatus -------------" + buzzerStatus);
            //            console.log("realTimeBuzzerStatus -------------" + realTimeBuzzerStatus);
            if (buzzerStatus == "on") {
                $("#currBuzzerImage").attr('src', '/FinalWebProject/resources/images/actuators/buzzer_highlight.png');
            } else if (buzzerStatus == "off") {
                $("#currBuzzerImage").attr('src', '/FinalWebProject/resources/images/actuators/buzzer.png');
            }

        }
    });
}