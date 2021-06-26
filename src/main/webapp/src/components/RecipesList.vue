<template>
  <div>
    <Recipe v-for="recipe in recipes" :key="`recipe-${recipe.id}`" :recipe="recipe"/>
  </div>
</template>

<script>
import Recipe from "@/components/Recipe";
import {mapState} from 'vuex'

export default {
  name: "RecipesList",
  components: {Recipe},
  computed:
      mapState({
        recipes: (state) => state.recipes,
      })
}

</script>

