<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page trimDirectiveWhitespaces="true" %>
<c:set var="tt" value="<%=System.currentTimeMillis() %>"/>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
		<title><tiles:getAsString name="title" /></title>
	
        <!-- 구글폰트 사용 링크 -->
        <link href="https://fonts.googleapis.com/css2?family=Jua&family=Nanum+Pen+Script&family=Noto+Sans+KR&family=Patrick+Hand&
        family=Playfair+Display:wght@400;500&family=Poppins&family=Roboto:wght@900&family=Rubik+Microbe&family=Single+Day&display=swap" 
        rel="stylesheet">
	
		<!-- 모바일 웹 페이지 설정 -->
		<link rel="shortcut icon" href="/resources/img/common/icon.png" />
		<link rel="apple-touch-icon" href="/resources/img/common/icon.png" />
		
        <!-- 해당 템플릿을 사용하는 페이지는 jquery를 사용해야 되기 때문에 선언 -->
        <script type="text/javascript" src="/resources/js/common/jquery-3.6.2.min.js" ></script>
        <script src="/webjars/jquery-form/4.2.1/jquery.form.min.js"></script>
        
        <!-- 해당 템플릿을 사용하는 페이지는 bootstrap을 사용해야 되기 때문에 해당 공통 페이지에서 선언 -->
        <!-- bootstrap은 jquery 기반으로 만들어져서 jquery 먼저 선언후 그 다음 선언 -->
		<script src="/resources/dist/js/bootstrap.min.js"></script>
       	<link href="/resources/dist/css/bootstrap.min.css" rel="stylesheet">
        
        <link rel="stylesheet" href="/resources/css/eisLayout.css">
        
        <!-- 폰트어썸 사용 링크 -->
        <script src="https://kit.fontawesome.com/64a5181ca4.js" crossorigin="anonymous"></script>
		<link rel="stylesheet" type="text/css" media="screen" href="<c:url value="/css/bootstrap.min.css"/>">
		
		<!-- font Awesome -->
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
		
		<!-- slick slider css -->
		<link href="/js/common/slick_slider/slick-theme.css" rel="stylesheet">
		<link href="/js/common/slick_slider/slick.css" rel="stylesheet">
		
		<!-- css -->
		<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR&display=swap" rel="stylesheet">
		<link rel="stylesheet" type="text/css" media="screen" href="<c:url value="/css/your_style.css"/>">
		<link rel="stylesheet" type="text/css" media="screen" href="<c:url value="/css/header.css"/>">
		<link rel="stylesheet" type="text/css" media="screen" href="<c:url value="/css/main.css"/>">
		<link rel="stylesheet" type="text/css" media="screen" href="<c:url value="/webjars/jquery-ui/1.10.3/themes/base/jquery-ui.css"/>">
	
		<%-- <script src="<c:url value="/webjars/jquery/3.2.1/dist/jquery.min.js?v=${tt}"/>"></script> --%>
		<script src="<c:url value="/webjars/jquery/2.1.1/dist/jquery.min.js?v=${tt}"/>"></script>
	
		<script src="<c:url value="/webjars/jquery-validation/1.17.0/jquery.validate.min.js"/>"></script>
		<script src="<c:url value="/webjars/jquery-validation/1.17.0/additional-methods.min.js"/>"></script>
		<script src="<c:url value="/js/common/jquery-validation-localization/messages_ko.js"/>"></script>
		<script src="<c:url value="/webjars/jquery-ui/1.10.3/ui/minified/jquery-ui.min.js"/>"></script>
	
		<!-- BOOTSTRAP JS -->
	
		<script src="<c:url value="/js/bootstrap/bootstrap.min.js"/>"></script>
		<script src="<c:url value="/js/smartadmin/app.config.js"/>"></script>
		<script src="<c:url value="/js/smartadmin/app.min.js"/>"></script>
	
	
		<!-- slick slider -->
		<script src="/js/common//slick_slider/slick.min.js"></script>
	
		<!-- <script src="https://use.fontawesome.com/b0a00ed3b1.js"></script> -->
		<script src="<c:url value="/js/common/commonUtil.js?v=${tt}"/>"></script>
		<script src="<c:url value="/js/login/login.js?v=${tt}"/>"></script>
		<script src="<c:url value="/webjars/jquery-form/4.2.1/jquery.form.min.js"/>"></script>
	</head>
	<body class="menu-on-top">
		<tiles:insertAttribute name="header" />
	     
	     <!-- Begin page content -->
	     <section class="contentWrapper">
	    	<div class="content_wrap">
	    		<div class="page-header">
	    			<h1><tiles:insertAttribute name="title" /></h1>
	    		</div>
	    		<tiles:insertAttribute name="content" />
	    	</div>
	    </section>
	    
	    <div id="contentWrap">
        	<a href="" style="display: block;text-align: center; margin: 40px 0;">&nbsp;</a>	    
	    </div>
	
		<!-- footer -->
		<footer class="footerWraper">
		     <tiles:insertAttribute name="footer" />
		</footer>
	     <div class="overlay">
		    <div id="loading-img"></div>
		 </div>
	</body>
</html>