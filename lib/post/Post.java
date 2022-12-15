package post;

import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * Post DTO
 */
@Getter
@Setter
@AllArgsConstructor
public class Post {

    private Integer post_id;
    @NonNull
    private String title;
    @NonNull
    private String writer;
    @NonNull
    private String password;
    private Integer view;
    @NonNull
    private String content;
    @NonNull
    private Date created_at;
    private Date modified_at;
    @NonNull
    private Integer category_id;
    private Integer file_id;

    /**
     * postUploadAction 에서 필요한 인자만 받는 생성자
     * @param title
     * @param writer
     * @param password
     * @param content
     */
    public Post(String title, String writer, String password, String content) {
    }
}
