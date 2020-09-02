<template>
  <section>
    <h1>Sign up</h1>
    <br />
    <v-form @submit.prevent="signUp()" v-model="isValid">
      <v-text-field v-model="form.email" :rules="[rules.required]" label="Email" filled rounded></v-text-field>
      <v-text-field
        v-model="form.fullName"
        :rules="[rules.required]"
        label="Full name"
        filled
        rounded
      ></v-text-field>
      <v-text-field
        v-model="form.password"
        :rules="[rules.required]"
        label="Password"
        filled
        rounded
      ></v-text-field>
      <v-text-field
        v-model="form.repeatPassword"
        :error-messages="passwordsMatch()"
        label="Repeat password"
        filled
        rounded
      ></v-text-field>
      <v-text-field v-model="form.imageUrl" label="Image" filled rounded></v-text-field>
      <v-btn :disabled="!isValid" type="submit" color="primary" rounded block>Sign up</v-btn>
      <br />
      <v-btn to="/auth/login" color="white" text small rounded block>Already have an account?</v-btn>
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
        repeatPassword: "",
        imageUrl: "",
        fullName: "",
      },
      isValid: false,
      rules: {
        required,
      },
    };
  },
  methods: {
    signUp() {
      authStore.signUp({
        email: this.form.email,
        password: this.form.password,
        fullName: this.form.fullName,
        imageUrl: this.form.imageUrl
      })
    },
    passwordsMatch(): string {
      return this.form.repeatPassword == this.form.password ? '':  "Passwords dont match"
    }
  },
});
</script>