<template>
  <div>{{category}}</div>
</template>

<script lang="ts">
import Vue from "vue";
import { productStore } from "~/utils/store-accessor";

export default Vue.extend({
  mounted() {
    productStore.getProductsForCategory(this.category);
  },
  computed: {
    category() {
      return this.$route.params.categoryName;
    },
  },
});
</script>