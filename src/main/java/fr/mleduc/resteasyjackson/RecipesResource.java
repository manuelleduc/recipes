package fr.mleduc.resteasyjackson;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/recipes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RecipesResource {

    @Inject
    RecipeService recipeService;

    @GET
    public Recipe[] get() {
        return recipeService.getAll();
    }

    @POST
    public void create(Recipe recipe) {
        recipeService.createRecipe(recipe);
    }
}
