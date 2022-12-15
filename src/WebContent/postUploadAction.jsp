<%@ page import="post.Post" %>
<%@ page import="java.util.Objects" %>
<%@ page import="post.FindCategoryId" %>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %><%--
  Created by IntelliJ IDEA.
  User: jyw
  Date: 2022/12/15
  Time: 10:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    System.out.println(request.getContextPath());
    String encType = "utf-8";
    int maxSize = 5*1024*1024;
    String realFolder = "/Users/jyw/Desktop/project/java/bbs/src/file";
    MultipartRequest multi;
        try{
            multi = new MultipartRequest(request, realFolder, maxSize, encType,
                    new DefaultFileRenamePolicy());
            String category = multi.getParameter("category");
            String title = multi.getParameter("title");
            String writer = multi.getParameter("writer");
            String content = multi.getParameter("content");
            String password = multi.getParameter("password");
            String password_confirm = multi.getParameter("password_confirm");

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
        } catch (Exception e){
            e.printStackTrace();
        }


%>