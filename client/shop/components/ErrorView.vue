<template>
  <v-card>
    <v-card-title>{{message}}</v-card-title>
    <v-card-actions v-if="actionText">
        <v-btn @click="onAction" block color="error" dark>{{actionText}}</v-btn>
    </v-card-actions>
  </v-card>
</template>

<script lang="ts">
import Vue from "vue";
export default Vue.extend({
  name: "ErrorView",
  props: ["message", "actionText"],
  methods: {
      onAction() {
          this.$emit("action")
      }
  }
});
</script>
