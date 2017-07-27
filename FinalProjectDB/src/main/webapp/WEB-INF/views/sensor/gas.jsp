<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
        <title>Gas</title>
        <link href="<%=application.getContextPath()%>/resources/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet">
        <script src="<%=application.getContextPath()%>/resources/jquery/jquery-3.2.1.min.js" type="text/javascript"></script>
        <script src="<%=application.getContextPath()%>/resources/bootstrap-3.3.7/js/bootstrap.min.js" type="text/javascript"></script>
        <script type="text/javascript">
        	function getData(){
        		var ws = new WebSocket("ws://" + location.host
    	    			+ "/FinalProjectDB/websocket/gas");
    	    	ws.onmessage = function(event) {
    	    		var data = JSON.parse(event.data);
	    	    	display("[가스] : " + data.value);
    	    	}
        	}
	        
	    	function display(message) {
        		$("#divDisplay").append("<span style='display:block;'>" + message + "</span>");
        		if($("#divDisplay span").length>40) {
        			$("#divDisplay span").first().remove();
        		}
        		$("#divDisplay").scrollTop($("#divDisplay").height());
        	}
        </script>
    </head>
<body onload="getData()">
	
	<h3>Gas</h3>
	<hr/>
	<div>
		<div id="divDisplay" style="width:800px; height:1000px; padding:5px; overflow-y:scroll; border:1px solid black; margin-top: 5px;"></div>
	</div>
	
</body>
</html>