<template>
  <div id="app">
    <RecipesList/>
    <NewRecipeForm/>
  </div>
</template>

<script>
import RecipesList from "@/components/RecipesList";
import NewRecipeForm from "@/components/NewRecipeForm";

export default {
  name: 'App',
  components: {
    NewRecipeForm,
    RecipesList
  },
  created() {
    this.$store.dispatch('getRecipes').then()
  }
}
</script>

<style>

</style>
