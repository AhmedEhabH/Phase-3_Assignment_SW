import Control.ItemControl;
import Control.PostControl;
import Control.UserControl;
import DB.PostDB;
import Entity.ItemEntity;
import Entity.UserEntity;

import java.util.Scanner;

import static DB.UserDB.users;

public class Main {
    private UserControl user = new UserControl();
    private PostControl post = new PostControl();
    private ItemControl item = new ItemControl();
    private UserEntity userEntity = new UserEntity();
    private int choice;

    private void homePageMenu() {
        System.out.println("Enter 1 to registration");
        System.out.println("Enter 2 to log in");
        System.out.println("Enter 3 to exit");
        System.out.print("Enter your choice: ");
    }

    private void userMenu() {
        System.out.println("Enter 1 to add post");
        System.out.println("Enter 2 to modify post");
        System.out.println("Enter 3 to delete post");
        System.out.println("Enter 4 to search about post");
        System.out.println("Enter 5 to log out");
        System.out.print("Enter your choice: ");
    }

    private void homePageScenario() {
        String name;
        String email;
        String password;
        int phoneNumber;
        int age;
        while (true) {
            homePageMenu();
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("Registration Menu");
                System.out.println("Enter Name:\t");
                scanner = new Scanner(System.in);
                name = scanner.next();

                System.out.println("Enter Email:\t");
                scanner = new Scanner(System.in);
                email = scanner.next();

                System.out.println("Enter Password:\t");
                scanner = new Scanner(System.in);
                password = scanner.next();

                System.out.println("Enter Phone Number:\t");
                scanner = new Scanner(System.in);
                phoneNumber = scanner.nextInt();

                System.out.println("Enter Age:\t");
                scanner = new Scanner(System.in);
                age = scanner.nextInt();

                if (user.registration(name, email, password, phoneNumber, age)) {
                    userEntity = users.get(users.size() - 1);
                    System.out.println("Welcome user " + userEntity.getName() + " registration  done successfully :)");
                    break;
                } else {
                    System.out.println("Registration Failed :(");
                    System.out.println("You will back to home page");
                }
            } else if (choice == 2) {
                System.out.println("Log In Menu");

                System.out.println("Enter Email: ");
                scanner = new Scanner(System.in);
                email = scanner.next();

                System.out.println("Enter Password: ");
                scanner = new Scanner(System.in);
                password = scanner.next();

                if (user.logIn(email, password)) {
                    userEntity = users.get(users.size() - 1);
                    System.out.println("Welcome user " + userEntity.getName() + " Log In  done successfully :)");
                    break;
                } else {
                    System.out.println("Log In Failed :(");
                    System.out.println("You will back to home page");
                }

            } else if (choice == 3) {
                System.exit(1);
                break;
            }
        }
    }

    private void userScenario() {
        while (true) {
            userMenu();
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
            if (choice == 1) {
                System.out.print("Enter Post Description: ");
                scanner = new Scanner(System.in);
                String desc = scanner.nextLine();

                System.out.print("Enter Item name: ");
                scanner = new Scanner(System.in);
                String itemName = scanner.next();

                System.out.print("Enter Item description: ");
                scanner = new Scanner(System.in);
                String itemDesc = scanner.next();

                if (post.addPost(desc, new ItemEntity(itemName, itemDesc, userEntity.getUserId()), userEntity.getUserId()))
                    System.out.println("Post Added");
            } else if (choice == 2) {
                DB.PostDB.View(userEntity.getUserId());
                System.out.println("Enter Post ID you want to modify: ");
                scanner = new Scanner(System.in);
                int Postid = scanner.nextInt();
                post.modifyPost(Postid);

            } else if (choice == 3) {
                DB.PostDB.View(userEntity.getUserId());
                System.out.println("Enter Post ID you want to Delete: ");
                scanner = new Scanner(System.in);
                int Postid = scanner.nextInt();
                post.deletePost(Postid);
            }
            else if (choice == 4) {

                System.out.println("Enter Post ID you want more Detail about it: ");
                PostDB.ViewAll();
                scanner = new Scanner(System.in);
                int Postid = scanner.nextInt();
                DB.PostDB.SearchPost(Postid);
            }
            else if (choice == 5) {
                homePageScenario();
            }
            else {
                System.out.println("Please Enter number between 1 and 5");
            }
        }
    }

    public static void main(String[] args) {

        Main m = new Main();

        m.homePageScenario();
        m.userScenario();
    }
}