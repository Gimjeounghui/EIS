<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

	<!-- css 외부 분기 방법 : link를 따로 두어 media에 원하는 대상 작성. screen = 화면대상 -->
	<link rel="stylesheet" type="text/css" media="screen" href="/css/businessList.css">
	<style type="text/css">
	
		#writeBtn {
		
			width: 100px;
			height: 35px;
		
			/* 위치 */
			position: relative;
			left: 950px;
			top: 15px;
		
			/* 상자 디자인 큰틀 */
			margin-bottom: 30px;
			border: 0px;
			background-color: #E4EBF5;
		
			/* 그림자 */
			border-radius: 10px;
			box-shadow: .8rem .5rem 1.4rem #BEC5D0, -.3rem -.4rem .8rem #FBFBFB;
			/* box-shadow: -.2rem -.2rem 1.8rem white, .8rem .8rem 1.4rem  #AAB7CB; */
		
			/* 글씨 */
			color: #333333;
			font-size: 1.3em;
			font-weight: bold;
		
			animation-name: keybtn-language;
			animation-duration: .2s;
		}
	
	</style>
	
	<script type="text/javascript">
		
		$(function() {
	
		});
	
		function movePage(frmId, pageNo) {
		/* 게시판 페이지 이동 */
	
			var $frm = $('form[name=' + frmId + ']');
			$frm.find('#currentPageNo').val(pageNo);
			$frm.target = frmId;
			$frm.submit();
		}
	
		function moveDtlPage(frmId, actionUrl, contentId) {
		/* 게시판 상세조회 이동 */
	
			var $frm = $('#' + frmId);
	
			$frm.attr('action', actionUrl);
			$frm.find("#contentId").val(contentId);
			//console.log($frm);
			$frm.submit();
		}
	
		function movePageForAjax(frmId, pageNo, ajaxfn) {
		/* 게시판 페이지 이동 (ajax 방식으로 할때) */
	
			var $frm = $('form[name=' + frmId + ']');
	
			$frm.find('input[name=currentPageNo]').val(pageNo);
			eval(ajaxfn + '()');
		}
	
		function searchBtn() {
	
			var $form = $('#searchForm');
			$form.attr('action', '/business/listBusiness');
			$form.submit();
		}
	
		function businessRegist() {
		/* 글쓰기 버튼 눌렀을 때  */
			location.href = '/business/registBusiness';
		}
	
		function businessDetail(key) {
		/* 글 상세페이지로 이동 */
	
			$("#bNo").val(key);
	
			var $form = $('#detailForm');
			$form.attr('action', '/business/detailBusiness');
			$form.submit();
		}
	
	</script>
	<body>
		<section class="notice">
			<div class="page-title">
				<h3>영업목록</h3>
			</div>
	
			<!-- 게시판 검색 화면 -->
			<div id="board-search">
				<div class="container">
					<div class="search-window">
						<form name="searchForm" id="searchForm" method="get">
							<!-- 게시판필요요소 -->
	
							<!-- 현재 클릭한 페이지 넘버 -->
							<input type="hidden" name="currentPageNo" id="currentPageNo" value="${pagerMap['currentPageNo']}">
	
							<!-- 검색창 화면 -->
							<div class="search-wrap">
								<label for="search" class="blind">영업대상 검색</label> <input type="text" name="bTarget" id="search" placeholder="영업대상을 입력해주세요" value="${searchVO.bTarget}" />
								<button type="button" class="btn btn-dark" onclick="searchBtn();">검색</button>
							</div>
						</form>
					</div>
					<div>
						<input type="button" class="writeBtn" name="writeBtn" id="writeBtn" onclick="businessRegist();" value="글쓰기">
					</div>
				</div>
			</div>
	
			<!-- 게시판 상세화면을 가기 위한 form -->
			<form name="detailForm" id="detailForm" method="get">
				<input type="hidden" name="bNo" id="bNo" value="" />
			</form>
	
			<!-- 게시판 목록 화면 -->
			<div id="board-list">
				<div class="container">
					<table class="board-table">
						<thead>
							<tr>
								<th scope="col" class="th-num">번호</th>
								<th scope="col" class="th-title">대상</th>
								<th scope="col" class="th-name">제목</th>
								<th scope="col" class="th-id">작성아이디</th>
								<th scope="col" class="th-date">작성일</th>
							</tr>
						</thead>
						<tbody>
							<!-- fn:legth(item) = item이 배열이나 컬렉션이면 요소의 개수, 문자열이면 문자의 갯수 반환 -->
							<c:if test="${fn:length(listBusiness) == 0}">
								<td align="center" colspan="5">조회된 항목이없습니다.</td>
							</c:if>
	
							<c:forEach var="list" items="${listBusiness}">
								<!-- bNo 클릭 시 businessDetail로 가기 위한 코드 -->
								<tr onClick="businessDetail( '${list.bNo}' );"
									style="cursor: pointer;">
									<td>${list.bNo}</td>
									<td>${list.bTarget}</td>
									<td>${list.bTitle}</td>
									<td>${list.mEmail}</td>
									<td>${list.bUpdatedAte}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
	
			<br /> <br />
	
			<!-- 페이지 버튼 화면 -->
			<div class="page_wrap">
				<div class="page_nation">
					<!-- 페이지 리스트의 첫 페이지 번호가 1이 아닐때만 처음 버튼을 생성한다. -->
					<c:if test="${pagerMap['firstPageNoOnPageList'] ne 1}">
						<a class="arrow pprev" href="javascript:movePage('searchForm', 1)"></a>
					</c:if>
	
					<!-- 페이지 리스트의 첫 페이지 번호가 1이 아닐때만 이전 버튼을 생성한다. -->
					<c:if test="${pagerMap['firstPageNoOnPageList'] ne 1}">
						<a class="arrow prev"
							href="javascript:movePage('searchForm', ${pagerMap['prevPageNoOnPageList']})"></a>
					</c:if>
	
					<!-- 페이지리스트의 첫페이지 번호 begin, 페이지 리스트의 마지막 페이지 번호 end -->
					<c:forEach var="i" begin="${pagerMap['firstPageNoOnPageList']}"
						end="${pagerMap['lastPageNoOnPageList']}" step="1">
						<a href="javascript:movePage('searchForm', ${i})"
							class="<c:if test="${i == pagerMap['currentPageNo']}"> active </c:if>">${i}</a>
					</c:forEach>
	
					<!-- 마지막 페이지 번호가 총 페이지 개수 보다 작을 경우만 다음 버튼을 생성 한다. -->
					<c:if
						test="${pagerMap['lastPageNoOnPageList'] < pagerMap['totalPageCount']}">
						<a class="arrow next"
							href="javascript:movePage('searchForm', ${pagerMap['nextPageNoOnPageList']})"></a>
					</c:if>
	
					<!-- 마지막 페이지 번호가 총 페이지 개수 보다 작을 경우만 맨끝 버튼을 생성 한다. -->
					<c:if
						test="${pagerMap['lastPageNoOnPageList'] < pagerMap['totalPageCount']}">
						<a class="arrow nnext"
							href="javascript:movePage('searchForm',  ${pagerMap['totalPageCount']})"></a>
					</c:if>
				</div>
			</div>
		</section>
	</body>