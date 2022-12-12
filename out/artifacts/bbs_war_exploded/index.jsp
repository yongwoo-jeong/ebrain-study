<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <%--<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
    <script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>--%>
      <link rel="stylesheet" href="./css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" href="index.css">
    <meta charset="UTF-8" />
    <title>게시판 목록</title>
  </head>
  <body>
    <div class="container">
      <div class="title"><h1>자유 게시판 - 목록</h1></div>
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
        <div class="post">
          <span>JAVA</span>
          <span></span>
          <span>OKKY 3월 세미나 서비스 개발자로 커리어 전환하기 by 와이즐..</span>
          <span>정용우</span>
          <span>12</span>
          <span>2022.04.08 16:32</span>
          <span>2022.04.08 16:40</span>
        </div>
      </div>
      <div class="pagination"></div>
    </div>
  </body>
</html>
