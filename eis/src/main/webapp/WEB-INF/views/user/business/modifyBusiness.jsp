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
	
		.btnArea #okBtn {
		
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
	
		.btnArea #okBtn:focus { outline: 0; }
	
		.btnArea #okBtn:hover {
	
	    	animation-name: fadeIn;
	    	animation-duration: 0.4s;
		    color: white;
		    background: lightBlue;
		    cursor: pointer;
		    box-shadow: 0 2px 4px rgba(0, 79, 255, 0.6);
		}
	 	
	</style> 	
	 		
	<body>
		<div class="cont4_editor">
			<div style="width: 1000px; margin: 30px auto;" class="">
				<form name="modifyForm" id="modifyForm" method="post" enctype="multipart/form-data">
					<input type="hidden" name="procFlag" id="procFlag" value="MOD">
					<input type="hidden" name="bNo" id="bNo" value="${rsltVO.bNo}">
					
					<label>작성 아이디 : ${rsltVO.mEmail}</label><br/>
					<label>대상 : <input type="text" name="bTarget" id="bTarget" value=" ${rsltVO.bTarget}"/></label><br/>
					<label>제목 : <input type="text" name="bTitle" id="bTitle" value="${rsltVO.bTitle}" /></label><br/>

					<!-- <textarea name="shContent" id="sharingModifyCk" style="width:100%; height:400px;"> -->

					<div class="my-box" style="overflow:auto; padding: 12px; border: 1px solid #dee2e6; border-radius: 5px; margin-top: 12px; height:400px;">
						<textarea name="bContent" id="bContent" style="width:100%; height:400px;"></textarea>
					</div>
					
					<br>
					<div class="btnArea">
						<button type="button" class="listBtn" id="listBtn" onclick="javascript:history.back();">이전</button>
						<div class="space"></div>
						<button type="button" class="ok_btn" id="okBtn" onclick="modifyManage();">등록</button>
					</div>
				</form>
			</div>
		</div>
	</body>