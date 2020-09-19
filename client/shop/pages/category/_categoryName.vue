<template>
  <v-layout column class="mpage">
    <h1 class="mheader">{{category}}</h1>
    <template v-if="!loading && !error">
      <div class="mgrid">
        <ProductListItem
          v-for="product in products"
          :key="product.id"
          :product="product"
          @click.native="onProductClick"
        ></ProductListItem>
        <div>.</div>
        <div>.</div>
        <div>.</div>
        <div>.</div>
        <div>.</div>
        <div>.</div>
        <div>.</div>
        <div>.</div>
        <div>.</div>
      </div>
      <Paging></Paging>
    </template>
    <div v-if="loading">
      <v-row align="center" justify="center">
        <v-progress-circular indeterminate color="primary"></v-progress-circular>
      </v-row>
    </div>
    <div v-if="!loading && error">
      <v-row align="center" justify="center">
        <v-col cols="12" sm="8" md="4">
          <ErrorView :message="error" actionText="Retry" @action="retry()"></ErrorView>
        </v-col>
      </v-row>
    </div>
  </v-layout>
</template>

<script lang="ts">
import Vue from "vue";
import { Pagable, Page, PageRequest, ProductDto } from "~/models/models";
import { productStore } from "~/utils/store-accessor";
import ProductListItem from "~/components/ProductListItem.vue";
import Paging from "~/components/Paging.vue";

export default Vue.extend({
  components: {
    ProductListItem, Paging
  },
  mounted() {
    this.getProducts();
  },
  computed: {
    loading() {
      return productStore.loading;
    },
    error() {
      return productStore.error;
    },
    category() {
      return this.$route.params.categoryName;
    },
    productPage(): Page<ProductDto> | null {
      return productStore.products;
    },
    products(): ProductDto[] {
      return this.productPage !== null ? this.productPage.content : [];
    },
  },
  watch: {
    category(val: string) {
      this.getProducts();
    },
  },
  methods: {
    getProducts() {
      productStore.getProductsForCategory(this.category);
    },
    onProductClick(product: ProductDto) {
      console.log(product);
    },
  },
});
</script>