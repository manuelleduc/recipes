<template>
  <div>
    <label>
      Titre: <input type="text" v-model="title">
    </label>
    Description:
    <quill-editor v-model="description"/>
    Tags:
    <input-tag v-model="tags"/>
    <button :disabled="!canSubmit" @click="save">Enregistrer</button>
  </div>
</template>

<script>

function initialState() {
  return {
    title: undefined,
    description: undefined,
    tags: undefined,
    sending: false
  }
}

export default {
  name: "NewRecipeForm",
  data: () => initialState(),
  computed: {
    canSubmit() {
      return this.title && this.description && !this.sending;
    }
  },
  methods: {
    async save() {
      this.sending = true;
      await this.$store.dispatch('createRecipe', {
        title: this.title,
        description: this.description,
        tags: this.tags
      })
      this.saveSuccess();
      Object.assign(this.$data, initialState());
    }
  },
  notifications: {
    saveSuccess: {
      'title': 'Recette sauvegardée',
      'message': 'La recette a bien été sauvegardée',
      'type': 'success'
    }
  }
}
</script>

<style scoped>

</style>