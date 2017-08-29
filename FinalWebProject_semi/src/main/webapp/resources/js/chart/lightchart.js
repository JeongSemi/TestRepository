var lightChart;
var statusLight;

$(function() {
	lightChart = new Highcharts.Chart({
		chart: {
			renderTo:"lightChartContainer",
			type:"spline",
			events: {
				load: requestLightData
			}
		},
		colors: ['#f15c80'],
		title: {
			text: "Light"
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
			name: "조명",
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

function requestLightData() {
	var ws = new WebSocket("ws://" + location.host + "/FinalWebProject/websocket/light");
	ws.onmessage = function(event) {
		var data = JSON.parse(event.data);
		
		if(data.light == "on") {
			statusLight = 1;
		} else if(data.light == "off") {
			statusLight = 0;
		}
		
		var series = lightChart.series[0];
		var shift = series.data.length > 20;
		series.addPoint([data.time, statusLight], true, shift);
	};
}






