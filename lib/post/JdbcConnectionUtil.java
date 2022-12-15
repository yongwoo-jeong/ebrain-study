package post;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * DB 연결/해제
 * 해주는 싱글톤 클래스
 * getInstance()를 통해서만 인스턴스 생성/반환 가능
 */
public class JdbcConnectionUtil {
    private static JdbcConnectionUtil instance;
    private String url = "jdbc:mariadb://localhost:3306/eb_bbs";
    private String user = "root";
    private String password = "1224";
    private JdbcConnectionUtil(){
    }

    /**
     * JdbcConnectionUtil 인스턴스 생성/반환하는 메서드
     * @return JdbcConnectionUtil 인스턴스를 리턴
     */
    public static JdbcConnectionUtil getInstance() {
        if(instance == null){
            instance = new JdbcConnectionUtil();
        }
        return instance;
    }

    /**
     * getInstance()를 통해 JdbcConnectionUtil 인스터스를 생성 후 사용
     * JDBC 연결 객체를 생성, 반환하는 메서드
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.mariadb.jdbc.Driver");
        return DriverManager.getConnection(url,user,password);
    }

    /**
     * ResultSet 종료
     * @param rs
     */
    public void close(ResultSet rs) {
    if(rs!=null){
        try {
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
            }
        }
    }

    /**
     * PreparedStatement 종료
     * @param pstmt
     */
    public void close(PreparedStatement pstmt) {
        if(pstmt!=null){
            try {
                pstmt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Connection 종료
     * @param conn
     */
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
