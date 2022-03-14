package fr.mleduc.users;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.security.jpa.RolesValue;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Role extends PanacheEntity {
    @ManyToMany
    public List<User> users;
    @RolesValue
    public String role;
}
