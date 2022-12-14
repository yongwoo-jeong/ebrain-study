package post;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcConnectionUtil {
    private static JdbcConnectionUtil instance;
    private String url = "jdbc:mariadb://localhost:3306/eb_bbs";
    private String user = "root";
    private String password = "1224";
    private JdbcConnectionUtil(){

    }

    public static JdbcConnectionUtil getInstance() {
        if(instance == null){
            instance = new JdbcConnectionUtil();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,user,password);
    }

    public void close(ResultSet rs) {
    if(rs!=null){
        try {
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
            }
        }
    }

    public void close(PreparedStatement pstmt) {
        if(pstmt!=null){
            try {
                pstmt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void close(Connection conn) {
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
