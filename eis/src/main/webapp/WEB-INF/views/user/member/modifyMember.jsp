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
	 		
	<script type="text/javascript">
	
		let letEditor;
		
		/* 수정 manage */
		function modifyManage() {
	
			if(confirm('저장하시겠습니까?')) {
				var editorValue = letEditor.getData();

				$('#sharingModifyCk').val(editorValue);
				
				$('#modifyForm').ajaxForm ({
					
					 url: "/user/member/updateMember"
					,enctype: "multipart/form-data"
					,beforeSubmit: function() {
						
					}
				
					,success: function(data) {
		
						location.href="/member/listMember.tiles";
					}
					
					,error: function(data) {
						//console.log(data);
					}
					
					,complete: function(data) {
						//
						
					}
				});
		
				$('#modifyForm').submit();
			}
		}
		
	</script>
	
	<body>
		<div class="cont4_editor">
			<div style="width: 1000px; margin: 30px auto;" class="">
				<form name="modifyForm" id="modifyForm" method="post" enctype="multipart/form-data">
					<input type="hidden" name="procFlag" id="procFlag" value="MOD">
					<input type="hidden" name="mEmail" id="email" value="${mVO.mEmail}">
					
					<label>작성 이름 : ${mVO.mEmail}  </label><br/>
					<label>이름 : <input type="text" name="mName" id="name" value=" ${mVO.mName}"/></label><br/>
					<label>비밀번호 : <input type="tel" name="mPw" id="pw" value=" ${mVO.mPw}"/></label><br/>
					<label>핸드폰 : <input type="tel" name="mPhone" id="phone" value=" ${mVO.mPhone}"/></label><br/>
					
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