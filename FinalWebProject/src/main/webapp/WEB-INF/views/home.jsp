<%@page contentType="text/html; charset=UTF-8"%>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
        <title>RC RoBo</title>

		<!-- jQuery, Bootstrap -->
        <script src="<%=application.getContextPath()%>/resources/assets/lib/jquery/dist/jquery.js"></script>
        <script src="<%=application.getContextPath()%>/resources/assets/lib/bootstrap/dist/js/bootstrap.min.js"></script>

		<!-- KeyEvent -->
        <script src="<%=application.getContextPath()%>/resources/js/keyevent/keyevent.js"></script>
        
        <!--  
    Favicons
    =============================================
    -->
        <link rel="apple-touch-icon" sizes="57x57" href="<%=application.getContextPath()%>/resources/assets/images/favicons/apple-icon-57x57.png">
        <link rel="apple-touch-icon" sizes="60x60" href="<%=application.getContextPath()%>/resources/assets/images/favicons/apple-icon-60x60.png">
        <link rel="apple-touch-icon" sizes="72x72" href="<%=application.getContextPath()%>/resources/assets/images/favicons/apple-icon-72x72.png">
        <link rel="apple-touch-icon" sizes="76x76" href="<%=application.getContextPath()%>/resources/assets/images/favicons/apple-icon-76x76.png">
        <link rel="apple-touch-icon" sizes="114x114" href="<%=application.getContextPath()%>/resources/assets/images/favicons/apple-icon-114x114.png">
        <link rel="apple-touch-icon" sizes="120x120" href="<%=application.getContextPath()%>/resources/assets/images/favicons/apple-icon-120x120.png">
        <link rel="apple-touch-icon" sizes="144x144" href="<%=application.getContextPath()%>/resources/assets/images/favicons/apple-icon-144x144.png">
        <link rel="apple-touch-icon" sizes="152x152" href="<%=application.getContextPath()%>/resources/assets/images/favicons/apple-icon-152x152.png">
        <link rel="apple-touch-icon" sizes="180x180" href="<%=application.getContextPath()%>/resources/assets/images/favicons/apple-icon-180x180.png">
        <link rel="icon" type="image/png" sizes="192x192" href="<%=application.getContextPath()%>/resources/assets/images/favicons/android-icon-192x192.png">
        <link rel="icon" type="image/png" sizes="32x32" href="<%=application.getContextPath()%>/resources/assets/images/favicons/favicon-32x32.png">
        <link rel="icon" type="image/png" sizes="96x96" href="<%=application.getContextPath()%>/resources/assets/images/favicons/favicon-96x96.png">
        <link rel="icon" type="image/png" sizes="16x16" href="<%=application.getContextPath()%>/resources/assets/images/favicons/favicon-16x16.png">
        <link rel="manifest" href="/manifest.json">
        <meta name="msapplication-TileColor" content="#ffffff">
        <meta name="msapplication-TileImage" content="<%=application.getContextPath()%>/resources/assets/images/favicons/ms-icon-144x144.png">
        <meta name="theme-color" content="#ffffff">
        <!--  
    Stylesheets
    =============================================
    -->
        <!-- Default stylesheets-->
        <link href="<%=application.getContextPath()%>/resources/assets/lib/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
        <!-- Template specific stylesheets-->
        <link href="https://fonts.googleapis.com/css?family=Roboto+Condensed:400,700" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Volkhov:400i" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800" rel="stylesheet">
        <link href="<%=application.getContextPath()%>/resources/assets/lib/animate.css/animate.css" rel="stylesheet">
        <link href="<%=application.getContextPath()%>/resources/assets/lib/components-font-awesome/css/font-awesome.min.css" rel="stylesheet">
        <link href="<%=application.getContextPath()%>/resources/assets/lib/et-line-font/et-line-font.css" rel="stylesheet">
        <link href="<%=application.getContextPath()%>/resources/assets/lib/flexslider/flexslider.css" rel="stylesheet">
        <link href="<%=application.getContextPath()%>/resources/assets/lib/owl.carousel/dist/assets/owl.carousel.min.css" rel="stylesheet">
        <link href="<%=application.getContextPath()%>/resources/assets/lib/owl.carousel/dist/assets/owl.theme.default.min.css" rel="stylesheet">
        <link href="<%=application.getContextPath()%>/resources/assets/lib/magnific-popup/dist/magnific-popup.css" rel="stylesheet">
        <link href="<%=application.getContextPath()%>/resources/assets/lib/simple-text-rotator/simpletextrotator.css" rel="stylesheet">
        <!-- Main stylesheet and color file-->
        <link href="<%=application.getContextPath()%>/resources/assets/css/style.css" rel="stylesheet">
        <link id="color-scheme" href="<%=application.getContextPath()%>/resources/assets/css/colors/default.css" rel="stylesheet">
        
        <!-- Modal -->
        <script type="text/javascript">
            $('#loginModal').modal('show');
            $('#joinModal').modal('show');
            function joinAlert(){
	            alert('가입이 완료되었습니다. 다시 로그인해주세요.');
            }
            //비밀번호 체크
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
        </script>

    </head>

    <body data-spy="scroll" data-target=".onpage-navigation" data-offset="60" onkeydown="onKeyDown_Event(event)" onkeyup="onKeyUp_Event(event)">
        <main>
            <div class="page-loader">
                <div class="loader">Loading...</div>
            </div>
            <nav class="navbar navbar-custom navbar-transparent navbar-fixed-top one-page" role="navigation">
                <div class="container">
                    <div class="navbar-header">
                        <button class="navbar-toggle" type="button" data-toggle="collapse" data-target="#custom-collapse"><span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button><a class="navbar-brand" href="index.html">RC RoBo</a>
                    </div>
                    <div class="collapse navbar-collapse" id="custom-collapse">
                        <ul class="nav navbar-nav navbar-right">
                            <li><a href="#totop">Home</a></li>
                            <li><a class="section-scroll" href="#services">Intro</a></li>
                            <li><a class="section-scroll" href="#works">Charts</a></li>
                            <li><a class="section-scroll" href="#pricing">Database</a></li>
                            <li><a class="section-scroll" href="#alt-features">Actuators</a></li>
                            <li><a class="section-scroll" href="#team">Team</a></li>

                            <li><a class="section-scroll" href="#news">News</a></li>
                            <li><a class="section-scroll" href="#contact">Contact</a></li>
                        </ul>
                    </div>
                </div>
            </nav>
            <section class="home-section home-full-height bg-dark bg-gradient" id="home" data-background="<%=application.getContextPath()%>/resources/images/rcmain_transparent.jpg">
                <div class="titan-caption">
                    <div class="caption-content">
                        <div class="font-alt mb-30 titan-title-size-1">IoT &amp; Team3</div>
                        <div class="font-alt mb-40 titan-title-size-4">RC Robo</div>
                        <button type="button" class="section-scroll btn btn-border-w btn-round" data-toggle="modal" data-target="#loginModal">Login</button>
                        <button type="button" class="section-scroll btn btn-border-w btn-round" data-toggle="modal" data-target="#joinModal">Join</button>
                    </div>
                </div>
            </section>
            <div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title" id="myModalLabel">Login</h4>
                        </div>
                        <div class="modal-body">
                            <form method="post" action="">
                                <div class="form-group">
                                    <label for="mid">아이디</label>
                                    <input type="text" class="form-control" id="loginmid" placeholder="아이디" name="mid">
                                </div>
                                <div class="form-group">
                                    <label for="mpassword">비밀번호</label>
                                    <input type="password" class="form-control" id="loginmpassword" placeholder="비밀번호" name="mpassword">
                                </div>
                                <div align="right">
    	                            <button type="submit" class="btn btn-warning">로그인</button>
		                            <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
                                </div>
                           </form>
                        </div>
                    </div>
                </div>
            </div>
			<!-- 회원가입 모달 -->
            <div class="modal fade" id="joinModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title" id="myModalLabel">Join</h4>
                        </div>
                        <div class="modal-body">
                            <form method="post" action="http://localhost:8080/FinalWebProject/db/memberjoin">
                                <div class="form-group">
                                    <label for="mid">아이디</label>
                                    <input type="text" class="form-control" id="joinmid" placeholder="10자 이내로 입력하세요" name="mid">
                                </div>
                                <div class="form-group">
                                    <label for="mpassword">비밀번호</label>
                                    <input type="password" class="form-control" id="joinmpassword" placeholder="영문+숫자 조합 20자 이내" name="mpassword">
                                </div>
                                <div class="form-group" id="checkpwddiv" >
                                    <label for="mpasswordcheck">비밀번호 확인</label>
                                    <input type="password" class="form-control" id="mpasswordcheck" placeholder="비밀번호를 한 번 더 입력하세요">
                                </div>
                                <div id="checkpwd"></div>
                                
                                <div class="form-group">
                                    <label for="mname">이름</label>
                                    <input type="text" class="form-control" id="mname" placeholder="이름" name="mname">
                                </div>
                                <div>
                                	<label>성별&nbsp;&nbsp;&nbsp;</label>
								    <label class="radio-inline">
								      <input type="radio" name="msex" value="m">남
								    </label>
								    <label class="radio-inline">
								      <input type="radio" name="msex" value="f">여
								    </label>
								  </div>
                                <div class="form-group">
                                    <label for="mage">나이</label>
                                    <input type="number" class="form-control" id="mage" placeholder="나이" name="mage">
                                </div>
                                <div class="form-group">
                                    <label for="memail">E-mail</label>
                                    <input type="email" class="form-control" id="memail" placeholder="E-mail" name="memail">
                                </div>
                                <div class="form-group">
                                    <label for="mtel">전화번호</label>
                                    <input type="tel" class="form-control" id="mtel" placeholder="전화번호" name="mtel">
                                </div>
                                <div class="form-group">
                                    <label for="maddress">주소</label>
                                    <input type="text" class="form-control" id="maddress" placeholder="주소" name="maddress">
                                </div>
                                <div align="right">
	                            	<button type="submit" class="btn btn-success" onclick="joinAlert()">가입</button>
		                            <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <div class="main">




                <section class="module" id="services">
                    <div class="container">
                        <div class="row">
                            <div class="col-sm-6 col-sm-offset-3">
                                <h2 class="module-title font-alt">Final Project</h2>
                                <div class="module-subtitle font-serif">LTE망을 통한 RC카 제어 공용 라이브러리 제작<br/>▷주행제어 &nbsp;&nbsp;&nbsp;▷센서값측정 &nbsp;&nbsp;&nbsp;▷Actuator구동 &nbsp;&nbsp;&nbsp;▷자율주행</div>
                            </div>
                        </div>
                        <div class="row multi-columns-row">
                            <div class="col-md-3 col-sm-6 col-xs-12">
                                <div class="features-item">
                                    <img src="<%=application.getContextPath()%>/resources/images/intro/control.png" width="80px" height="80px" style="position:absoulte" />
                                    <h3 class="features-title font-alt">Driving Remote Control</h3>
                                    <p>LTE망을 통해서 RC카의 주행을 조종한다. 카메라를 통해 주행화면을 보면서 RC카의 모터부분을 제어하여 속도와 방향을 조종한다.</p>
                                </div>
                            </div>
                            <div class="col-md-3 col-sm-6 col-xs-12">
                                <div class="features-item">
                                    <img src="<%=application.getContextPath()%>/resources/images/intro/sensor.png" width="80px" height="80px" style="position:absoulte" />
                                    <h3 class="features-title font-alt">Sensors</h3>
                                    <p>RC카에 부착된 센서들로 부터 실시간으로 데이터를 받아온다. 받아온 데이터들을 웹을 통해 실시간으로 보여주고 다양한 통계값들을 제공한다.</p>
                                </div>
                            </div>
                            <div class="col-md-3 col-sm-6 col-xs-12">
                                <div class="features-item">
                                    <img src="<%=application.getContextPath()%>/resources/images/intro/actuator.png" width="80px" height="80px" style="position:absoulte" />
                                    <h3 class="features-title font-alt">Actuators</h3>
                                    <p>RC카에 부착된 Actuator들을 제어한다. 웹을 통해 실시간으로 제어하고 특정한 조건 내에서는 자동으로 동작하도록 설정해준다.</p>
                                </div>
                            </div>
                            <div class="col-md-3 col-sm-6 col-xs-12">
                                <div class="features-item">
                                    <img src="<%=application.getContextPath()%>/resources/images/intro/car.png" width="80px" height="80px" style="position:absoulte" />
                                    <h3 class="features-title font-alt">Self-Driving Car </h3>
                                    <p>LTE망과 GPS를 이용해서 RC카의 현재위치와 목표위치를 설정해준다. 장애물 회피 등 자율주행 기능을 프로그래밍하여 목표위치까지 자율주행하도록 한다.</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>

                <section class="module bg-dark-60" data-background="<%=application.getContextPath()%>/resources/images/rcmain_transparent.jpg">
                    <div class="container">
                        <div class="row">
                            <div class="col-sm-12">
                                <div class="video-box">
                                    <div class="video-box-icon"><a class="video-pop-up" href="https://www.youtube.com/watch?v=TTxZj3DZiIM"><span class="icon-video"></span></a></div>
                                    <div class="video-title font-alt">Presentation</div>
                                    <div class="video-subtitle font-alt">Watch the video about our new products</div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>


                <section class="module pb-0" id="works">
                    <div class="container">
                        <div class="row">
                            <div class="col-sm-6 col-sm-offset-3">
                                <h2 class="module-title font-alt">Sensor &amp; Chart</h2>
                                <div class="module-subtitle font-serif"></div>
                            </div>
                        </div>
                    </div>
                    <div class="container">
                        <div class="row">
                            <div class="col-sm-12">
                                <ul class="filter font-alt" id="filters">
                                    <li><a class="current wow fadeInUp" href="#" data-filter="*">All</a></li>
                                    <li><a class="wow fadeInUp" href="#" data-filter=".environment" data-wow-delay="0.2s">Environment</a></li>
                                    <li><a class="wow fadeInUp" href="#" data-filter=".driving" data-wow-delay="0.4s">Driving</a></li>
                                    <li><a class="wow fadeInUp" href="#" data-filter=".ultrasonic" data-wow-delay="0.6s">Ultrasonic</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <ul class="works-grid works-grid-gut works-grid-3 works-hover-w" id="works-grid">
                        <li class="work-item environment photography">
                            <a href="portfolio-single-1.html">
                                <div class="col-md-12">
                                    <div id="temperatureChartContainer"></div>
                                </div>
                                <div class="work-caption font-alt">
                                    <h3 class="work-title">Temperature</h3>
                                    <div class="work-descr">온도 측정 센서</div>
                                </div>
                            </a>
                        </li>
                        <li class="work-item environment photography">
                            <a href="portfolio-single-1.html">
                                <div class="col-md-12">
                                    <div id="pressureChartContainer"></div>
                                </div>
                                <div class="work-caption font-alt">
                                    <h3 class="work-title">Pressure</h3>
                                    <div class="work-descr">기압 측정 센서</div>
                                </div>
                            </a>
                        </li>
                        <li class="work-item environment photography">
                            <a href="portfolio-single-1.html">
                                <div class="col-md-12">
                                    <div id="humitureChartContainer"></div>
                                </div>
                                <div class="work-caption font-alt">
                                    <h3 class="work-title">Humiture</h3>
                                    <div class="work-descr">습도 측정 센서</div>
                                </div>
                            </a>
                        </li>
                        <li class="work-item environment webdesign">
                            <a href="portfolio-single-1.html">
                                <div class="col-md-12">
                                    <div id="raindropChartContainer"></div>
                                </div>
                                <div class="work-caption font-alt">
                                    <h3 class="work-title">Raindrop</h3>
                                    <div class="work-descr">물방울 감지 센서</div>
                                </div>
                            </a>
                        </li>
                        <li class="work-item environment webdesign">
                            <a href="portfolio-single-1.html">
                                <div class="col-md-12">
                                    <div id="gasChartContainer"></div>
                                </div>
                                <div class="work-caption font-alt">
                                    <h3 class="work-title">Gas</h3>
                                    <div class="work-descr">가스 감지 센서</div>
                                </div>
                            </a>
                        </li>
                        <li class="work-item environment webdesign">
                            <a href="portfolio-single-1.html">
                                <div class="col-md-12">
                                    <div id="photoresistorChartContainer"></div>
                                </div>
                                <div class="work-caption font-alt">
                                    <h3 class="work-title">Photoresistor</h3>
                                    <div class="work-descr">조도 감지 센서</div>
                                </div>
                            </a>
                        </li>
                        <li class="work-item driving webdesign">
                            <a href="portfolio-single-1.html">
                                <div class="col-md-12">
                                    <div id="mercuryChartContainer"></div>
                                </div>
                                <div class="work-caption font-alt">
                                    <h3 class="work-title">Mercury</h3>
                                    <div class="work-descr">기울기 측정 센서</div>
                                </div>
                            </a>
                        </li>
                        <li class="work-item driving webdesign">
                            <a href="portfolio-single-1.html">
                                <div class="col-md-12">
                                    <div id="lightChartContainer"></div>
                                </div>
                                <div class="work-caption font-alt">
                                    <h3 class="work-title">Light</h3>
                                    <div class="work-descr">RC카 조명</div>
                                </div>
                            </a>
                        </li>
                        <li class="work-item ultrasonic webdesign">
                            <a href="portfolio-single-1.html">
                                <div class="col-md-12">
                                    <div id="frontUltrasonicChartContainer"></div>
                                </div>
                                <div class="work-caption font-alt">
                                    <h3 class="work-title">Front Ultrasonics</h3>
                                    <div class="work-descr">거리 측정 센서</div>
                                </div>
                            </a>
                        </li>
                        <li class="work-item ultrasonic photography">
                            <a href="portfolio-single-1.html">
                                <div class="col-md-12">
                                    <div id="sideUltrasonicChartContainer"></div>
                                </div>
                                <div class="work-caption font-alt">
                                    <h3 class="work-title">Side Ultrasonics</h3>
                                    <div class="work-descr">거리 측정 센서</div>
                                </div>
                            </a>
                        </li>
                        <li class="work-item ultrasonic photography">
                            <a href="portfolio-single-1.html">
                                <div class="col-md-12">
                                    <div id="backUltrasonicChartContainer"></div>
                                </div>
                                <div class="work-caption font-alt">
                                    <h3 class="work-title">Back Ultrasonic</h3>
                                    <div class="work-descr">거리 측정 센서</div>
                                </div>
                            </a>
                        </li>
                    </ul>
                </section>




                <section class="module-small bg-dark">
                    <div class="container">
                        <div class="row">
                            <div class="col-sm-6 col-md-8 col-lg-6 col-lg-offset-2">
                                <div class="callout-text font-alt">
                                    <h3 class="callout-title">Want to see more works?</h3>
                                    <p>We are always open to interesting projects.</p>
                                </div>
                            </div>
                            <div class="col-sm-6 col-md-4 col-lg-2">
                                <div class="callout-btn-box"><a class="btn btn-w btn-round" href="portfolio_boxed_gutter_col_3.html">Lets view portfolio</a></div>
                            </div>
                        </div>
                    </div>
                </section>

                <section class="module" id="pricing">
                    <div class="container">
                        <div class="row">
                            <div class="col-sm-6 col-sm-offset-3">
                                <h2 class="module-title font-alt">Database</h2>
                                <div class="module-subtitle font-serif">RC카에 부착된 센서값들을 실시간으로 AWS의 DB에 저장하고 저장된 값들을 활용한 자료들</div>
                            </div>
                        </div>
                        <div class="row multi-columns-row">
                            <div class="col-sm-6 col-md-3 col-lg-3">
                                <div class="price-table font-alt">
                                    <h4>Temperature</h4>
                                    <img src="<%=application.getContextPath()%>/resources/images/database/temperature.png" width="60px" height="60px" style="position:absoulte" />
                                    <div class="borderline"></div>
                                    <p class="price">9<span></span>
                                    </p>
                                    <ul class="price-details">
                                        <li>평균 온도값</li>
                                    </ul><a class="btn btn-d btn-round" href="#">자세히보기</a>
                                </div>
                            </div>
                            <div class="col-sm-6 col-md-3 col-lg-3">
                                <div class="price-table font-alt">
                                    <h4>Humidity</h4>
                                    <img src="<%=application.getContextPath()%>/resources/images/database/humidity.png" width="60px" height="60px" style="position:absoulte" />
                                    <div class="borderline"></div>
                                    <p class="price"><span></span>29
                                    </p>
                                    <ul class="price-details">
                                        <li>평균 습도값</li>
                                    </ul><a class="btn btn-d btn-round" href="#">자세히보기</a>
                                </div>
                            </div>
                            <div class="col-sm-6 col-md-3 col-lg-3">
                                <div class="price-table font-alt">
                                    <h4>Gas</h4>
                                    <img src="<%=application.getContextPath()%>/resources/images/database/gas.png" width="60px" height="60px" style="position:absoulte" />
                                    <div class="borderline"></div>
                                    <p class="price"><span>$</span>64
                                    </p>
                                    <ul class="price-details">
                                        <li>평균 가스지수</li>
                                    </ul><a class="btn btn-d btn-round" href="#">자세히보기</a>
                                </div>
                            </div>
                            <div class="col-sm-6 col-md-3 col-lg-3">
                                <div class="price-table font-alt">
                                    <h4>Rainfall</h4>
                                    <img src="<%=application.getContextPath()%>/resources/images/database/rainfall.png" width="60px" height="60px" style="position:absoulte" />
                                    <div class="borderline"></div>
                                    <p class="price"><span>$</span>119
                                    </p>
                                    <ul class="price-details">
                                        <li>평균 강수량</li>
                                    </ul><a class="btn btn-d btn-round" href="#">자세히보기</a>
                                </div>
                            </div>
                        </div>
                        <div class="row mt-40">
                            <div class="col-sm-6 col-sm-offset-3 align-center">
                                <p>Everyone realizes why a new common language would be desirable: one could refuse to pay expensive translators. To achieve this, it would be necessary to have uniform grammar, pronunciation and more common words.</p>
                            </div>
                        </div>
                    </div>
                </section>

                <section class="module bg-dark-60" data-background="<%=application.getContextPath()%>/resources/assets/images/section-3.jpg">
                    <div class="container">
                        <div class="row">
                            <div class="col-sm-6 col-sm-offset-3">
                                <h2 class="module-title font-alt">Scoreboard</h2>
                                <div class="module-subtitle font-serif"></div>
                            </div>
                        </div>
                        <div class="row multi-columns-row">
                            <div class="col-sm-6 col-md-3 col-lg-3">
                                <div class="count-item mb-sm-40">
                                    <div class="count-icon"><span class="icon-wallet"></span></div>
                                    <h3 class="count-to font-alt" data-countto="6543"></h3>
                                    <h5 class="count-title font-serif">Dollars raised for charity</h5>
                                </div>
                            </div>
                            <div class="col-sm-6 col-md-3 col-lg-3">
                                <div class="count-item mb-sm-40">
                                    <div class="count-icon"><span class="icon-wine"></span></div>
                                    <h3 class="count-to font-alt" data-countto="8"></h3>
                                    <h5 class="count-title font-serif">Cups of wine consumed</h5>
                                </div>
                            </div>
                            <div class="col-sm-6 col-md-3 col-lg-3">
                                <div class="count-item mb-sm-40">
                                    <div class="count-icon"><span class="icon-camera"></span></div>
                                    <h3 class="count-to font-alt" data-countto="184"></h3>
                                    <h5 class="count-title font-serif">Photographs taken</h5>
                                </div>
                            </div>
                            <div class="col-sm-6 col-md-3 col-lg-3">
                                <div class="count-item mb-sm-40">
                                    <div class="count-icon"><span class="icon-map-pin"></span></div>
                                    <h3 class="count-to font-alt" data-countto="32"></h3>
                                    <h5 class="count-title font-serif">Locations covered</h5>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>


                <section class="module" id="alt-features">
                    <div class="container">
                        <div class="row">
                            <div class="col-sm-6 col-sm-offset-3">
                                <h2 class="module-title font-alt">Driving Control &amp; Actuators</h2>
                                <div class="module-subtitle font-serif">▷카메라 각도 제어 &nbsp;&nbsp;&nbsp;▷RC카 주행 제어 &nbsp;&nbsp;&nbsp;▷Actuators 제어</div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-6 col-md-3 col-lg-3">

                                <div class="alt-features-item">
                                    <div class="alt-features-icon"><img src="<%=application.getContextPath()%>/resources/images/actuators/drivingControl.png" width="60px" height="60px" style="position:absoulte" /></div>
                                    <h3 class="alt-features-title font-alt">Driving Control</h3>주행 조정키 설명 부분</br>
                                </div>

                                <div class="alt-features-item">
                                    <div class="alt-features-icon"><img src="<%=application.getContextPath()%>/resources/images/actuators/laser.png" width="60px" height="60px" style="position:absoulte" /></div>
                                    <h3 class="alt-features-title font-alt">Laser</h3>Laser ON-OFF 제어<br/><br/>
                                    <button type="button" class="btn btn-default" onclick="laseremitter('laseremitter', 'on')">ON</button>
                                    <button type="button" class="btn btn-default" onclick="laseremitter('laseremitter', 'off')">OFF</button>
                                </div>


                                <div class="alt-features-item">
                                    <div class="alt-features-icon"><img src="<%=application.getContextPath()%>/resources/images/actuators/buzzer.png" width="60px" height="60px" style="position:absoulte" /></div>
                                    <h3 class="alt-features-title font-alt">Buzzer</h3>Buzzer ON-OFF 제어<br/><br/>
                                    <button type="button" class="btn btn-default" onclick="buzzer('buzzer', 'on')">ON</button>
                                    <button type="button" class="btn btn-default" onclick="buzzer('buzzer', 'off')">OFF</button>
                                </div>


                                <div class="alt-features-item">
                                    <div class="alt-features-icon"><img src="<%=application.getContextPath()%>/resources/images/actuators/light.png" width="60px" height="60px" style="position:absoulte" /></div>
                                    <h3 class="alt-features-title font-alt">LED Light</h3>LED Light on-off 제어<br/><br/>
                                    <button type="button" class="btn btn-default" onclick="light('light', 'on')">ON</button>
                                    <button type="button" class="btn btn-default" onclick="light('light', 'off')">OFF</button>
                                </div>

                            </div>
                            <div class="col-md-6 col-lg-6 hidden-xs hidden-sm">
                                <div class="alt-services-image align-center">
                                <!-- <img src="http://192.168.3.81:50001?action=stream" style="width:500px; height:500px;" alt="Feature Image"> -->
                                </div>
                            </div>
                            <div class="col-sm-6 col-md-3 col-lg-3">


                                <div class="alt-features-item">
                                    <div class="alt-features-icon"><img src="<%=application.getContextPath()%>/resources/images/actuators/camera.png" width="60px" height="60px" style="position:absoulte" /></div>
                                    <h3 class="alt-features-title font-alt">Camera</h3>카메라 방향 및 각도 제어키 설명부분
                                </div>

                                <div class="alt-features-item">
                                    <div class="alt-features-icon"><img src="<%=application.getContextPath()%>/resources/images/actuators/rgbLed.png" width="60px" height="60px" style="position:absoulte" /></div>
                                    <h3 class="alt-features-title font-alt">RGB LED</h3>현재 색상 : <button type="button" class="btn btn-primary" id="rgbledStatus" style="background-color:rgb(${rgbRed}, ${rgbGreen}, ${rgbBlue})"></button><br/><br/> RGB색상 선택 <br/><button type="button" class="btn btn-primary" onclick="rgbled('rgbled','0','0','0')" style="background-color:#000000"></button><button type="button" class="btn btn-primary" onclick="rgbled('rgbled','255','0','0')" style="background-color:#FF0000"></button>
                                    <button type="button" class="btn btn-primary" onclick="rgbled('rgbled','0','255','0')" style="background-color:#00FF00"></button><button type="button" class="btn btn-primary" onclick="rgbled('rgbled','0','0','255')" style="background-color:#0000FF"></button>
                                    <button type="button" class="btn btn-primary" onclick="rgbled('rgbled','255','255','0')" style="background-color:#FFFF00"></button><button type="button" class="btn btn-primary" onclick="rgbled('rgbled','255','0','255')" style="background-color:#FF00FF"></button>
                                    <button type="button" class="btn btn-primary" onclick="rgbled('rgbled','0','255','255')" style="background-color:#00FFFF"></button><button type="button" class="btn btn-primary" onclick="rgbled('rgbled','255','255','255')" style="background-color:#FFFFFF"></button>
                                </div>

                                <div class="alt-features-item">
                                    <div class="alt-features-icon"><img src="<%=application.getContextPath()%>/resources/images/actuators/lcd.png" width="60px" height="60px" style="position:absoulte" /></div>
                                    <h3 class="alt-features-title font-alt">LCD Display</h3>LCD Display line0, line1 설정<br/><br/>
                                    <input type="text" id="line0" size=20 maxlength=10 value="line0" />
                                    <input type="text" id="line1" size=20 maxlength=10 value="line1" />
                                    <p></p><button type="button" class="btn btn-default btn-sm" onclick="lcd('lcd')">전송</button>
                                </div>

                            </div>
                        </div>
                    </div>
                </section>

                <hr class="divider-w">
                <section class="module" id="team">
                    <div class="container">
                        <div class="row">
                            <div class="col-sm-6 col-sm-offset-3">
                                <h2 class="module-title font-alt">IoT Team3 Member</h2>
                                <div class="module-subtitle font-serif">한국소프트웨어산업협회 주관 IoT엔지니어 양성 과정 3조</div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="mb-sm-20 wow fadeInUp col-sm-4 col-md-2 col-md-offset-1" onclick="wow fadeInUp">
                                <div class="team-item">
                                    <div class="team-image"><img src="<%=application.getContextPath()%>/resources/images/team/jsg.jpg" alt="Member Photo" />
                                        <div class="team-detail">
                                            <p class="font-serif">
                                                남 (Male)<br/> 동국대학교 컴퓨터공학과<br/> 010–4234–1067
                                                <br/> busk0821@gmail.com
                                            </p>
                                            <div class="team-social"><a href="#"><i class="fa fa-facebook"></i></a><a href="#"><i class="fa fa-twitter"></i></a><a href="#"><i class="fa fa-dribbble"></i></a><a href="#"><i class="fa fa-skype"></i></a></div>
                                        </div>
                                    </div>
                                    <div class="team-descr font-alt">
                                        <div class="team-name">장성근</div>
                                        <div class="team-role">Jang Sung Geun</div>
                                    </div>
                                </div>
                            </div>
                            <div class="mb-sm-20 wow fadeInUp col-sm-4 col-md-2" onclick="wow fadeInUp">
                                <div class="team-item">
                                    <div class="team-image"><img src="<%=application.getContextPath()%>/resources/images/team/ych.jpg" alt="Member Photo" />
                                        <div class="team-detail">
                                            <p class="font-serif">
                                                남 (Male)<br/> 동국대학교 컴퓨터공학과<br/> 010–9165–9080
                                                <br/> ych8989@gmail.com
                                            </p>
                                            <div class="team-social"><a href="#"><i class="fa fa-facebook"></i></a><a href="#"><i class="fa fa-twitter"></i></a><a href="#"><i class="fa fa-dribbble"></i></a><a href="#"><i class="fa fa-skype"></i></a></div>
                                        </div>
                                    </div>
                                    <div class="team-descr font-alt">
                                        <div class="team-name">유창현</div>
                                        <div class="team-role">Yoo Chang Hyun</div>
                                    </div>
                                </div>
                            </div>
                            <div class="mb-sm-20 wow fadeInUp col-sm-4 col-md-2" onclick="wow fadeInUp">
                                <div class="team-item">
                                    <div class="team-image"><img src="<%=application.getContextPath()%>/resources/images/team/kym.jpg" alt="Member Photo" />
                                        <div class="team-detail">
                                            <p class="font-serif">
                                                남 (Male)<br/> 서강대학교 컴퓨터공학과<br/> 010–5048–2438
                                                <br/> happistar09@naver.com
                                            </p>
                                            <div class="team-social"><a href="#"><i class="fa fa-facebook"></i></a><a href="#"><i class="fa fa-twitter"></i></a><a href="#"><i class="fa fa-dribbble"></i></a><a href="#"><i class="fa fa-skype"></i></a></div>
                                        </div>
                                    </div>
                                    <div class="team-descr font-alt">
                                        <div class="team-name">김영민</div>
                                        <div class="team-role">Kim Young Min</div>
                                    </div>
                                </div>
                            </div>
                            <div class="mb-sm-20 wow fadeInUp col-sm-4 col-md-2" onclick="wow fadeInUp">
                                <div class="team-item">
                                    <div class="team-image"><img src="<%=application.getContextPath()%>/resources/images/team/jsy.jpg" alt="Member Photo" />
                                        <div class="team-detail">
                                            <p class="font-serif">
                                                여 (Female)<br/> 동국대학교 컴퓨터공학과<br/> 010–5333–2105
                                                <br/> huntsu1234@gmail.com
                                            </p>
                                            <div class="team-social"><a href="#"><i class="fa fa-facebook"></i></a><a href="#"><i class="fa fa-twitter"></i></a><a href="#"><i class="fa fa-dribbble"></i></a><a href="#"><i class="fa fa-skype"></i></a></div>
                                        </div>
                                    </div>
                                    <div class="team-descr font-alt">
                                        <div class="team-name">정수양</div>
                                        <div class="team-role">Jung Su Yang</div>
                                    </div>
                                </div>
                            </div>
                            <div class="mb-sm-20 wow fadeInUp col-sm-4 col-md-2" onclick="wow fadeInUp">
                                <div class="team-item">
                                    <div class="team-image"><img src="<%=application.getContextPath()%>/resources/images/team/jsm.jpg" alt="Member Photo" />
                                        <div class="team-detail">
                                            <p class="font-serif">
                                                여 (Female)<br/> 서강대학교 컴퓨터공학과<br/> 010–9981–4763
                                                <br/> wjdtpa2@gmail.com
                                            </p>
                                            <div class="team-social"><a href="#"><i class="fa fa-facebook"></i></a><a href="#"><i class="fa fa-twitter"></i></a><a href="#"><i class="fa fa-dribbble"></i></a><a href="#"><i class="fa fa-skype"></i></a></div>
                                        </div>
                                    </div>
                                    <div class="team-descr font-alt">
                                        <div class="team-name">정세미</div>
                                        <div class="team-role">Jeong Se Mi</div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>




                <section class="module bg-dark-60 pt-0 pb-0 parallax-bg testimonial" data-background="<%=application.getContextPath()%>/resources/assets/images/testimonial_bg.jpg">
                    <div class="testimonials-slider pt-140 pb-140">
                        <ul class="slides">
                            <li>
                                <div class="container">
                                    <div class="row">
                                        <div class="col-sm-12">
                                            <div class="module-icon"><span class="icon-quote"></span></div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-8 col-sm-offset-2">
                                            <blockquote class="testimonial-text font-alt">I am alone, and feel the charm of existence in this spot, which was created for the bliss of souls like mine.</blockquote>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-4 col-sm-offset-4">
                                            <div class="testimonial-author">
                                                <div class="testimonial-caption font-alt">
                                                    <div class="testimonial-title">Jack Woods</div>
                                                    <div class="testimonial-descr">SomeCompany INC, CEO</div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </li>
                            <li>
                                <div class="container">
                                    <div class="row">
                                        <div class="col-sm-12">
                                            <div class="module-icon"><span class="icon-quote"></span></div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-8 col-sm-offset-2">
                                            <blockquote class="testimonial-text font-alt">I should be incapable of drawing a single stroke at the present moment; and yet I feel that I never was a greater artist than now.</blockquote>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-4 col-sm-offset-4">
                                            <div class="testimonial-author">
                                                <div class="testimonial-caption font-alt">
                                                    <div class="testimonial-title">Jim Stone</div>
                                                    <div class="testimonial-descr">SomeCompany INC, CEO</div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </li>
                            <li>
                                <div class="container">
                                    <div class="row">
                                        <div class="col-sm-12">
                                            <div class="module-icon"><span class="icon-quote"></span></div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-8 col-sm-offset-2">
                                            <blockquote class="testimonial-text font-alt">I am so happy, my dear friend, so absorbed in the exquisite sense of mere tranquil existence, that I neglect my talents.</blockquote>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-4 col-sm-offset-4">
                                            <div class="testimonial-author">
                                                <div class="testimonial-caption font-alt">
                                                    <div class="testimonial-title">Adele Snow</div>
                                                    <div class="testimonial-descr">SomeCompany INC, CEO</div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div>
                </section>
                <section class="module" id="news">
                    <div class="container">
                        <div class="row">
                            <div class="col-sm-6 col-sm-offset-3">
                                <h2 class="module-title font-alt">Latest blog posts</h2>
                                <div class="module-subtitle font-serif">A wonderful serenity has taken possession of my entire soul, like these sweet mornings of spring which I enjoy with my whole heart.</div>
                            </div>
                        </div>
                        <div class="row multi-columns-row post-columns">
                            <div class="col-sm-6 col-md-4 col-lg-4">
                                <div class="post mb-20">
                                    <div class="post-thumbnail"><a href="#"><img src="<%=application.getContextPath()%>/resources/assets/images/post-1.jpg" alt="Blog-post Thumbnail"/></a></div>
                                    <div class="post-header font-alt">
                                        <h2 class="post-title"><a href="#">Our trip to the Alps</a></h2>
                                        <div class="post-meta">By&nbsp;<a href="#">Mark Stone</a>&nbsp;| 23 November | 3 Comments
                                        </div>
                                    </div>
                                    <div class="post-entry">
                                        <p>A wonderful serenity has taken possession of my entire soul, like these sweet mornings of spring which I enjoy with my whole heart.</p>
                                    </div>
                                    <div class="post-more"><a class="more-link" href="#">Read more</a></div>
                                </div>
                            </div>
                            <div class="col-sm-6 col-md-4 col-lg-4">
                                <div class="post mb-20">
                                    <div class="post-thumbnail"><a href="#"><img src="<%=application.getContextPath()%>/resources/assets/images/post-2.jpg" alt="Blog-post Thumbnail"/></a></div>
                                    <div class="post-header font-alt">
                                        <h2 class="post-title"><a href="#">Shore after the tide</a></h2>
                                        <div class="post-meta">By&nbsp;<a href="#">Andy River</a>&nbsp;| 11 November | 4 Comments
                                        </div>
                                    </div>
                                    <div class="post-entry">
                                        <p>A wonderful serenity has taken possession of my entire soul, like these sweet mornings of spring which I enjoy with my whole heart.</p>
                                    </div>
                                    <div class="post-more"><a class="more-link" href="#">Read more</a></div>
                                </div>
                            </div>
                            <div class="col-sm-6 col-md-4 col-lg-4">
                                <div class="post mb-20">
                                    <div class="post-thumbnail"><a href="#"><img src="<%=application.getContextPath()%>/resources/assets/images/post-3.jpg" alt="Blog-post Thumbnail"/></a></div>
                                    <div class="post-header font-alt">
                                        <h2 class="post-title"><a href="#">We in New Zealand</a></h2>
                                        <div class="post-meta">By&nbsp;<a href="#">Dylan Woods</a>&nbsp;| 5 November | 15 Comments
                                        </div>
                                    </div>
                                    <div class="post-entry">
                                        <p>A wonderful serenity has taken possession of my entire soul, like these sweet mornings of spring which I enjoy with my whole heart.</p>
                                    </div>
                                    <div class="post-more"><a class="more-link" href="#">Read more</a></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
                <div class="module-small bg-dark">
                    <div class="container">
                        <div class="row">
                            <div class="col-sm-6 col-md-6 col-lg-4 col-lg-offset-2">
                                <div class="callout-text font-alt">
                                    <h3 class="callout-title">Subscribe now</h3>
                                    <p>We will not spam your email.</p>
                                </div>
                            </div>
                            <div class="col-sm-6 col-md-6 col-lg-4">
                                <div class="callout-btn-box">
                                    <form id="subscription-form" role="form" method="post" action="php/subscribe.php">
                                        <div class="input-group">
                                            <input class="form-control" type="email" id="semail" name="semail" placeholder="Your Email" data-validation-required-message="Please enter your email address." required="required" /><span class="input-group-btn">
                        <button class="btn btn-g btn-round" id="subscription-form-submit" type="submit">Submit</button></span>
                                        </div>
                                    </form>
                                    <div class="text-center" id="subscription-response"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <section class="module" id="contact">
                    <div class="container">
                        <div class="row">
                            <div class="col-sm-6 col-sm-offset-3">
                                <h2 class="module-title font-alt">Get in touch</h2>
                                <div class="module-subtitle font-serif"></div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-6 col-sm-offset-3">
                                <form id="contactForm" role="form" method="post" action="php/contact.php">
                                    <div class="form-group">
                                        <label class="sr-only" for="name">Name</label>
                                        <input class="form-control" type="text" id="name" name="name" placeholder="Your Name*" required="required" data-validation-required-message="Please enter your name." />
                                        <p class="help-block text-danger"></p>
                                    </div>
                                    <div class="form-group">
                                        <label class="sr-only" for="email">Email</label>
                                        <input class="form-control" type="email" id="email" name="email" placeholder="Your Email*" required="required" data-validation-required-message="Please enter your email address." />
                                        <p class="help-block text-danger"></p>
                                    </div>
                                    <div class="form-group">
                                        <textarea class="form-control" rows="7" id="message" name="message" placeholder="Your Message*" required="required" data-validation-required-message="Please enter your message."></textarea>
                                        <p class="help-block text-danger"></p>
                                    </div>
                                    <div class="text-center">
                                        <button class="btn btn-block btn-round btn-d" id="cfsubmit" type="submit">Submit</button>
                                    </div>
                                </form>
                                <div class="ajax-response font-alt" id="contactFormResponse"></div>
                            </div>
                        </div>
                    </div>
                </section>
                <!-- <section id="map-section">
                    <div id="map"></div>
                </section> -->
                <div class="module-small bg-dark">
                    <div class="container">
                        <div class="row">
                            <div class="col-sm-3">
                                <div class="widget">
                                    <h5 class="widget-title font-alt">About Titan</h5>
                                    <p>The languages only differ in their grammar, their pronunciation and their most common words.</p>
                                    <p>Phone: +1 234 567 89 10</p>Fax: +1 234 567 89 10
                                    <p>Email:<a href="#">somecompany@example.com</a></p>
                                </div>
                            </div>
                            <div class="col-sm-3">
                                <div class="widget">
                                    <h5 class="widget-title font-alt">Recent Comments</h5>
                                    <ul class="icon-list">
                                        <li>Maria on <a href="#">Designer Desk Essentials</a></li>
                                        <li>John on <a href="#">Realistic Business Card Mockup</a></li>
                                        <li>Andy on <a href="#">Eco bag Mockup</a></li>
                                        <li>Jack on <a href="#">Bottle Mockup</a></li>
                                        <li>Mark on <a href="#">Our trip to the Alps</a></li>
                                    </ul>
                                </div>
                            </div>
                            <div class="col-sm-3">
                                <div class="widget">
                                    <h5 class="widget-title font-alt">Blog Categories</h5>
                                    <ul class="icon-list">
                                        <li><a href="#">Photography - 7</a></li>
                                        <li><a href="#">Web Design - 3</a></li>
                                        <li><a href="#">Illustration - 12</a></li>
                                        <li><a href="#">Marketing - 1</a></li>
                                        <li><a href="#">Wordpress - 16</a></li>
                                    </ul>
                                </div>
                            </div>
                            <div class="col-sm-3">
                                <div class="widget">
                                    <h5 class="widget-title font-alt">Popular Posts</h5>
                                    <ul class="widget-posts">
                                        <li class="clearfix">
                                            <div class="widget-posts-image"><a href="#"><img src="<%=application.getContextPath()%>/resources/assets/images/rp-1.jpg" alt="Post Thumbnail"/></a></div>
                                            <div class="widget-posts-body">
                                                <div class="widget-posts-title"><a href="#">Designer Desk Essentials</a></div>
                                                <div class="widget-posts-meta">23 january</div>
                                            </div>
                                        </li>
                                        <li class="clearfix">
                                            <div class="widget-posts-image"><a href="#"><img src="<%=application.getContextPath()%>/resources/assets/images/rp-2.jpg" alt="Post Thumbnail"/></a></div>
                                            <div class="widget-posts-body">
                                                <div class="widget-posts-title"><a href="#">Realistic Business Card Mockup</a></div>
                                                <div class="widget-posts-meta">15 February</div>
                                            </div>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <hr class="divider-d">
                <footer class="footer bg-dark">
                    <div class="container">
                        <div class="row">
                            <div class="col-sm-6">
                                <p class="copyright font-alt">&copy; 2017&nbsp;<a href="index.html">TitaN</a>, All Rights Reserved</p>
                            </div>
                            <div class="col-sm-6">
                                <div class="footer-social-links"><a href="#"><i class="fa fa-facebook"></i></a><a href="#"><i class="fa fa-twitter"></i></a><a href="#"><i class="fa fa-dribbble"></i></a><a href="#"><i class="fa fa-skype"></i></a>
                                </div>
                            </div>
                        </div>
                    </div>
                </footer>
            </div>
            <div class="scroll-up"><a href="#totop"><i class="fa fa-angle-double-up"></i></a></div>
            <!-- <script async="" defer="" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDWOUFiNJDcJz52bH_O6Ps2S1YvVYQ0Zmo"></script> -->
        </main>

        <!--  
    JavaScripts
    =============================================
    -->
        <script src="<%=application.getContextPath()%>/resources/assets/lib/wow/dist/wow.js"></script>
        <script src="<%=application.getContextPath()%>/resources/assets/lib/jquery.mb.ytplayer/dist/jquery.mb.YTPlayer.js"></script>
        <script src="<%=application.getContextPath()%>/resources/assets/lib/isotope/dist/isotope.pkgd.js"></script>
        <script src="<%=application.getContextPath()%>/resources/assets/lib/imagesloaded/imagesloaded.pkgd.js"></script>
        <script src="<%=application.getContextPath()%>/resources/assets/lib/flexslider/jquery.flexslider.js"></script>
        <script src="<%=application.getContextPath()%>/resources/assets/lib/owl.carousel/dist/owl.carousel.min.js"></script>
        <script src="<%=application.getContextPath()%>/resources/assets/lib/smoothscroll.js"></script>
        <script src="<%=application.getContextPath()%>/resources/assets/lib/magnific-popup/dist/jquery.magnific-popup.js"></script>
        <script src="<%=application.getContextPath()%>/resources/assets/lib/simple-text-rotator/jquery.simple-text-rotator.min.js"></script>
        <!-- <script async="" defer="" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDWOUFiNJDcJz52bH_O6Ps2S1YvVYQ0Zmo"></script> -->
        <script src="<%=application.getContextPath()%>/resources/assets/js/plugins.js"></script>
        <script src="<%=application.getContextPath()%>/resources/assets/js/main.js"></script>
        <script src="<%=application.getContextPath()%>/resources/highcharts/code/highcharts.js"></script>
        <script src="<%=application.getContextPath()%>/resources/highcharts/code/themes/grid-light.js"></script>

		<!-- HighCharts Reference -->
        <script src="<%=application.getContextPath()%>/resources/js/chart/photoresistorchart.js"></script>
        <script src="<%=application.getContextPath()%>/resources/js/chart/gaschart.js"></script>
        <script src="<%=application.getContextPath()%>/resources/js/chart/temperaturechart.js"></script>
        <script src="<%=application.getContextPath()%>/resources/js/chart/pressurechart.js"></script>
        <script src="<%=application.getContextPath()%>/resources/js/chart/humiturechart.js"></script>
        <script src="<%=application.getContextPath()%>/resources/js/chart/raindropchart.js"></script>
        <script src="<%=application.getContextPath()%>/resources/js/chart/mercurychart.js"></script>
        <script src="<%=application.getContextPath()%>/resources/js/chart/lightchart.js"></script>
        <script src="<%=application.getContextPath()%>/resources/js/chart/frontultrasonicchart.js"></script>
        <script src="<%=application.getContextPath()%>/resources/js/chart/sideultrasonicchart.js"></script>
        <script src="<%=application.getContextPath()%>/resources/js/chart/backultrasonicchart.js"></script>

		<!-- Actuator Reference -->
        <script src="<%=application.getContextPath()%>/resources/js/actuator/buzzer.js"></script>
        <script src="<%=application.getContextPath()%>/resources/js/actuator/laseremitter.js"></script>
        <script src="<%=application.getContextPath()%>/resources/js/actuator/lcd.js"></script>
        <script src="<%=application.getContextPath()%>/resources/js/actuator/rgbled.js"></script>
        <script src="<%=application.getContextPath()%>/resources/js/actuator/light.js"></script>
        
    </body>

    </html>