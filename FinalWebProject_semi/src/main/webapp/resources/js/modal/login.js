function checklogin(){
	if($('#loginmid').val() == ''){
  		alert('아이디를 입력하세요');
  		return false;
  	}
  	else if($('#loginmpassword').val() == ''){
  		alert('비밀번호를 입력하세요');
  		return false;
  	}
}



