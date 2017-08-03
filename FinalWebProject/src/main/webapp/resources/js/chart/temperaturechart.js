var temperatureChart;
$(function() {
	temperatureChart = new Highcharts.Chart({
		chart: {
			renderTo:"temperatureChartContainer",
			type:"spline",
			events: {
				load: requestTemperatureData
			}
		},
		colors: ['#A47D7C'],
		title: {
			text: "Temperature"
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
			name: "온도",
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

function requestTemperatureData() {
	var ws = new WebSocket("ws://" + location.host + "/FinalWebProject/websocket/temperature");
	ws.onmessage = function(event) {
		var data = JSON.parse(event.data);
		var series = temperatureChart.series[0];
		var shift = series.data.length > 20;
		series.addPoint([data.time, data.temperature], true, shift);
	};
}






