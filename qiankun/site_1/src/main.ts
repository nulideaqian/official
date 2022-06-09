import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import './public-path'

function render () {
  createApp(App).use(router).mount('#child1')
}

// 独立运行时
if (!(window as any).__POWERED_BY_QIANKUN__) {
  render()
}

export async function bootstrap () {
  console.log('[vue] vue app bootstraped')
}
export async function mount (props: any) {
  console.log('[vue] props from main framework', props)
  render()
}
export async function unmount () {
  console.log('unmount')
}
