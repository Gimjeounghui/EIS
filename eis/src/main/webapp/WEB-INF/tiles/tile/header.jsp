<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="com.kun.eis.user.member.vo.MemberVO" %>
<%@ page trimDirectiveWhitespaces="true"%>

	<style>
		.naviBar {
		
			display: table;
			margin-left: auto;
			margin-right: auto;
		}
	</style>
	
	<script type="text/javascript">
	
		$(function() {
	
		});
	
		function logOut() {
			
			var param = { };
			
			$.ajax({
				
				url : "/login/logOut.json",
				type : "POST",
				dataType : "json", 		 /* DB로 값을 받는 방식 */
				data : param,			 /* DB로 보내는 값 */
				
				success : function(result) {
				},
				
				error : function() {
					alert("오류가 발생했습니다. 다시 시도해주세요.");
				},
				
				complete: function(result) {
					alert("로그아웃");
					location.href='/';
				}
			});
		}
		
	</script>

	<div class="top_banner">
		<div class="top_wrap">
			<ul>
			<%-- <%
			// userInfo에 VO(비밀번호 제외) 담겨있음
			MemberVO userInfo = (MemberVO)session.getAttribute("vo");
			// jstl 변수로 사용하기 위해 선언
			pageContext.setAttribute("info", userInfo);
			%>	
	
				<c:choose>  
					<c:when test="${empty info}"> 
						<li><a href="/member/signUp" style="color:#04a1a8; font-weight:bold; font-size:13px;">회원가입</a></li>
						<li><a href="/member/loginMember" style="color:#04a1a8; font-weight:bold; font-size:13px;">로그인</a></li>
					</c:when> 
					<c:otherwise> 
						<li><a href="#" style="color:#04a1a8; font-weight:bold; font-size:13px;"><strong>${info.mEmail}님 환영합니다!</strong></a></li>
						<li><a href="#" style="color:#04a1a8; font-weight:bold; font-size:13px;">마이페이지</a></li>
						<li><a href="#" style="color:#04a1a8; font-weight:bold; font-size:13px;" onclick="logOut();">로그아웃</a></li>
					</c:otherwise>
				</c:choose> --%>  
			</ul>
		</div>
	</div>
	<header class="header_wrap">
		<div class="logo_wrap">
			<div class="logo">
				<a href="/"> 
					<img src="" alt="KUN_EIS_LOGO">
				</a>
			</div>
		</div>
		<div class="menu_wrap">
			<div class="menu_content">
				<div class="eis_main">
					<ul class="naviBar">
						<li><a href="/member/listMember">회원관리</a></li>
						<li><a href="/business/listBusiness">회사영업</a></li>
						<li><a href="/work/lsitWork">업무관리</a></li>
						<li><a href="/project/listProject">프로젝트</a></li>
					</ul>
				</div>
				<div class="eis">
					<!-- 하위메뉴 생성 예정 -->
				</div>
			</div>
		</div>
	</header>