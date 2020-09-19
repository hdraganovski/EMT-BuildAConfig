<template>
  <v-card color="indigo darken-4">
    <v-img :src="product.imageUrls[0]" height="200px" />
    <v-card-title>{{product.title}}</v-card-title>
    <v-card-subtitle>{{product.price}}$</v-card-subtitle>
    <v-card-actions><v-btn text>Add to cart</v-btn></v-card-actions>
  </v-card>
</template>


<script lang="ts">
import Vue, { PropOptions } from "vue";
import { ProductDto } from "~/models/models";

export default Vue.extend({
  name: "Category",
  props: {
    product: {
      type: Object,
      required: true,
    } as PropOptions<ProductDto>,
  },
});
</script>