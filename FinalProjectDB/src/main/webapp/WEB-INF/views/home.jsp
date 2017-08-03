<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
        <title>Home</title>
        <link href="<%=application.getContextPath()%>/resources/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet">
        <script src="<%=application.getContextPath()%>/resources/jquery/jquery-3.2.1.min.js" type="text/javascript"></script> 
        <script src="<%=application.getContextPath()%>/resources/bootstrap-3.3.7/js/bootstrap.min.js" type="text/javascript"></script>
    </head>

    <body>
        WebApplication Home
        <hr/>
   		
   		<h4>센서 데이터값 저장</h4>
   		<a href="sensor/temperature" class="btn btn-danger">온도</a>
   		<a href="sensor/gas" class="btn btn-warning">가스</a>
   		<a href="sensor/humidity" class="btn btn-success">습도</a>
   		<a href="sensor/humidityselect" class="btn btn-success">습도 분 데이터</a>
   		<a href="sensor/raindrop" class="btn btn-primary">빗물감지</a>
   		<a href="sensor/pressure" class="btn btn-default">기압</a>
   		<a href="sensor/photoresistor" class="btn btn-danger">조도</a>
   		<a href="sensor/mercury" class="btn btn-warning">기울기</a>
   		<a href="sensor/touch" class="btn btn-success">터치</a>
   		
    </body>
</html>