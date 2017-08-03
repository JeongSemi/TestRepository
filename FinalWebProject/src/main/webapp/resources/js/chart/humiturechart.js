var humitureChart;
$(function() {
	humitureChart = new Highcharts.Chart({
		chart: {
			renderTo:"humitureChartContainer",
			type:"spline",
			events: {
				load: requestHumitureData
			}
		},
		colors: ['#8085e9'],
		title: {
			text: "Humiture"
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
			name: "습도",
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

function requestHumitureData() {
	var ws = new WebSocket("ws://" + location.host + "/FinalWebProject/websocket/humidity");
	ws.onmessage = function(event) {
		var data = JSON.parse(event.data);
		var series = humitureChart.series[0];
		var shift = series.data.length > 20;
		series.addPoint([data.time, data.humiture], true, shift);
	};
}






