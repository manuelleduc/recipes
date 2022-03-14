import {defineStore} from 'pinia'


/*
new Vuex.Store({
    state: {
        recipes: [],
        editingRecipe: undefined
    },
    mutations: {
        recipes(state, recipes) {
            state.recipes = recipes;
            state.editingRecipe = undefined;
        },
        setEditRecipe(state, recipeId) {
            state.editingRecipe = recipeId;
        },
    },
    actions: {
        getRecipes({commit}) {
            return Vue.http.get("/recipe")
                .then((res) => {
                    commit('recipes', res.data)
                })
        },
        deleteRecipe({dispatch}, id) {
            const recipesResource = Vue.resource('/recipe{/id}');
            return recipesResource.delete({id})
                .then(() => {
                    dispatch('getRecipes');
                })
        },
        createRecipe({dispatch}, recipe) {
            return Vue.http.post('/recipe', recipe).then(() => {
                dispatch('getRecipes')
            })
        },
        startEditRecipe({commit}, recipeId) {
            commit('setEditRecipe', recipeId);
        },
        cancelEditRecipe({commit}) {
            commit('setEditRecipe', undefined);
        },
        async updateRecipe({dispatch}, recipe) {
            await Vue.http.put('/recipe', recipe);
            dispatch('getRecipes')
        }
    }
})
 */
export const useRecipesStore = defineStore({
  id: 'recipes',
  state: () => ({
    recipes: [],
    editingRecipe: undefined
  }),
  getters: {},
  actions: {
    async createRecipe(recipe) {
      /*return Vue.http.post('/recipe', recipe).then(() => {
        dispatch('getRecipes')
      })*/
      return fetch('/recipe', {
        method: 'post',

      })
    }
  }
})
