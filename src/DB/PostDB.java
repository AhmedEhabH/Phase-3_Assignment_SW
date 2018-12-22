package DB;

import Entity.PostEntity;

import java.util.Vector;

public class PostDB {
    public static Vector<PostEntity> posts = new Vector<PostEntity>();

    public static void View() {
        for (PostEntity Post : posts) {
            System.out.print("Post ID: ");
            System.out.println(Post.getPostID());

            System.out.print("Post Description: ");
            System.out.println(Post.getDesc());

            System.out.print("Item ID: ");
            System.out.println(Post.getItem().getItemId());

            System.out.print("Item Name: ");
            System.out.println(Post.getItem().getName());

            System.out.print("Item Description: ");
            System.out.println(Post.getItem().getDesc());
        }
    }
    public static void View(int userID) {
        for (PostEntity Post : posts) {
            if(Post.getUserId()==userID) {
                System.out.print("Post ID: ");
                System.out.println(Post.getPostID());

                System.out.print("Post Description: ");
                System.out.println(Post.getDesc());

                System.out.print("Item ID: ");
                System.out.println(Post.getItem().getItemId());

                System.out.print("Item Name: ");
                System.out.println(Post.getItem().getName());

                System.out.print("Item Description: ");
                System.out.println(Post.getItem().getDesc());
            }
        }
    }
    public static void Viewspecifiec(int postid) {
        for (PostEntity Post : posts) {
            if(Post.getPostID()==postid) {
                System.out.print("Post ID: ");
                System.out.println(Post.getPostID());

                System.out.print("Post Description: ");
                System.out.println(Post.getDesc());

                System.out.print("Item ID: ");
                System.out.println(Post.getItem().getItemId());

                System.out.print("Item Name: ");
                System.out.println(Post.getItem().getName());

                System.out.print("Item Description: ");
                System.out.println(Post.getItem().getDesc());
            }
        }
    }
    public static void ViewAll()
    {
        PostEntity post;
        for (int i=0;i<posts.size();i++)
        {
            //System.out.println("the All Postes , select a specific ID for your post: ");
            System.out.println("ID= "+ i +":"+posts.get(i).getDesc() );
        }
    }
    public static void SearchPost(int PostID)
    {
        System.out.println("THe Post:> "+ posts.get(PostID).getDesc());
    }
    public static void DeletePost(int PostID)
    {

    }
}
