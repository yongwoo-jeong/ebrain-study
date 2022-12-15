<%@ page import="post.Post" %>
<%@ page import="java.util.Objects" %>
<%@ page import="post.FindCategoryId" %><%--
  Created by IntelliJ IDEA.
  User: jyw
  Date: 2022/12/15
  Time: 10:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    request.setCharacterEncoding("utf-8");

    String category = request.getParameter("category");
    String title = request.getParameter("title");
    String writer = request.getParameter("writer");
    String content = request.getParameter("content");
    String password = request.getParameter("password");
    String password_confirm = request.getParameter("password_confirm");

    if (!Objects.equals(password, password_confirm)){
//        다시 이전 페이지로 오류 안내 메세지와 함께 돌려보내기
        response.sendRedirect(request.getContextPath()+"/upload.jsp");

    }

    System.out.println(category);
    System.out.println(title);
    System.out.println(writer);
    System.out.println(content);
    System.out.println(password);

    Integer category_id = new FindCategoryId().Main(category);
    System.out.println(category_id);

    Post po = new Post(title, writer,password, content);

%>