var num1=2;
var num2=2;
var num3=2;

function changeimg(prjNum) {
	if(prjNum==1){
		var imgName = "project1-" + num1 +".jpg";
		
		var img1 = document.getElementById("img1");
		img1.src="resources/images/project/" + imgName;
		num1++;
		if(num1==7){
			num1=1;
		}
	}
	else if(prjNum==2){
		var imgName = "project2-" + num2 +".jpg";
		var img2 = document.getElementById("img2");
		img2.src="resources/images/project/" + imgName;
		num2++;
		if(num2==7){
			num2=1;
		}
		
	}
	else if(prjNum==3){
		var imgName = "project3-" + num3 +".jpg";
		var img3 = document.getElementById("img3");
		img3.src="resources/images/project/" + imgName;
		num3++;
		if(num3==7){
			num3=1;
		}
	}
}