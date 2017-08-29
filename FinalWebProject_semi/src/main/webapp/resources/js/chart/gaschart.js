var gasChart;
$(function() {
	gasChart = new Highcharts.Chart({
		chart: {
			renderTo:"gasChartContainer",
			type:"spline",
			events: {
				load: requestGasData
			}
		},
		colors: ['#f7a35c'],
		title: {
			text: "Gas"
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
			name: "가스",
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

function requestGasData() {
	var ws = new WebSocket("ws://" + location.host + "/FinalWebProject/websocket/gas");
	ws.onmessage = function(event) {
		
		var data = JSON.parse(event.data);
		var series = gasChart.series[0];
		var shift = series.data.length > 20;
		series.addPoint([data.time, data.gas], true, shift);
	};
}






