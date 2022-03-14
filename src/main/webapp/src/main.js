import {createApp} from 'vue'
import {createPinia} from 'pinia'
import {quillEditor} from 'vue3-quill'
import App from './App.vue'

const app = createApp(App)

app.use(createPinia())
app.use(quillEditor)

app.mount('#app')
