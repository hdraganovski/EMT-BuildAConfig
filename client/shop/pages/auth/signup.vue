<template>
  <section>
    <h1>Sign up</h1>
    <v-form>
        <v-text-field></v-text-field>
        <v-text-field></v-text-field>
        <v-btn></v-btn>
    </v-form>
  </section>
</template>

<script lang="ts">
import { defineComponent } from "@vue/composition-api";

export default defineComponent({
  layout: "auth",
});
</script>