<%@ page import="java.sql.DriverManager" %>
<%@ page import="post.Post" %>
<%@ page import="post.PostDAO" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <%--<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
    <script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>--%>
    <link rel="stylesheet" href="css/index.css">
    <meta charset="UTF-8" />
    <title>게시판 - 목록</title>
  </head>
  <body>
    <div class="container">
      <header class="title"><h1>자유 게시판 - 목록</h1></header>
      <div class="search_nav">
        <%-- 날짜 박스 구현 --%>
          <div class="date_select_div">
            <span>등록일</span>
          </div>
          <div class="category_select_div">
            <div class="category_drop_down">
              <form action="" method="post">
                <label for="category"></label>
                <select name="category" id="category">
                  <option>전체 카테고리</option>
                  <option value="JAVA">JAVA</option>
                  <option value="Javascript">Javascript</option>
                  <option value="Database">Database</option>
                </select>
              </form>
            </div>
          </div>
          <div class="search_input_div">
            <div>
              <label>
                <input type="text" placeholder="검색어를 입력해주세요. (제목 + 작성자 + 내용)" />
              </label></div>
              <input class="button" type="button" value="검색" />
          </div>
      </div>
      <div class="search_outcome">총 512건</div>
      <div class="post_container">
        <div class="post_outline">
          <span>카테고리</span>
          <span></span>
          <span>제목</span>
          <span>작성자</span>
          <span>조회수</span>
          <span>등록일시</span>
          <span>수정일시</span>
        </div>
<%--        <%--%>
<%--          PostDAO pd = new PostDAO();--%>
<%--          List<Post> ls = pd.selectPostAll();--%>
<%--          for(Post po : ls) { %>--%>
<%--          <div class="post">--%>
<%--            <span><%=po.getCategory_id()%>></span>--%>
<%--            <span>파일여부</span>--%>
<%--            <span><%=po.getTitle()%></span>--%>
<%--            <span><%=po.getWriter()%></span>--%>
<%--            <span><%=po.getView()%></span>--%>
<%--            <span><%=po.getCreated_at()%></span>--%>
<%--            <span></span>--%>
<%--          </div>--%>
<%--        <% } %>--%>
      </div>
      <div class="pagination"></div>
      <button type="button" onclick="location.href='upload.jsp'">등록</button>
    </div>
  </body>
</html>
