<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${what} 등록 성공 페이지</title>
</head>
<body>
${what} 등록이 완료되었습니다. <br>
 <button type="button" onclick="windowClose()">창 닫기</button>
 
 <script type="text/javascript">
	 function windowClose(){
			opener.location.reload();
			self.close();   //자기자신창을 닫습니다.
		}
 </script>
</body>
</html>