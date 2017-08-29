var photoresistorChart;
$(function() {
	photoresistorChart = new Highcharts.Chart({
		chart: {
			renderTo:"photoresistorChartContainer",
			type:"spline",
			events: {
				load: requestPhotoresistorData
			}
		},
		colors: ['#2b908f'],
		title: {
			text: "Photoresistor"
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
			name: "조도",
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

function requestPhotoresistorData() {
	var ws = new WebSocket("ws://" + location.host + "/FinalWebProject/websocket/photoresistor");
	ws.onmessage = function(event) {
		var data = JSON.parse(event.data);
		var series = photoresistorChart.series[0];
		var shift = series.data.length > 20;
		series.addPoint([data.time, data.photoresistor], true, shift);
	};
}






