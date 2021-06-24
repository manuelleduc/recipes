<template>
  <div>
    <div v-for="(recipe, idx) in recipes" :key="`recipe-${idx}`">
      {{ recipe.title }}
    </div>
  </div>
</template>

<script>
export default {
  name: "RecipesList",
  data: () => ({
    recipes: []
  }),
  created() {
    this.$http.get("/recipes")
        .then((res) => {
          this.recipes = res.data;
        })
  }
}
</script>

<style scoped>

</style>