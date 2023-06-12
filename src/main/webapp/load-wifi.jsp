<%@ page import="seoulpublic.wifi.dto.TbPublicWifiInfo" %>
<%@ page import="seoulpublic.wifi.service.WifiApiComponent" %>
<%@ page import="step.step1.OpenApi" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>

<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>와이파이 정보 가져오기</title>
	<style>
		body {text-align: center}
	</style>
</head>
<body>
<%
	// JSON 응답을 문자열로 받은 후 ApiResponse 객체로 변환합니다.
	String json = OpenApi.get(1, 1);

//	OpenApi openApi = new OpenApi();
	// list_total_count 값을 얻어옵니다.
	TbPublicWifiInfo wifiInfo = WifiApiComponent.fromJson(json);
	int list_total_count = wifiInfo.getList_total_count();
%>
<h2><%= list_total_count %>개의 WIFI정보를 정상적으로 저장하였습니다.</h2>
<a href="/"> 홈 으로 가기 </a>





</body>
</html>