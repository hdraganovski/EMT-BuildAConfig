<template>
  <v-card>
    <v-img :src="category.imageUrl" height="200px" />
    <v-card-title>{{category.name}}</v-card-title>
  </v-card>
</template>

<script lang="ts">
import Vue, { PropOptions }  from "vue";
import { CategoryDto } from "~/models/models";

export default Vue.extend({
    name: "Category",
    props: {
        category: {
            type: Object,
            required: true,
        } as PropOptions<CategoryDto>
    }
});
</script>