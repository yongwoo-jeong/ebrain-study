package post;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostDAO {
    private JdbcConnectionUtil util;
    public PostDAO() {
        util = JdbcConnectionUtil.getInstance();
    }
    //C
    public void insertPost(Post po){
        StringBuffer query = new StringBuffer();
        query.append("INSERT INTO (post) ");
        query.append("(post_id,title,writer,password,content,created_at,category_id,file_id)");
        // value 는 jsp 페이지 form 에서 넘겨받아야함.
        query.append("values ()");
    }
    //R
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
                // 검색 or 전체 조회를 할 때 모든 내용을 조회할 필요 X
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
                        rs.getInt(9),
                        rs.getInt(10));
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
                rs.getInt(9),
                rs.getInt(10));
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
