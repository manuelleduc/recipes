package fr.mleduc;

import javax.annotation.security.PermitAll;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import static javax.ws.rs.core.MediaType.TEXT_PLAIN;

@Path("/api/public")
public class PublicResource {

    @GET
    @PermitAll
    @Produces(TEXT_PLAIN)
    public String publicResource() {
        return "public";
    }
}
