package post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostDAO {
    // DB 역할
    private Map<Integer, Post> db = new HashMap<>();
    //C
    public void insertPost(Post po){
        db.put(po.getPost_id(), po);
    }
    //R
    public Post selectPost(int num){
        return db.get(num);
    }

    public List<Post> selectPostAll(){
        return new ArrayList<Post>(db.values());
    }

    //U
    public void updatePost(Post po){
        db.put(po.getPost_id(),po);
    }

    //D
    public void deletePost(int num){
        db.remove(num);
    }
}
