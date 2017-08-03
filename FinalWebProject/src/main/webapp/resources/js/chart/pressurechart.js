var pressureChart;
$(function() {
	pressureChart = new Highcharts.Chart({
		chart: {
			renderTo:"pressureChartContainer",
			type:"spline",
			events: {
				load: requestPressureData
			}
		},
		colors: ['#434348'],
		title: {
			text: "Pressure"
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
			name: "기압",
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

function requestPressureData() {
	var ws = new WebSocket("ws://" + location.host + "/FinalWebProject/websocket/pressure");
	ws.onmessage = function(event) {
		var data = JSON.parse(event.data);
		var series = pressureChart.series[0];
		var shift = series.data.length > 20;
		series.addPoint([data.time, data.pressure], true, shift);
	};
}






