package fIle;

import java.sql.Blob;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FileDTO {
    private Integer file_uuid;
    private String name;
    private Blob blob;
}
