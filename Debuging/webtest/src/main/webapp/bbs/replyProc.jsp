<%@ page contentType="text/html; charset=UTF-8" %> 
<%@ page import="java.util.*" %>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean class="bbs.BbsDAO" id="dao"/>
<jsp:useBean class="bbs.BbsDTO" id="dto"/>
<jsp:setProperty name="dto" property="*" />
<%
  Map map = new HashMap();
  map.put("grpno", dto.getGrpno());
  map.put("ansnum", dto.getAnsnum());
  
  dao.upAnsnum(map);
  boolean flag = dao.createReply(dto);
 
%>
<!DOCTYPE html> 
<html> 
<head>
  <title>게시판 답변</title>
  <meta charset="utf-8">
</head>
<body> 
<jsp:include page="/menu/top.jsp"/>
<div class="container">
<div class="well well-lg">
	<%
		if(flag){
			out.print("글 답변등록 성공 입니다.");
		}else{
			out.print("글 답변등록 실패입니다.");
		}
	%>
</div>
	<button class="btn" onclick="location.href='createForm.jsp'">게시글 등록</button>
	<button class="btn" onclick="location.href='list.jsp'">목록</button>
</div>
</body> 
</html> 
