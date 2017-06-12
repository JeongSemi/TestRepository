<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
        <title>PhotoBoard</title>
        <link href="<%=application.getContextPath()%>/resources/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet">
        <script src="<%=application.getContextPath()%>/resources/jquery/jquery-3.2.1.min.js" type="text/javascript"></script>
        <script src="<%=application.getContextPath()%>/resources/bootstrap-3.3.7/js/bootstrap.min.js" type="text/javascript"></script>
        <script type="text/javascript">
        function handleBtnUpdate(bnum){
    		var bpassword = $("#bpassword").val();
    		if(bpassword == ""){
    			$("#bpassword").attr("placeholder" , "비밀번호를 입력하셔야 합니다.");
    			$("#bpassword").css("border-color","red");
    			return;
    		}
    		$.ajax({
    			url: "checkBpassword",
    			method: "post",
    			//data: "bno=${board.bno}&bpassword="+bpassword
    			data: {"bno":bnum, "bpassword":bpassword},
    			success: function(data){
    				if(data.result == "success"){
    					location.href="update?bno="+bnum;
    				} else{
    					$("#bpassword").val("");
    					$("#bpassword").attr("placeholder" , "비밀번호가 다릅니다.");
            			$("#bpassword").css("border-color","red");
    				}
    			}
    		})
    	}
        	    	
        	function handleBtnDelete(bnum){
        		var bpassword = $("#bpassword").val();
        		if(bpassword == ""){
        			$("#bpassword").attr("placeholder" , "비밀번호를 입력하셔야 합니다.");
        			$("#bpassword").css("border-color","red");
        			return;
        		}
        		$.ajax({
        			url: "checkBpassword",
        			method: "post",
        			data: {"bno":bnum, "bpassword":bpassword},
        			success: function(data){
        				if(data.result == "success"){
        					location.href="delete?bno="+bnum;
        				} else{
        					$("#bpassword").val("");
        					$("#bpassword").attr("placeholder" , "비밀번호가 다릅니다.");
                			$("#bpassword").css("border-color","red");
        				}
        			}
        		})
        	}
        	$('.modal').on('hidden.bs.modal', function () {
                $(this).removeData('bs.modal');
                });
        </script>
    </head>
<body>
	<div align="center" style="padding:10px; font-weight:bold; font-size:30px">
		PhotoBoard
	</div>
	<hr/>
	<div align="right">
		<a href="write" class="btn btn-default" style="margin:5px 30px">Upload</a>
	</div>
        <c:forEach var="b" items="${list}">
        	<div style="position:relative; border:solid 1px #BDBDBD; width:751px; margin: 30px auto;" >
        	
        	<div style="font-weight:bold; font-size:18px; width:750px; height:55px; padding:15px;">
            	<span class="glyphicon glyphicon-user" style="width:10px; height:10px;"></span>&nbsp; ${b.bwriter }</div> 
        	<div><img src="file?bno=${b.bno }" width="750px"/></div>
        	<div style="margin:10px;">
        		<a type="button" class="btn btn-default" href="hit?bno=${b.bno }">
        			<span class="glyphicon glyphicon-heart-empty"></span>
        		</a>
        		<!-- 수정 modal 띄우기 -->
        		<button type="button" class="btn btn-default" data-target="#layerpop1" data-toggle="modal">
        			<span class="glyphicon glyphicon-pencil"></span>
        		</button>
        		<div class="modal fade" id="layerpop1" >
				  <div class="modal-dialog">
				    <div class="modal-content">
				      <!-- header -->
				      <div class="modal-header">
				        <!-- 닫기(x) 버튼 -->
				        <button type="button" class="close" data-dismiss="modal">×</button>
				        <!-- header title -->
				        <h4 class="modal-title">수정을 위해 비밀번호를 입력하세요.</h4>
				      </div>
				      <!-- body -->
				      <div class="modal-body">
				            <div class="form-group">
				                <div class="input-group">
				                    <span class="input-group-addon">
				                        <span class="glyphicon glyphicon-lock"></span>
				                    </span>
				                    <input id="bpassword" type="password" class="form-control" placeholder="비밀번호" name="bpassword" />
				                </div>
				            </div>
				      </div>
				        <input type="button" class="btn btn-default" onclick="handleBtnUpdate(${b.bno})" value="입력"/>
				        <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
				      </div>
				    </div>
				  </div>
				<!-- 삭제 modal -->
        		<button type="button" class="btn btn-default" data-target="#layerpop2" data-toggle="modal">
        			<span class="glyphicon glyphicon-remove"></span>
        		</button>
        		<div class="modal fade" id="layerpop2" >
				  <div class="modal-dialog">
				    <div class="modal-content">
				      <!-- header -->
				      <div class="modal-header">
				        <!-- 닫기(x) 버튼 -->
				        <button type="button" class="close" data-dismiss="modal">×</button>
				        <!-- header title -->
				        <h4 class="modal-title">삭제를 위해 비밀번호를 입력하세요.</h4>
				      </div>
				      <!-- body -->
				      <div class="modal-body">
				            <div class="form-group">
				                <div class="input-group">
				                    <span class="input-group-addon">
				                        <span class="glyphicon glyphicon-lock"></span>
				                    </span>
				                    <input id="bpassword" type="password" class="form-control" placeholder="비밀번호" name="bpassword" />
				                </div>
				            </div>
				      </div>
				        <input type="button" class="btn btn-default" onclick="handleBtnDelete(${b.bno})" value="입력"/>
				        <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
				      </div>
				    </div>
				  </div>
        	<div style="font-weight:bold; font-size: 15px; padding:0px 0px 5px 10px; margin:10px 0px 0px 0px">hit ${b.bhitcount }</div>
        	<div style="font-weight:bold; font-size: 15px; padding:0px 0px 5px 10px">${b.btitle }</div>
        	<div style="padding:0px 0px 5px 10px">${b.bcontent }</div>
        	<div style="font-size:10px; color: #8C8C8C; padding:0px 0px 0px 10px">${b.bdate }</div>
        	</div>
        	</div>
        </c:forEach>
	<div align="right">
		<a href="write" class="btn btn-default" style="margin:5px 30px">Upload</a>
	</div>
</body>
</html>