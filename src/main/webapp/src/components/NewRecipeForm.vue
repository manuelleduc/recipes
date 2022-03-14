<script>
export default {
  name: 'NewRecipeForm'
}
</script>

<script setup>
import {VueTagsInput} from '@sipec/vue3-tags-input'
import {computed, ref} from "vue";
import {useRecipesStore} from "../stores/recipes";

const title = ref("")
const description = ref("")
const tags = ref([])
const sending = ref(false)
const recipeStore = useRecipesStore();

const canSubmit = computed(() => {
  console.debug('>>>...', title.value !== '', description.value !== '', sending.value)
  let b = title.value !== '' && description.value !== '' && !sending.value;
  console.log(b)
  return b
})

async function save() {
  sending.value = true;
  await recipeStore.createRecipe({title, description, "tags": tags});
  // TODO: notify success
  // Raz form
  title.value = ""
  description.value = ""
  tags.value = []
  sending.value = false
}
</script>

<template>
  <div>
    <label>
      Titre: <input type="text" v-model="title">
    </label>
    Description:
    <!-- TODO: this binding is wrong, don't work in the computed-->
    <quill-editor v-model="description"/>
    Tags:
    <vue-tags-input v-model="tags"/>
    <button :disabled="!canSubmit" @click="save">Enregistrer</button>
  </div>
</template>

<style scoped>

</style>