package post;

import java.sql.Date;
import lombok.Getter;
import lombok.Setter;

/**
 * Post DTO
 */
@Getter
@Setter
public class Post {
    private String title;
    private String writer;
    private String password;
    private Integer view;
    private String content;
    private Date created_at;
    private Date modified_at;

}
