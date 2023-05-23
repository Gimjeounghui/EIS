<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="com.kun.eis.user.member.vo.MemberVO"%>

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
		
		$(function() {
		
		});
		
		/* ckEditor 현재 사용하지 않는 상태 */
		window.onload = function() {
			
			/* ck에디터 필수 스크립트 시작 */

			ClassicEditor
				.create(document.querySelector( '#sharingRegistCk' ), {
			    	language: 'ko',
			    	simpleUpload: {
	                    uploadUrl: "/ckImageUploadUtil/upload/image",
	                    withCredentials: true,
	                }
			    	
			  	})
	
			  	.then( newEditor => {
			
			  		letEditor = newEditor;
			  	})
			
			  	.catch( error => {
			
			  		console.error( error );
			  	});
	
			/* ck에디터 필수 스크립트 끝*/
		}; 
		
		/* 등록 manage */
		function registManage() {
			
			/*
			var sharingDetail = CKEDITOR.instances.editor.getData();
			$('#sharingDetail').val(sharingDetail);
			*/
	
			if(confirm('저장하시겠습니까?')) {
				// ck에디터로 적용된 textarea 값을 가져와서 세팅.

				var editorValue = letEditor.getData();

				$('#sharingRegistCk').val(editorValue);
				
				$('#registForm').ajaxForm ({
					
					 url: "/sharing/procManageSharing.json"
					,enctype: "multipart/form-data"
					,beforeSubmit: function() {
						
					}
				
					,success: function(data) {
		
						location.href="/business/listBusiness";
					}
					
					,error: function(data) {
						//console.log(data);
					}
					
					,complete: function(data) {

					}
				});
		
				$('#registForm').submit();
			}
		}
	
	</script>
	
	<body>
		<div class="cont4_editor">
			<div style="width: 1000px; margin: 30px auto;" class="">
				<form name="registForm" id="registForm" method="post" enctype="multipart/form-data">
					<input type="hidden" name="procFlag" id="procFlag" value="ADD">
 				
					<% 
					MemberVO rsltUserInfoVO = (MemberVO)session.getAttribute("vo");
					pageContext.setAttribute("userinfo", rsltUserInfoVO); 
					%>
	
					<!-- 아이디랑 작성자는 로그인 후 자동으로 나와야함 -->
					<c:choose>
						<c:when test="${empty userinfo}">
							<li><a style="color:#04a1a8; font-weight:bold; font-size:13px;">아이디정보 없음</a></li>
							<li><a style="color:#04a1a8; font-weight:bold; font-size:13px;">이름정보 없음</a></li>
					 	</c:when>
						<c:otherwise>
							<label>작성 아이디 : ${userinfo.mEmail} </label><br/>
						</c:otherwise>
					</c:choose>
					
 					<label>대상 : <input type="text" name="bTarget" id="bTarget" /></label><br/>
					<label>제목 : <input type="text" name="bTitle" id="bTitle" /></label><br/>
					<!-- <textarea name="shContent" id="sharingRegistCk" style="width:100%; height:400px;"></textarea> -->
					
					<div class="my-box" style="overflow:auto; padding: 12px; border: 1px solid #dee2e6; border-radius: 5px; margin-top: 12px; height:400px;">
						<textarea name="bContent" id="bContent" style="width:100%; height:400px;"></textarea>
					</div>
					
					<br>
					<div class="btnArea">
						<button type="button" class="listBtn" id="listBtn" onclick="javascript:history.back();">취소</button>
						<div class="space"></div>
						<button type="button" class="ok_btn" id="okBtn" onclick="registManage();">등록</button>
					</div>
				</form>
			</div>
		</div>
	</body>