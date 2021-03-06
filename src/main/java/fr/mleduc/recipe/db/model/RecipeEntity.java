package fr.mleduc.recipe.db.model;

import fr.mleduc.recipe.rest.model.Recipe;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;

@Entity
public class RecipeEntity extends PanacheEntity {
    public String title;
    public String description;
    public String[] tags;

    public RecipeEntity() {}

    public RecipeEntity(Recipe recipe) {
        this.id = recipe.getId();
        this.title = recipe.getTitle();
        this.description = recipe.getDescription();
        this.tags = recipe.getTags();
    }
}
