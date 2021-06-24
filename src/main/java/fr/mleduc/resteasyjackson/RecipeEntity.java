package fr.mleduc.resteasyjackson;

import javax.persistence.*;

@NamedQuery(name = "Recipe.findAll",
        query = "SELECT r FROM RecipeEntity r ORDER BY r.title",
        hints = @QueryHint(name = "org.hibernate.cacheable", value = "true"))
@Entity
public class RecipeEntity {
    private String title;
    private Long id;

    public RecipeEntity() {

    }

    public RecipeEntity(Recipe recipe) {
        this.title = recipe.title;
    }

    @Id
    @SequenceGenerator(name = "recipeSeq", sequenceName = "recipe_id_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "recipeSeq")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
}
