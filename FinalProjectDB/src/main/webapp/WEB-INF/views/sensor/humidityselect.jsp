<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
        <title>Humidity</title>
        <link href="<%=application.getContextPath()%>/resources/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet">
        <script src="<%=application.getContextPath()%>/resources/jquery/jquery-3.2.1.min.js" type="text/javascript"></script>
        <script src="<%=application.getContextPath()%>/resources/bootstrap-3.3.7/js/bootstrap.min.js" type="text/javascript"></script>
        
    </head>
<body>
	
	<h3>Humidity Select</h3>
	<hr/>
	<table class="table table-bordered" style="width: 700px">
            <tr class="success">
                <td>번호</td>
                <td>시간</td>
                <td>습도</td>
            </tr>
            <c:forEach var="h" items="${list}"> 
                <tr>
                    <td>${h.hno}</td>
                    <td>${h.htime}</td>
                    <td>${h.humidity}</td>
                </tr>
            </c:forEach>
        </table>
	
</body>
</html>