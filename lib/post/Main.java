//package post;
//
//import java.sql.Date;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.ArrayList;
//import java.util.List;
//
//public class Main {
//
//    public static void main(String[] args) {
//        PostDAO postDAO = new PostDAO();
//
//        //Create
//        Date currentDateTime = Date.valueOf(
//                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
//        Post po1 = new Post(2, "TEST2", "TEST2","1234",0,"test content", currentDateTime, null, 1,null
//        );
//        postDAO.insertPost(po1);
//
//        //Read
//        List<Post> ls = new ArrayList<>(postDAO.selectPostAll());
//        for(Post tmp : ls){
//            System.out.println(tmp);
//        }
//        System.out.println("전체조회완료");
//
//        Post po = null;
//        po = postDAO.selectPost(2);
//        System.out.println(po);
//        System.out.println("조회완료");
//
//        //Update
//        po = postDAO.selectPost(2);
//        System.out.println(po);
//        if(po!=null){
//            po.setPassword("4321");
//            po.setTitle("Changed test title");
//            postDAO.updatePost(po);
//            po = postDAO.selectPost(2);
//            System.out.println(po);
//            System.out.println("수정완료");
//        }
//
//        //Delete
//        postDAO.deletePost(2);
//        ls = new ArrayList<>(postDAO.selectPostAll());
//        for(Post tmp : ls){
//            System.out.println(tmp);
//        }
//        System.out.println("전체조회완료");
//    }
//
//}
