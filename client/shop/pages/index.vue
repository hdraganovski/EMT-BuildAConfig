<template>
  <v-layout column>
    <h1>Categories</h1>
    <div class="mgrid" v-if="!loading && !error">
      <Category v-for="c in categories" :key="c.id" :category="c"></Category>
    </div>
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

<script>
import Logo from "~/components/Logo.vue";
import VuetifyLogo from "~/components/VuetifyLogo.vue";
import Category from "~/components/Category.vue";
import ErrorView from "~/components/ErrorView.vue";
import { categoryStore } from "~/utils/store-accessor";

export default {
  components: {
    Logo,
    VuetifyLogo,
    Category,
    ErrorView,
  },
  computed: {
    categories() {
      return categoryStore.categories;
    },
    loading() {
      return categoryStore.loading;
    },
    error() {
      return categoryStore.error;
    },
  },
  methods: {
    retry() {
      categoryStore.fetchCategories();
    },
  },
};
</script>
