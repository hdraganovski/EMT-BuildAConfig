<template>
  <section>
    <h1>Log in</h1>
    <br />
    <v-form @submit.prevent="logIn()" v-model="isValid">
      <v-text-field v-model="form.email" :rules="[rules.required]" label="Email" filled rounded></v-text-field>
      <v-text-field
        v-model="form.password"
        :type="showPassword ? 'text' : 'password'"
        :append-icon="showPassword ? 'mdi-eye' : 'mdi-eye-off'"
        :rules="[rules.required]"
        @click:append="showPassword = !showPassword"
        label="Password"
        filled
        rounded
      ></v-text-field>
      <v-btn :disabled="!isValid" :loading="loading" type="submit" color="primary" rounded block>Log in</v-btn>
      <br />
      <v-btn to="/auth/resetPassword" color="white" text small rounded block>Forgot password?</v-btn>
      <v-btn to="/auth/signup" color="white" text small rounded block>Dont have an account?</v-btn>
    </v-form>
  </section>
</template>

<script lang="ts">
import Vue, { PropOptions } from "vue";
import { authStore } from "~/utils/store-accessor";
import { required } from "~/utils/validationRules";

export default Vue.extend({
  layout: "auth",
  name: "LogIn",
  data() {
    return {
      form: {
        email: "",
        password: "",
      },
      isValid: false,
      rules: {
        required,
      },
      showPassword: false,
    };
  },
  computed: {
    loading() {
      return authStore.loading;
    },
  },
  methods: {
    logIn() {
      authStore.logIn({
        username: this.form.email,
        password: this.form.password,
      });
    },
  }
});
</script>