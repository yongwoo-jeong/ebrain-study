package comment;

import JdbcConnectionUtil.JdbcConnectionUtil;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class CommentDAO {
    private JdbcConnectionUtil util;
    public CommentDAO() {util = JdbcConnectionUtil.getInstance();}

    public void insertComment(Comment co){
        {
            Connection conn = null;
            PreparedStatement pstmt = null;
            int result = 0;
            StringBuffer query = new StringBuffer();
            query.append("INSERT INTO comment ");
            query.append("(content, created_at, post_id)");
            query.append("values (?, ?, ?)");
            LocalDateTime currentDateTime = LocalDateTime.now();
            Date sqlDate = Date.valueOf(currentDateTime.toLocalDate());
            try{
                conn = util.getConnection();
                pstmt = conn.prepareStatement(query.toString());
                pstmt.setString(1, co.getContent());
                pstmt.setDate(2, sqlDate);
                pstmt.setInt(3, co.getPost_id());
                result = pstmt.executeUpdate();
                System.out.println(result+ "행이 삽입되었습니다.");

            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            } finally {
                util.close(pstmt);
                util.close(conn);
            }
        }

    }
}
