<template>
  <v-data-footer
    :itemsPerPage="10"
    :itemsPerPageOptions="[10, 20, 30]"
    :options="{}"
    :pagination="{}"
  ></v-data-footer>
</template>

<script lang="ts">
import Vue from "vue";
import { PageRequest } from "~/models/models";

export default Vue.extend({
  computed: {
    pageQuery(): PageRequest {
      return {
        page:
          this.$route.query.page === undefined
            ? undefined
            : +this.$route.query.page,
        size:
          this.$route.query.size === undefined
            ? undefined
            : +this.$route.query.size,
        sort: this.$route.query.sort as string,
      };
    },
    pageNumber: {
      get() {
        return this.$route.query.page || 1;
      },
      set(value) {},
    },
  },
});
</script>