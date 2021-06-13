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
		<link rel="preconnect" href="https://fonts.gstatic.com">
		<link href="https://fonts.googleapis.com/css2?family=Poor+Story&display=swap" rel="stylesheet">
		<style>
		body {
			font-family: 'Poor Story', cursive !important;
		}
		a {
			border-bottom: none;
		
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
                        <h1>아이디 찾기</h1>
                        <p>아이디를 분실하셨나요? 괜찮아요 도와줄게요</p>
                    	 </header>
                              <div class="content">
                              	<div class="form">
                              		<form id="findId" method="post" action="/member/findId">
                              			<div class="fields">
                              				<div class="field">
                              					
                              					<input name="memberName" type="text" >
                              					<input name="memberEmail" type="text">
                              					
                              					
                              				</div>
                              			</div>
                              			
                              			<ul class="actions special">
                              				<li>
                              					<input type="submit" value="입력하세요">
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
	/* $("#findIdBtn").on("click", function(e){
		e.preventDefault();
		var memberName = $("input[name='memberName']").val();
		var memberEmail = $("input[name='memberEmail']").val();
		
			
		
	}) */
	
	
	
	</script>
</html>










