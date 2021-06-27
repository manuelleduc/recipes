package fr.mleduc.recipe.rest.model;

import fr.mleduc.recipe.db.model.RecipeEntity;

public class Recipe {
    private Long id;
    private String title;
    private String description;
    private String[] tags;

    public Recipe() {
    }

    public Recipe(String title, String description, String[] tags) {
        this.title = title;
        this.description = description;
        this.tags = tags;
    }

    public Recipe(RecipeEntity e) {
        this.id = e.id;
        this.title = e.title;
        this.description = e.description;
        this.tags = e.tags;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }
}
