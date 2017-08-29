 $(function(){
  	  $('#joinmpassword').keyup(function(){
 	   		$('#checkpwd').text('');
  	  });
  	  $('#mpasswordcheck').keyup(function(){
  	   if($('#joinmpassword').val()!=$('#mpasswordcheck').val()){
      	    $('#checkpwd').text('비밀번호가 일치하지 않습니다.');
      	    $('#checkpwd').css("color","#FF3636");
      	    $('#checkpwddiv').attr("class", "form-group has-error has-feedback");
  	   }else{
      	    $('#checkpwd').text('비밀번호 일치!');
      	    $('#checkpwd').css("color","#0054FF");
      	    $('#checkpwddiv').attr("class", "form-group");
  	   }
     	 });
 	});
  function checkMid(){
  	var mid = $('#joinmid').val();
  	if(mid == ''){
  		$('#joinmid').attr("placeholder", "아이디를 입력하세요");
  		$('#checkmiddiv').attr("class", "form-group has-error has-feedback");
  	}
  	else{
  		$.ajax({
  			url: "checkMid",
  			method: "post",
  			data: {"mid": mid },
  			success: function(data){
  				if(data.result == "fail"){
  					$('#checkmid').text("이미 존재하는 아이디입니다.");
          			$('#checkmid').css("color","#FF3636");
          			$('#checkmiddiv').attr("class", "form-group has-error has-feedback");
  				}
  				else{
  					$('#checkmid').text("사용가능한 아이디입니다.");
  					$('#checkmid').css("color","#0054FF");
  					$('#checkmiddiv').attr("class", "form-group");
  				}
  			}
  		})
  	}
  	
  }

  function checkJoin(){
  	if($('#checkpwd').text() == '비밀번호가 일치하지 않습니다.'){
  		alert('비밀번호를 확인하세요');
  		return false;
  	}
  	if($('#checkmid').text() == '이미 존재하는 아이디입니다.'){
  		alert('아이디를 확인하세요');
  		return false;
  	}
  	if($('#joinmid').val() == ''){
  		alert('아이디는 필수 입력항목입니다');
  		return false;
  	}
  	else if($('#mpassword').val() == ''){
  		alert('비밀번호는 필수 입력항목입니다');
  		return false;
  	}
  	else if($('#mpasswordcheck').val() == ''){
  		alert('비밀번호를 확인하세요');
  		return false;
  	}
  	else if($('#mname').val() == ''){
  		alert('이름은 필수 입력항목입니다');
  		return false;
  	}
  	else if($('#male').prop("checked", false) && $('#female').prop("checked", false)){
  		alert('성별은 필수 입력항목입니다');
  		return false;
  	}

      }