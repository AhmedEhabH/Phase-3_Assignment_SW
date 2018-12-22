package Control;

import Entity.UserEntity;
import static DB.UserDB.users;

public class UserControl {


    public boolean logIn(String email, String password) {
        if (!users.isEmpty()) {
            for (UserEntity user : users) {
                if (user.getEmail().equals(email) && user.getPassword().equals(password)) return true;
            }
        }
        return false;
    }

    public boolean registration(String name, String email, String password, int phoneNumber, int age)
    {
        try {
            UserEntity user = new UserEntity();
            user.setName(name);
            user.setEmail(email);
            user.setPassword(password);
            user.setPhoneNumber(phoneNumber);
            user.setAge(age);
            user.setUserId(users.size());
            users.add(user);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
}
