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
		<title>Untitled</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<meta name="description" content="" />
        <meta name="keywords" content="" />
		<link rel="stylesheet" href="/resources/assets/css/main.css" />
		<style>
		a {
			border-bottom: none;
		
		}
		
		.top_header {
			width : 100%;
			height: 130px;
			border-bottom: 1px solid #565656;		
			display : flex;
			justify-content: flex-start; 
			
		}
		.header_logo {
			margin-left : 3%;
			padding-top: 10px; 
			
		}
		
		.logoImg {
			width : auto;
			height : 100px;
		}
		
		
		.top_header_mobile {
			display : none;
		}
		
		
		.header_menus {
			display : flex;
			justify-content: space-evenly; 
			width : 50%;
			margin-top : 70px;
			
		}
		
		.header_menu {
			color : #5B5B5B;
			font-weight: 2;
			font-size : 1.2rem;
		}
		
		@media(max-width : 918px) {
			.header_logo {
				display : none;
			}
				
		}
		
		@media(max-width : 480px)  {
			.top_header {
				display: none;
			}
			.top_header_mobile {
				
			}
		}
		
		
		
		</style>
		
		
	</head>
	<body class="is-preload">
		<!-- web페이지일 경우 헤더 -->
		<div class="top_header">
			<div class="header_logo">
				<a href="/member/home"><img class = "logoImg" src="https://media.discordapp.net/attachments/847093134664138792/847094043636137994/mutMainLogo.png"></a>
			</div>
			<div class="header_menus">
				<div class="header_menu">
					<a>지역별 멋쟁이들</a>
				</div>
				<div class="header_menu">
					<a>이런 멋쟁이 있나요?</a>
				</div>
				<div class="header_menu">
					<a href = "/board/list">멋진 수다쟁이들</a>
				</div>
			</div>
		</div>
		
		<!-- 모바일 경우 헤더 -->
		<div class = "top_header_mobile">
		
		</div>

	</body>
</html>










