package org.educa.examen.repository.inmemory;

import org.educa.examen.entity.Role;
import org.educa.examen.entity.User;
import org.educa.examen.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class InMemoryUserRepository implements UserRepository {

    private final Map<String, User> users = new HashMap<>();

    public InMemoryUserRepository() {
        Role roleAdmin = new Role("ROLE_ADMIN", "ADMIN", "Administrator");
        Role rolePersonal = new Role("ROLE_PERSONAL", "PERSONAL", "Personal");
        Role roleUser = new Role("ROLE_USER", "USER", "User");
        List<Role> rolesAdmin = new ArrayList<>();
        rolesAdmin.add(roleAdmin);
        List<Role> rolesPersonal = new ArrayList<>();
        rolesPersonal.add(rolePersonal);
        List<Role> rolesUser = new ArrayList<>();
        rolesUser.add(roleUser);

        // password: admin
        User admin = new User("admin", "x61Ey612Kl2gpFL56FT9weDnpSo4AV8j8-qx2AuTHdRyY036xxzTTrw10Wq3-4qQyB-XURPWx1ONxp3Y3pB37A==",
                "/3xVgovPrK9B00Zm8wOSYw==", "Admin", "Admin", "QmZ9jogxgME6YePL6ovTxg==", rolesAdmin);
        // password: personal
        User personal = new User("personal", "i9G870CeZml2au-aiLHn_YdSyYTjJy7Dod_sCIn_bPsUoaydoH02XJo1xeGgNLmc2NcHaaUcHn23J7tcVqQlWg==",
                "WhlePing0VuAcvF33YjxUA==", "Personal", "Personal", "hzz0LBacQ8PVA5v1TGwvlOu1V2Rwa6xuA51fYhuISmE=", rolesPersonal);
        // password: user
        User user = new User("user", "sUNhQEwHj_1UnAPbRDw_7eLz5TTXP3j3cwHtl9SkNqn9nbBe6LMlwK02Q4tD_shRDCBPwcHtsh0JQcAOniwc4g==",
                "4iwoBwOGgdD1Si7zO6rkVA==", "User", "User", "l5OjYI/MICrzlNEQ1H79Lg==", rolesUser);

        users.put(admin.getUsername(), admin);
        users.put(personal.getUsername(), personal);
        users.put(user.getUsername(), user);
    }

    @Override
    public User getUser(String username) {
        return users.get(username);
    }

    @Override
    public List<User> getUsers() {
        return new ArrayList<>(users.values());
    }

    @Override
    public void createUser(User user) {
        users.put(user.getUsername(), user);
    }

    @Override
    public void deleteUser(String username) {
        users.remove(username);
    }

    @Override
    public void updateUser(User user) {
        users.replace(user.getUsername(), user);
    }

    @Override
    public boolean existUser(String username) {
        return users.containsKey(username);
    }
}
