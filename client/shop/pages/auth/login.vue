<template>
  <section>
    <h1>Log in</h1>
    <v-form @submit.prevent="logIn()" v-model="isValid">
      <v-text-field label="Email" :rules="requiredRules" v-model="form.email"></v-text-field>
      <v-text-field label="Password" type="password" :rules="requiredRules" v-model="form.password"></v-text-field>
      <v-btn type="submit" :disabled="!isValid">Log in</v-btn>
    </v-form>
    {{form}}
  </section>
</template>

<script lang="ts">
import Vue, { PropOptions } from "vue";
import { mapActions } from "vuex";
import { authStore } from "~/utils/store-accessor";

export default Vue.extend({
  name: "YourComponent",
  data() {
    return {
      form: {
        email: "a",
        password: "a",
      },
      isValid: false,
      requiredRules: [(v: any) => !!v || "Required"],
    };
  },
  methods: {
    logIn() {
      authStore.logIn({
        email: this.form.email,
        password: this.form.password,
      });
    },
  },
});
</script>