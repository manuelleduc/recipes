<template>
  <div>
    <h2>{{ recipe.title }}</h2>
    <div v-if="recipe.description" v-html="recipe.description"></div>
    <div v-if="recipe.tags">
      Tags:
      <span v-for="(tag, tagidx) in recipe.tags" :key="`recipe-tag-${tag}`">
        {{ tag }}<span v-if="tagidx < recipe.tags.length-1">,</span>
      </span>
    </div>
    <button :disabled="deleting" @click="deleteRecipe">Supprimer</button>
  </div>
</template>
<script>
export default {
  name: 'Recipe',
  props: {
    recipe: {}
  },
  data: () => ({
    deleting: false
  }),
  methods: {
    async deleteRecipe() {
      this.deleting = true;
      await this.$store.dispatch('deleteRecipe', this.recipe.id)
      this.deleting = false
      this.deleteSuccess();
    }
  },
  notifications: {
    deleteSuccess: {
      'title': 'Recette supprimée',
      'message': 'La recette a bien été supprimée',
      'type': 'success'
    }
  }
}
</script>
