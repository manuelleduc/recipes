package fr.mleduc.resteasyjackson;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
public class RecipeService {
    @Inject
    EntityManager em;

    public Recipe[] getAll() {
        return em.createNamedQuery("Recipe.findAll", RecipeEntity.class)
                .getResultList()
                .stream()
                .map(Recipe::new)
                .toArray(Recipe[]::new);
    }

    @Transactional
    public void createRecipe(Recipe recipe) {
        RecipeEntity recipeEntity = new RecipeEntity(recipe);
        em.persist(recipeEntity);
    }
}
