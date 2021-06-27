<template>
  <div v-if="!editingSelf">
    <h2>{{ recipe.title }}</h2>
    <div v-html="recipe.description"></div>
    <div v-if="recipe.tags">
      Tags:
      <span v-for="(tag, tagidx) in recipe.tags" :key="`recipe-tag-${tag}`">
        {{ tag }}<span v-if="tagidx < recipe.tags.length-1">,</span>
      </span>
    </div>
    <button :disabled="deleting || editingSome" @click="deleteRecipe">Supprimer</button>
    <button :disabled="editingSome" @click="modify">Modifier</button>
  </div>
  <div v-else>
    <h2><input type="text" v-model="title"></h2>
    <quill-editor v-model="description"/>
    <input-tag v-model="tags"/>
    <button :disabled="deleting" @click="deleteRecipe">Supprimer</button>
    <button @click="update">Sauvegarder</button>
    <button @click="cancel">Annuler</button>
  </div>
</template>
<script>
export default {
  name: 'Recipe',
  props: {
    recipe: undefined
  },
  data: () => ({
    deleting: false,
    editRecipe: {
      title: undefined,
      description: undefined,
      tags: undefined
    }
  }),
  computed: {
    editingSelf() {
      return this.$store.state.editingRecipe === this.recipe.id
    },
    editingSome() {
      return this.$store.state.editingRecipe !== undefined;
    },
    title: {
      get() {
        return this.editRecipe.title || this.recipe.title
      },
      set(title) {
        this.editRecipe.title = title;
      }
    },
    description: {
      get() {
        return this.editRecipe.description || this.recipe.description
      },
      set(description) {
        this.editRecipe.description = description;
      }
    },
    tags: {
      get() {
        return this.editRecipe.tags || this.recipe.tags
      },
      set(tags) {
        this.editRecipe.tags = tags;
      }
    }

  },
  methods: {
    async deleteRecipe() {
      this.deleting = true;
      await this.$store.dispatch('deleteRecipe', this.recipe.id)
      this.deleting = false
      this.deleteSuccess();
    },
    modify() {
      this.$store.dispatch('startEditRecipe', this.recipe.id)
    },
    update() {
      this.$store.dispatch('updateRecipe', {...this.editRecipe, ...{id: this.recipe.id}});
    },
    cancel() {
      this.$store.dispatch('cancelEditRecipe')
      this.editRecipe = {}
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
