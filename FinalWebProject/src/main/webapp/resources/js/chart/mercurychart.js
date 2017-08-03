var mercuryChart;
$(function() {
	mercuryChart = new Highcharts.Chart({
		chart: {
			renderTo:"mercuryChartContainer",
			type:"spline",
			events: {
				load: requestMercuryData
			}
		},
		colors: ['#4572A7'],
		title: {
			text: "Mercury"
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
			name: "기울기",
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

function requestMercuryData() {
	var ws = new WebSocket("ws://" + location.host + "/FinalWebProject/websocket/mercury");
	ws.onmessage = function(event) {
		var data = JSON.parse(event.data);
		var series = mercuryChart.series[0];
		var shift = series.data.length > 20;
		series.addPoint([data.time, data.mercury], true, shift);
	};
}






