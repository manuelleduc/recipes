package fr.mleduc.recipe.service;

import fr.mleduc.recipe.db.model.RecipeEntity;
import fr.mleduc.recipe.rest.model.Recipe;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class RecipeService {

    public List<Recipe> getAll() {
        return RecipeEntity.<RecipeEntity>listAll().stream().map(Recipe::new).collect(Collectors.toList());
    }

    @Transactional
    public void createRecipe(Recipe recipe) {
        RecipeEntity recipeEntity = new RecipeEntity(recipe);
        recipeEntity.id = null;
        recipeEntity.persist();
    }

    @Transactional
    public void delete(Long id) {
        RecipeEntity.findById(id).delete();
    }

    @Transactional
    public void updateRecipe(Recipe recipe) {
        RecipeEntity entity = RecipeEntity.findById(recipe.getId());
        entity.tags = recipe.getTags();
        entity.title = recipe.getTitle();
        entity.description = recipe.getDescription();
        entity.persist();
    }
}
