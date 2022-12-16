<%@ page import="post.Post" %>
<%@ page import="java.util.Objects" %>
<%@ page import="post.FindCategoryId" %>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page import="java.io.File" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="post.PostDAO" %>
<%@ page import="java.sql.Date" %>
Created by IntelliJ IDEA.
  User: jyw
  Date: 2022/12/15
  Time: 10:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String encType = "utf-8";
    int maxSize = 5*1024*1024;
    String uploadPath = request.getSession().getServletContext().getRealPath("/file");
    System.out.println(uploadPath);
    MultipartRequest multi;
        try{
            multi = new MultipartRequest(request, uploadPath, maxSize, encType,
                    new DefaultFileRenamePolicy());
            String category = multi.getParameter("category");
            String title = multi.getParameter("title");
            String writer = multi.getParameter("writer");
            String content = multi.getParameter("content");
            String password = multi.getParameter("password");
            String password_confirm = multi.getParameter("password_confirm");
            if (!Objects.equals(password, password_confirm)){
                // 비밀번호가 일치하지 않을 경우
                // 이전 페이지로 오류 안내 메세지와 함께 돌려보내기
                response.sendRedirect(request.getContextPath()+"/upload.jsp");
            }
            Integer category_id = new FindCategoryId().Main(category);
            Post po = new Post(null, title, writer, password, null, content, new Date(2014, 1,11) ,null, category_id);
            PostDAO pd = new PostDAO();
            pd.insertPost(po);

            Enumeration files = multi.getFileNames();
            while (files.hasMoreElements()){
                String param = (String) files.nextElement();
                String fileName = multi.getOriginalFileName(param);
                String filesystemName = multi.getFilesystemName(param);
                if(fileName == null) continue;

            }


        } catch (Exception e){
            e.printStackTrace();
        } finally {
            response.sendRedirect("/index.jsp");
        }




%>