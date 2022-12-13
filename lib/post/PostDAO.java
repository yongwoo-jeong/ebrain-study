package post;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PostDAO {
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    /**
     *
     */
    public PostDAO(){
        try{
            String dbURL = "jdbc:mysql://localhost:3306/eb_bbs";
            String dbID = "root";
            String dbPassword = "1224";
            conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }




}
