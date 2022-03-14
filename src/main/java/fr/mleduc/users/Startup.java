package fr.mleduc.users;

import io.quarkus.runtime.StartupEvent;

import javax.enterprise.event.Observes;
import javax.inject.Singleton;
import javax.transaction.Transactional;
import java.util.List;

@Singleton
public class Startup {
    @Transactional
    public void loadUsers(@Observes StartupEvent evt) {
        User.deleteAll();
        User.add("admin", "admin", List.of("admin", "user"));
        User.add("user", "user", List.of("user"));
    }
}
