package Control;

import Entity.ItemEntity;
import Entity.PostEntity;
import static DB.PostDB.posts;

import java.util.Scanner;

public class PostControl {


    public boolean addPost(String description, ItemEntity item,int userID)
    {
        try {
            PostEntity post = new PostEntity();
            post.setDesc(description);
            post.setItem(item);
            post.setPostID(posts.size());
            post.setUserId(userID);
            posts.add(post);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public boolean modifyPost(int postId)
    {
        if(postId >= posts.size()) return false;
        try {
            PostEntity post = posts.get(postId);
            System.out.println("Post Description");
            System.out.println(post.getDesc());
            System.out.println("======================");
            System.out.println("Enter new Description");
            Scanner scanner = new Scanner(System.in);
            post.setDesc(scanner.next());
            scanner.close();
            posts.add(postId, post);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deletePost(int postId)
    {
        if(postId >= posts.size()) return false;
        try {
            posts.remove(postId);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
}
