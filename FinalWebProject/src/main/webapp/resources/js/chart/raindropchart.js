var raindropChart;
$(function() {
	raindropChart = new Highcharts.Chart({
		chart: {
			renderTo:"raindropChartContainer",
			type:"spline",
			events: {
				load: requestRaindropData
			}
		},
		colors: ['#f45b5b'],
		title: {
			text: "Raindrop"
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
			name: "빗방울",
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

function requestRaindropData() {
	var ws = new WebSocket("ws://" + location.host + "/FinalWebProject/websocket/raindrop");
	ws.onmessage = function(event) {
		var data = JSON.parse(event.data);
		var series = raindropChart.series[0];
		var shift = series.data.length > 20;
		series.addPoint([data.time, data.raindrop], true, shift);
	};
}






