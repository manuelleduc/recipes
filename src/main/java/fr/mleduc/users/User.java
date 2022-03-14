package fr.mleduc.users;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.security.jpa.Password;
import io.quarkus.security.jpa.Roles;
import io.quarkus.security.jpa.UserDefinition;
import io.quarkus.security.jpa.Username;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static io.quarkus.elytron.security.common.BcryptUtil.bcryptHash;

@Entity
@Table(name = "test_user")
@UserDefinition
public class User extends PanacheEntity {
    @Username
    public String username;
    @Password
    public String password;
    @ManyToMany
    @Roles
    public List<Role> roles = new ArrayList<>();

    /**
     * Adds a new user in the database
     *
     * @param username the user name
     * @param password the unencrypted password (it will be encrypted with bcrypt)
     * @param roles    the comma-separated roles
     */
    public static void add(String username, String password, List<String> roles) {
        User user = new User();
        user.username = username;
        user.password = bcryptHash(password);
        user.roles = roles.stream().map(role -> {
            final Role r = new Role();
            r.role = role;
            r.persist();
            return r;
        }).collect(Collectors.toList());
        user.persist();
    }
}
