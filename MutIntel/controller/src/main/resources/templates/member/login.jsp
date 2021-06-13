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
		<style>
		a {
			border-bottom: none;
		
		}
		
		.checkPTag {
			display : none;
			
		}
		
		.fields {
			width: 80%;
			margin : 0 auto;
		}
		
		</style>
		
		
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
                        <h1>Login</h1>
                        <p>로그인</p>
                    	 </header>
                              <div class="content">
                              	<div class="form">
                              		<form id="loginForm" method="post" action="/member/login">
                              			<div class="fields">
                              				<div class="field">
                              					<h3>ID</h3>
                              					<input name="memberId" type="text" placeholder="아이디"/>
                              					<p class = "checkPTag"></p>
                              				</div>
                              				<div class="field">
                              					<h3>PW</h3>
                              					<input name="memberPw" type="password" placeholder="비밀번호"/>
                              				</div>    
                              			</div>
                              			
                              			<ul class="actions special">
                              				<li>
                              					<input type="submit" class="button loginBtn" value="로그인">
                              					<a href="/member/join" class="button joinBtn">회원가입</a>
                              					<a href="/member/findId" class="button findBtn">아이디/비밀번호 찾기</a>
                              				</li>
                              			</ul>
                              		</form>
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
	<script>
	
	
	
	</script>
</html>










