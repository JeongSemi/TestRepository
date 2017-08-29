var sideUltrasonicChart;
$(function() {
	sideUltrasonicChart = new Highcharts.Chart({
		chart: {
			renderTo:"sideUltrasonicChartContainer",
			type:"spline",
			events: {
				load: requestSideUltrasonicData
			}
		},
		colors: ['#AA4643'],
		title: {
			text: "Ultrasonic(Side)"
		},
		xAxis: {
			type: "datetime",
			tickPixelInterval: 100,
			minRange: 20*1000
		},
		yAxis: {
			title: {
				text: "",
				margin: 30
			}
		},
		series: [{
			name: "거리",
			data: []
		}],
		//마커(점)이 없어지는 현상 방지
		plotOptions: {
	        series: {
	            marker: {
	                enabled: true
	            }
	        }
	    }
	});
});

function requestSideUltrasonicData() {
	/*var ws = new WebSocket("ws://" + location.host + "/FinalWebProject/websocket/sideultrasonic");
	ws.onmessage = function(event) {
		var data = JSON.parse(event.data);
		var series = sideUltrasonicChart.series[0];
		var shift = series.data.length > 20;	
		
		series.addPoint([data.time, data.distance], true, shift);		
		
		//특정 범위의 값일 경우 점의 색상을 변경
		var length = series.points.length;
		if(data.distance < 10) {
			series.points[length-1].color = "red";
		} else {
			series.points[length-1].color = "white";
		}		
	};*/
}







