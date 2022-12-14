package post;

import java.sql.Date;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * Post DTO
 */
@Getter
@Setter
@RequiredArgsConstructor
public class Post {
    @NonNull
    private Integer post_id;
    @NonNull
    private String title;
    @NonNull
    private String writer;
    @NonNull
    private String password;
    @NonNull
    private Integer view;
    @NonNull
    private String content;
    @NonNull
    private Date created_at;
    private Date modified_at;

}
