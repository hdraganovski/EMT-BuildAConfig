<template>
  <div>{{productUid}}</div>
</template>

<script lang="ts">
import Vue from "vue";
export default Vue.extend({
  computed: {
    productUid() {
      return this.$route.params.productUid;
    },
  },
});
</script>