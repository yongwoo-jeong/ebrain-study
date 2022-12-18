package comment;

import java.sql.Date;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class Comment {
    private Integer comment_id;
    @NonNull
    private String content;
    @NonNull
    private Date created_at;
    @NonNull
    private Integer post_id;

}
