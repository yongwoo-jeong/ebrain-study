package post;

import java.util.Objects;

public class FindCategoryId {
    Integer category_id;
    public Integer Main(String category){
        if(Objects.equals(category,"JAVA")) {
            category_id = 2;
        } else if (Objects.equals(category,"Javascript")) {
            category_id = 3;
        } else {
            category_id = 4;
        }
        return category_id;
    }

}
