package post;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * POST(게시글) CRUD를 위해 DB에 접근하는 클래스
 */
public class PostDAO {
    private JdbcConnectionUtil util;
    public PostDAO() {
        util = JdbcConnectionUtil.getInstance();
    }
    //C
    public void insertPost(Post po){
        Connection conn = null;
        PreparedStatement pstmt = null;
        int result = 0;
        StringBuffer query = new StringBuffer();
        query.append("INSERT INTO post ");
        query.append("(title,writer,password,view,content,created_at,category_id)");
        query.append("values (?, ?, ?, ?, ?, ?)");
        LocalDateTime currentDateTime = LocalDateTime.now();
        Date sqlDate = Date.valueOf(currentDateTime.toLocalDate());
        try{
            conn = util.getConnection();
            pstmt = conn.prepareStatement(query.toString());
            pstmt.setString(1, po.getTitle());
            pstmt.setString(2, po.getWriter());
            pstmt.setString(3, po.getPassword());
            pstmt.setInt(4, 0); // view starts from 0
            pstmt.setString(5, po.getContent());
            pstmt.setDate(6, sqlDate);
            pstmt.setInt(7,po.getCategory_id());

            result = pstmt.executeUpdate();
            System.out.println(result+ "행이 삽입되었습니다.");

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            util.close(pstmt);
            util.close(conn);
        }
    }


    public Post selectPost(int num){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Post po = null;
        try{
            conn = util.getConnection();
            String selectAllQuery = "SELECT * FROM post ";
            pstmt = conn.prepareStatement(selectAllQuery);
            rs = pstmt.executeQuery();
            if(rs.next()){
                // 일단 AllArgsConstructor 구현했기 때문에 아래처럼 전부 인스턴스에 삽입
                po = new Post(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getDate(7),
                        rs.getDate(8),
                        rs.getInt(9));
            }
        } catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            util.close(rs);
            util.close(pstmt);
            util.close(conn);
        }
        return po;
    }

    // 검색기능은 좀있다가 구현
    // where 문에 ? param 통해 구현하면 될 것같다.
    // 관건은 날짜 && category && 단어 포함 내용을 검색하는 방법을 어떻게 구현할지

    /**
     * "SELECT * FROM post" 쿼리문을 통해 통해 POST 테이블 전체 조회하는 메소드
     * @return PostVO 로 구성된 List 반환
     */
    public List<Post> selectPostAll() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Post> result = new ArrayList<>();
        try{
            conn = util.getConnection();
            String selectAllQuery = "SELECT * FROM post";
            pstmt = conn.prepareStatement(selectAllQuery);
            rs = pstmt.executeQuery();
            while (rs.next()){
                // 검색 or 전체 조회를 할 때 모든 내용을 조회할 필요 X
                // 일단 AllArgsConstructor 구현했기 때문에 아래처럼 전부 인스턴스에 삽입
                Post po = new Post(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getInt(5),
                rs.getString(6),
                rs.getDate(7),
                rs.getDate(8),
                rs.getInt(9));
                result.add(po);
            }
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        } finally {
            util.close(rs);
            util.close(pstmt);
            util.close(conn);
        }
        return result;
    }

    //U
//    public void updatePost(Post po){
//        db.put(po.getPost_id(),po);
//    }
//
//    //D
//    public void deletePost(int num){
//        db.remove(num);
//    }
}
