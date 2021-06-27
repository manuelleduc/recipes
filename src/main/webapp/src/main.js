import Vue from 'vue'
import App from './App.vue'
import VueResource from 'vue-resource';
import VueQuillEditor from 'vue-quill-editor'
import 'quill/dist/quill.core.css' // import styles
import 'quill/dist/quill.snow.css' // for snow theme
import 'quill/dist/quill.bubble.css' // for bubble theme
import InputTag from 'vue-input-tag'
import Vuex from 'vuex';
import VueNotifications from 'vue-notifications'
import miniToastr from 'mini-toastr';

const toastTypes = {
    success: 'success',
    error: 'error',
    info: 'info',
    warn: 'warn'
}

miniToastr.init({types: toastTypes})

function toast({title, message, type, timeout, cb}) {
    return miniToastr[type](message, title, timeout, cb)
}

Vue.use(VueNotifications, {
    success: toast,
    error: toast,
    info: toast,
    warn: toast
})

Vue.use(Vuex)

Vue.component('input-tag', InputTag)

Vue.use(VueQuillEditor, /* { default global options } */)


Vue.use(VueResource);

Vue.config.productionTip = false


const store = new Vuex.Store({
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
});

new Vue({
    render: h => h(App),
    store
}).$mount('#app')
