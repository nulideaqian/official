import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import { registerMicroApps, start } from 'qiankun'

createApp(App).use(router).mount('#app')

registerMicroApps([
  {
    name: 'child1',
    entry: '//localhost:8081',
    container: '#container',
    activeRule: '/child/child1'
  }
])

start()
