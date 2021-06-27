package fr.mleduc.recipe.resource;

import fr.mleduc.recipe.rest.model.Recipe;
import fr.mleduc.recipe.service.RecipeService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/recipe")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RecipesResource {

    @Inject
    RecipeService recipeService;

    @GET
    public List<Recipe> get() {
        return recipeService.getAll();
    }

    @POST
    public void create(Recipe recipe) {
        recipeService.createRecipe(recipe);
    }

    @PUT
    public void update(Recipe recipe) {
        recipeService.updateRecipe(recipe);
    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") Long id) {
        recipeService.delete(id);
    }
}
