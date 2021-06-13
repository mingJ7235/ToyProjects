<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<!--
	Reflex by Pixelarity
	pixelarity.com | hello@pixelarity.com
	License: pixelarity.com/license
-->
<html>
	<head>
		<title>MUTJINPEOPLE_LOGIN</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<meta name="description" content="" />
        <meta name="keywords" content="" />
		<link rel="stylesheet" href="/resources/assets/css/main.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style type="text/css">
.mybtn{
  width:150px;
  height:40px;
  padding:0;
  display:inline; 
  border-radius: 4px; 
  background: #212529;
  color: #fff;
  margin-top: 20px;
  border: solid 2px #212529; 
  transition: all 0.5s ease-in-out 0s;
}
.mybtn:hover .mybtn:focus {
  background: white;
  color: #212529;
  text-decoration: none;
}

.field input {

}

</style>
<title>비밀번호 찾기</title>
</head>
<body class="is-preload">

		<!-- Header -->
		<div>
			<c:import url="../header/header.jsp"/>
		
		</div>
			<c:import url="../sidebar/sidebar.jsp"/> 
			
			
		<!-- Wrapper -->
			<div id="wrapper">

				<!-- Intro -->
					

				<!-- One -->
					<section class="wrapper style2 special">
						<div class="inner">

                  <!-- Elements -->
                     <header class="major">
                        <h1>비밀번호 찾기</h1>
                        <p>비밀번호를 잃어버리셨나요? 괜찮아요 찾아드릴게요</p>
                    	 </header>
                              <div class="content">
                              	<div class="form">
                              			<div class="fields">
                              				<div class="field">
                              					
												<input type="text" id="memberId" name="memberId" placeholder="회원가입한 아이디를 입력하세요" required>
												<input type="text" id="memberEmail" name="memberEmail" placeholder="회원가입한 이메일주소를 입력하세요" required>
                              					
                              				</div>
                              			</div>
                              			
                              			<ul class="actions special">
                              				<li>
												<input type="button" id="findBtn" value="비밀번호 찾기">
												<a type="button" id="" class = "button" href="/member/login" >로그인</a>
                              				</li>
                              			</ul>
                              	</div>
                              </div>
                        </div>
					</section>
				</div>

				

				<!-- Footer -->
					<section id="footer" class="wrapper split style2">
						<div class="inner">
							<section>
								<header>
									<h3>Magna lorem ipsum</h3>
								</header>
								<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis dapibus rutrum facilisis. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos magna fames ac turpis egestas amet non lorem amet.</p>
								<ul class="icons">
									<li><a href="#" class="icon brands fa-twitter"><span class="label">Twitter</span></a></li>
									<li><a href="#" class="icon brands fa-instagram"><span class="label">Instagram</span></a></li>
									<li><a href="#" class="icon brands fa-snapchat-ghost"><span class="label">Snapchat</span></a></li>
									<li><a href="#" class="icon brands fa-github"><span class="label">GitHub</span></a></li>
								</ul>
							</section>
							<section>
								<form method="post" action="#">
									<div class="fields">
										<div class="field half"><input type="text" name="name" id="name" placeholder="Name" /></div>
										<div class="field half"><input type="email" name="email" id="email" placeholder="Email" /></div>
										<div class="field"><textarea name="message" id="message" placeholder="Message" rows="4"></textarea></div>
									</div>
									<ul class="actions">
										<li><input type="submit" value="Send Message" /></li>
									</ul>
								</form>
							</section>
						</div>
						<div class="copyright">
							<p>&copy; Untitled. All rights reserved. Lorem ipsum dolor sit amet nullam.</p>
						</div>
					</section>

		

		<!-- Scripts -->
			<script src="/resources/assets/js/jquery.min.js"></script>
			<script src="/resources/assets/js/browser.min.js"></script>
			<script src="/resources/assets/js/breakpoints.min.js"></script>
			<script src="/resources/assets/js/util.js"></script>
			<script src="/resources/assets/js/main.js"></script>

	</body>
<script src="http://code.jquery.com/jquery-latest.js"></script>
			
<script>
	$(function(){
		$("#findBtn").click(function(){
			
			console.log($("#memberId").val());
			console.log($("#memberEmail").val());
			$.ajax({
				url : "/member/findpw",
				type : "POST",
				data : {
					memberId : $("#memberId").val(),
					memberEmail : $("#memberEmail").val()
				},
				success : function(result) {
					alert(result);
				},
				error : function (xhr, status, err) {
					alert(err);
				}
			})
		});
	})
</script>
</html>