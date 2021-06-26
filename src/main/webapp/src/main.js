import Vue from 'vue'
import App from './App.vue'
import VueResource from 'vue-resource';
import VueQuillEditor from 'vue-quill-editor'
import 'quill/dist/quill.core.css' // import styles
import 'quill/dist/quill.snow.css' // for snow theme
import 'quill/dist/quill.bubble.css' // for bubble theme
import InputTag from 'vue-input-tag'
import Vuex from 'vuex';

Vue.use(Vuex)

Vue.component('input-tag', InputTag)

Vue.use(VueQuillEditor, /* { default global options } */)


Vue.use(VueResource);

Vue.config.productionTip = false


const store = new Vuex.Store({
    state: {
        recipes: []
    },
    mutations: {
        recipes(state, recipes) {
            state.recipes = recipes;
        }
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
        }
    }
});

new Vue({
    render: h => h(App),
    store
}).$mount('#app')
