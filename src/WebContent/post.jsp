<%@ page import="post.PostDAO" %>
<%@ page import="post.Post" %><%--
  Created by IntelliJ IDEA.
  User: jyw
  Date: 2022/12/14
  Time: 11:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String id = request.getParameter("id");
    PostDAO pd = new PostDAO();
    Post po = pd.selectPost(Integer.parseInt(id));
%>
<header class="header">게시판 - 보기</header>
<div>
    <div>
        <span><%=po.getWriter()%></span>
    </div>
    <div>
        <span>등록일시</span>
        <span><%=po.getCreated_at()%></span>
        <span><%=po.getModified_at()%></span>
    </div>
    <div>
        <div>
            <span><%=po.getCategory_id()%></span>
            <span><%=po.getTitle()%></span>
        </div>
        <div>
            <span>조회수: </span>
            <span><%=po.getView()%></span>
        </div>
    </div>
    <div>
        <p><%=po.getContent()%></p>
    </div>
    <div>
        <% if (po.getFile_id() == 0){%>
        <%} else {%>
        <a>첨부파일 있을경우 이름</a>
        <%}%>
    </div>
    <div class="comments_container">
<%--댓글 테스트 인스턴스 만들고 작성 --%>
    </div>
    <div class="button_set_container">
        <button>목록</button>
        <button>수정</button>
        <button>삭제</button>
    </div>


</div>

<%=po.getTitle()%>
</body>
</html>
