<script setup>
  import { ref,onMounted } from 'vue'

  const count = ref(0);

  function increment() {
    count.value++
  };

  onMounted(() => {
    console.log('挂载完成')
  })
</script>

<template>
  <button @click="increment">count:{{ count }}</button>
</template>

<style scoped>

</style>

