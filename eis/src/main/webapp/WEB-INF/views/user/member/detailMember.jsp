<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="com.kun.eis.user.member.vo.MemberVO" %>
	
	<style type="text/css">
	
		.btnArea {
		
			display : flex;
			justify-content :center;
			align-items : center;
		}
		
		.btnArea .space {
			
			width : 20px;
			height : auto;
			display : inline-block;
		}
		
		.btnArea #listBtn {
		
		    display: inline-block;
		    font-weight: 1000;
		    width: 110px;
		    height: 40px;
		    color: black;
		    background-color: white;
		    font-size: 13px;
		    border: none;
		    border-radius: 20px;
		    box-shadow: 0 4px 16px rgba(0, 79, 255, 0.3);
		}
	
		.btnArea #listBtn:focus { outline: 0; }
	
		.btnArea #listBtn:hover {
	
	    	animation-name: fadeIn;
	    	animation-duration: 0.4s;
		    color: white;
		    background: lightBlue;
		    cursor: pointer;
		    box-shadow: 0 2px 4px rgba(0, 79, 255, 0.6);
		}
	
		.btnArea #modBtn {
		
		    display: inline-block;
		    font-weight: 1000;
		    width: 110px;
		    height: 40px;
		    color: black;
		    background-color: white;
		    font-size: 13px;
		    border: none;
		    border-radius: 20px;
		    box-shadow: 0 4px 16px rgba(0, 79, 255, 0.3);
		}
	
		.btnArea #modBtn:focus { outline: 0; }
	
		.btnArea #modBtn:hover {
	
	    	animation-name: fadeIn;
	    	animation-duration: 0.4s;
		    color: white;
		    background: lightBlue;
		    cursor: pointer;
		    box-shadow: 0 2px 4px rgba(0, 79, 255, 0.6);
		}
	 	
	</style> 	
	 		
	<script type="text/javascript">
		
		/* 수정 버튼 눌렀을 떄 */ 
		function modPage() {
			
			var $form = $('#modifyForm');
			$form.attr('action','/member/modifyMember');
			$form.submit();
		}
	
	</script>
	
	<body>
	
		<!-- 게시판 수정화면을 가기 위한 form -->
		<form name="modifyForm" id="modifyForm" method="get">
			<input type="hidden" name="m_email" id="m_email" value="${vo1.m_email}" />
		</form>
	
		<div class="cont4_editor">
			<div style="width: 1000px; margin: 30px auto;" class=""> 
				
				<label>작성 아이디 : ${vo1.m_email} </label><br/>
				<label>대상 : <input type="text" value="${vo1.m_name}" readonly="readonly"/></label><br/>
				<label>제목 : <input type="text" value="${vo1.m_pw}" readonly="readonly"/></label><br/>
				<label>제목 : <input type="text" value="${vo1.m_phone}" readonly="readonly"/></label><br/>
				<label>제목 : <input type="text" value="${vo1.m_created_ate}" readonly="readonly"/></label><br/>
				<br>
				<div class="btnArea">
					<button type="button" class="listBtn" id="listBtn" onclick="javascript:history.back();">목록</button>
					<div class="space"></div>
					
					<c:if test="${vo1.m_email eq sessionUid}">
						<button type="button" class="modBtn" id="modBtn" onclick="modPage();">수정</button>
					</c:if>
				</div>
			</div>
		</div>
	</body>