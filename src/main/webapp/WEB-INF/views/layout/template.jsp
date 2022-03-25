<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- tiles 관련 태그를 제공하는 태그 라이브러리 포함 --%>    
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hell's Java</title>

</head>
<body>
	<div id="header">
		<%-- insertAttribute 태그 : Tiles Configuration File의 put-attribute 엘리먼트로 설정한 
		JSP 문서의 실행결과를 삽입하는 태그 --%>
		<%-- name 속성 : put-attribute 엘리먼트의 식별자를 속성값으로 설정 --%>
		<tiles:insertAttribute name="header"/>
	</div>
	
	<div id="content">
		<tiles:insertAttribute name="content"/>
	</div>

	<div id="footer">
		<tiles:insertAttribute name="footer"/>
	</div>
</body>
</html>