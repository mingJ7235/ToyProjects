<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<title>MUTJINPEOPLE_JOIN</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
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

.fields {
	width: 80% !important;
}

.checkText {
	text-align: left;
	margin-left : 1%;
	font-size: 1.1rem;
	margin-bottom: 0; 
		
}

.inputName {
	text-align: left; 
	margin-left: 1%;
	margin-bottom: 1.2rem !important;
	
}

.fontColorRed {
	color : red;
}

.inputNameSpan {
	font-size: 0.8rem;
}

</style>






</head>
<body class="is-preload">

	<div>
		<c:import url="../header/header.jsp" />

	</div>
		<c:import url="../sidebar/sidebar.jsp" />	

	<!-- Wrapper -->
	<div id="wrapper">


		<!-- One -->
		<section class="wrapper style2 special">
			<div class="inner">

				<!-- Elements -->
				<header class="major">
					<h1>이제 당신도 멋진 사람</h1>
					<p> [회원가입] </p>
				</header>

				<!-- 
                        String memberId;
						String memberPw;
						String memberName;
						int memberAge;
						String memberEmail;
						String memberZipcode;
						String memberLocation;
						String memberLocationDetail;
						String memberCanOne;
						String memberCanTwo;
						String memberCanThree;
						String memberWantOne;
						String memberWantTwo;
						String memberWantThree;
					                      -->
				<div class="content">
					<div class="form">
						<form id="joinForm" method="post" action="/member/join">
							<div class="fields" style = "margin : 0 auto;">
								<div class="field">
									<h3 class="inputName">아이디 <span class="inputNameSpan">(<span class="fontColorRed">*</span>)</span></h3>
									<input id = "memberId" name="memberId" type="text" placeholder="아이디" />
									<p id="idText" class="checkText"></p>
								</div>
								<div class="field">
									<h3 class="inputName">비밀번호 <span class="inputNameSpan">(<span class="fontColorRed">*</span>)</span></h3>
									<input id = "memberPw" name="memberPw" type="password" placeholder="비밀번호" />
								</div>
								<div class="field">
									<h3 class="inputName">비밀번호 확인</h3>
									<input id="memberPwCheck" name="memberPwCheck" type="password" placeholder="비밀번호확인"/>
									<p id="pwText" class="checkText"></p>
								</div>
								<div class="field">
									<h3 class="inputName">이름 <span class="inputNameSpan">(<span class="fontColorRed">*</span>)</span></h3>
									<input id="memberName" name="memberName" type="text" placeholder="이름" />
								</div>
								<div class="field">
									<h3 class="inputName">나이 <span class="inputNameSpan">(<span class="fontColorRed">*</span>)</span></h3>
									<input id="memberAge" name="memberAge" type="text" placeholder="나이" />
								</div>
								<div class="field">
									<h3 class="inputName">이메일 <span class="inputNameSpan">(<span class="fontColorRed">*</span>)</span></h3>
									<input id="memberEmail" name="memberEmail" type="text" placeholder="이메일주소 (ex> abc@def.com)" />
									<p id="emailText" class="checkText"></p>
								</div>
								
								<!-- 
								<input type="text" name="" class="postcodify_postcode5" value="" />
								<button id="postcodify_search_button">검색</button><br />
								<input type="text" name="" class="postcodify_address" value="" /><br />
								<input type="text" name="" class="postcodify_details" value="" /><br />
								<input type="text" name="" class="postcodify_extra_info" value="" /><br />
								
								 -->
								<div class="field">
									<h3 class="inputName">우편번호</h3>
									<input name="memberZipcode" class="postcodify_postcode5" type="text" placeholder="검색버튼을 눌러주세요" />
									<button id="postcodify_search_button">검색</button>
								</div>
								<div class="field">
									<h3 class="inputName">주소</h3>
									<input name="memberLocation" class="postcodify_address" type="text" placeholder="주소" />
								</div>
								<div class="field">
									<h3 class="inputName">상세주소</h3>
									<input name="memberLocationDetail" class="postcodify_details" type="text" placeholder="상세주소" />
								</div>
								<div class="field">
									<h3>Sharing Talent For you</h3>
									<blockquote>
									당신의 재능은 무엇인가요?<br>
									당신이 나눌수 있는 재능이 무엇이든 선택해주세요. <br>
									또, 당신이 배우고 싶거나 관심있는 분야가 무엇인지 선택해주세요. <br>
									(최소 1가지, 최대 3가지씩 선택이 가능합니다.)
									</blockquote>
								</div>
								
								<div class="field">
									<h3 class="inputName"> 재능 #1 <span class="inputNameSpan">(<span class="fontColorRed">*</span>)</span></h3>
									<input name="memberCanOne" type="text" placeholder="writer" />
								</div>
								<div class="field">
									<h3 class="inputName"> 재능 #2 </h3>
									<input name="memberCanTwo" type="text" placeholder="writer" />
								</div>
								<div class="field">
									<h3 class="inputName"> 재능 #3 </h3>
									<input name="memberCanThree" type="text" placeholder="writer" />
								</div>
								<br>
																
								<br>
								<div class="field">
									<h3 class="inputName"> 관심분야 #1 <span class="inputNameSpan">(<span class="fontColorRed">*</span>)</span></h3>
									<input name="memberWantOne" type="text" placeholder="writer" />
								</div>
								<div class="field">
									<h3 class="inputName"> 관심분야 #2 </h3>
									<input name="memberWantTwo" type="text" placeholder="writer" />
								</div>
								<div class="field">
									<h3 class="inputName"> 관심분야 #3 </h3>
									<input name="memberWantThree" type="text" placeholder="writer" />
								</div>
								
							
							</div>

							<ul class="actions special">
								<li><input type="submit" class="button joinBtn" value="멋진사람되기">
								</li>
							</ul>
							
						</form>
					</div>
				</div>
			</div>
		</section>



		<!-- Footer -->
		<section id="footer" class="wrapper split style2">
			<div class="inner">
				<section>
					<header>
						<h3>Magna lorem ipsum</h3>
					</header>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
						Duis dapibus rutrum facilisis. Class aptent taciti sociosqu ad
						litora torquent per conubia nostra, per inceptos himenaeos magna
						fames ac turpis egestas amet non lorem amet.</p>
					<ul class="icons">
						<li><a href="#" class="icon brands fa-twitter"><span
								class="label">Twitter</span></a></li>
						<li><a href="#" class="icon brands fa-instagram"><span
								class="label">Instagram</span></a></li>
						<li><a href="#" class="icon brands fa-snapchat-ghost"><span
								class="label">Snapchat</span></a></li>
						<li><a href="#" class="icon brands fa-github"><span
								class="label">GitHub</span></a></li>
					</ul>
				</section>
				<section>
					<form method="post" action="#">
						<div class="fields">
							<div class="field half">
								<input type="text" name="name" id="name" placeholder="Name" />
							</div>
							<div class="field half">
								<input type="email" name="email" id="email" placeholder="Email" />
							</div>
							<div class="field">
								<textarea name="message" id="message" placeholder="Message"
									rows="4"></textarea>
							</div>
						</div>
						<ul class="actions">
							<li><input type="submit" value="Send Message" /></li>
						</ul>
					</form>
				</section>
			</div>
			<div class="copyright">
				<p>&copy; Untitled. All rights reserved. Lorem ipsum dolor sit
					amet nullam.</p>
			</div>
		</section>

	</div>

	<!-- Scripts -->
	<script src="/resources/assets/js/jquery.min.js"></script>
	<script src="/resources/assets/js/browser.min.js"></script>
	<script src="/resources/assets/js/breakpoints.min.js"></script>
	<script src="/resources/assets/js/util.js"></script>
	<script src="/resources/assets/js/main.js"></script>
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
	<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>
	

</body>
<script> 
	$("#postcodify_search_button").on("click", function(e){
		e.preventDefault();
		$(this).postcodifyPopUp();
		
	})

</script>


<script>
var arrFlag = [];
arrFlag[0] = false;

//아이디 중복 체크
$("#memberId").blur(function() {
	
	let inputId = $("#memberId").val();
	let text = $("#idText");	
	let regExp = /^[A-Za-z0-9_]{6,20}$/;
	
	console.log(inputId);
	
	if(!regExp.test($(this).val())){
		console.log("not");
		text.css("color", "#ff6347");
		text.text("영문,숫자 6~20자리");
		arrFlag[0] = false;
		return false;
	}
	
	$.ajax({
		type: "get",
		url : "/member/checkId",
		data:{
			"memberId" : inputId		
		},
		success : function(result) {			
			if($.trim(result) == 1){
				resultCheckId = true;
				text.css("color", "#3cb371");
				text.text("사용 가능한 ID입니다");
				arrFlag[0] = true;
				
			}else{
				resultCheckId = false;
				text.css("color", "#ff6347");
				text.text("사용 중인 ID입니다");
				arrFlag[0] = false;
				
			}				
		},
		error : function(a, b, c){			
			console.log(a + b + c);
		}	
	});		
});

//비밀번호 확인과 일치하는지 체크
$("#memberPwCheck").blur(function (){
	var pw = $("#memberPw").val();
	var pwCheck = $(this).val();
	var text = $("#pwText");
	
	if(pw == pwCheck){
		console.log("ok");
		text.css("color", "#3cb371");
		text.text("비밀번호가 일치합니다");
		arrFlag[1] = true;
	}else{
		console.log("not");
		text.css("color", "#ff6347");
		text.text("비밀번호가 다릅니다");
		arrFlag[1] = false;
	}
});

//비밀번호 정규식 체크
$("#memberPw").blur(function() {
	
})

//이메일 정규식 체크 및 중복 체크
$("#memberEmail").blur(function(){
	let regExp = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
	inputEmail = $("#memberEmail").val();
	text = $("#emailText");
	
	console.log(inputEmail);
	if(!regExp.test(inputEmail)) {
		text.css("color", "#ff6347");
		text.text("이메일 형식에 맞게 입력해주세요");
		arrFlag[2] = false;
		return false;
	}	
	
	$.ajax ({
		url : "/member/checkEmail",
		type : "get",
		data : {memberEmail : inputEmail},
		success : function(result) {
			if ($.trim(result) == 1) {
				text.css("color", "#3cb371");
				text.text ("사용가능한 이메일 입니다. ");
				arrFlag[2] = true;
			} else {
				text.css("color", "#ff6347");
				text.text("사용중인 이메일입니다. ");
				arrFlag[2] = false;
			}
		},
		error : function (xhr, status, err) {
			console.log(xhr + status + err)
		}
	})
	
	
	
})

function formOk() {	
	for(let i=0;i<6;i++){		
		if(arrFlag[i] == false){
			alert("입력 양식이 틀렸습니다. 확인해주세요");
			return false;
		}		
	}
	$("#join").submit();
}
	

	
</script>
</html>










