<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<%--	<title>와이파이 정보 구하기</title>--%>
<%--	<link href="/res/css/main.css" rel="stylesheet"/>--%>
<%--	<script src="/res/js/index.js"></script>--%>


	<style>
		#customers {
			font-family: Arial, Helvetica, sans-serif;
			border-collapse: collapse;
			width: 100%;
		}

		#customers td, #customers th {
			border: 1px solid #ddd;
			padding: 8px;
		}

		#customers tr:nth-child(even){background-color: #f2f2f2;}

		#customers tr:hover {background-color: #ddd;}

		#customers th {
			padding-top: 12px;
			padding-bottom: 12px;
			text-align: left;
			background-color: #04AA6D;
			color: white;
		}
	</style>
</head>

<body>
	<h1 style="font-weight: bold">와이파이 정보 구하기</h1>
	<jsp:include page="inc_menu.jsp"/>

	<br>
    <form action="" method="get" class="form-example">
        <div class="form-example">
            <label for="lat">LAT: </label>
            <input type="text" placeholder="0.0" name="lat" id="lat" required>

            <label for="lnt">LNT: </label>
            <input type="text" placeholder="0.0" name="lnt" id="lnt" required>

			<button onclick="getUserLocation()">내 위치 가져오기</button>
<%--			<button onclick="getWifiInfo()">근처 WIFI정보 보기</button>--%>
            <input type="submit" value="근처 WIFI정보 보기">
        </div>
    </form>

	<br>




	<table id="customers">
		<tr>
			<th>거리(Km)</th>
			<th>관리번호</th>
			<th>자치구</th>
			<th>와이파이명</th>
			<th>도로명주소</th>
			<th>상세주소</th>
			<th>설치위치(층)</th>
			<th>설치유형</th>
			<th>설치기관</th>
			<th>서비스구분</th>
			<th>망종류</th>
			<th>설치년도</th>
			<th>실내외구분</th>
			<th>WIFI접속환경</th>
			<th>X좌표</th>
			<th>Y좌표</th>
			<th>작업일자</th>
		</tr>

		<tr>
			<td>Alfreds Futterkiste</td>
			<td>Maria Anders</td>
			<td>Germany</td>
		</tr>

	</table>



	<script>

		function getWifiInfo() {
			const lat = document.getElementById("lat").value;
			const lnt = document.getElementById("lnt").value;
			// 여기에서 latitude와 longitude를 이용하여 원하는 작업을 수행합니다.
			// 예를 들어, 넘겨받은 위도와 경도로 와이파이 정보를 검색하고 결과를 표시하는 등의 작업을 수행할 수 있습니다.
			alert("입력한 위도: " + lat + ", 입력한 경도: " + lnt);
		}

		function getUserLocation() {
			if (!navigator.geolocation) {
				throw "위치 정보가 지원되지 않습니다.";
			}
			navigator.geolocation.getCurrentPosition(showPosition);
		}

		function showPosition(position) {
			const lat = position.coords.latitude;
			const lnt = position.coords.longitude;
			document.getElementById("lat").value = lat;
			document.getElementById("lnt").value = lnt;
		}
	</script>



</body>
</html>