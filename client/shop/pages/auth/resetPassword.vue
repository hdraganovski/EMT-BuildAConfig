<template>
  <section>
    <h1>Reset password</h1>
    <br />
    <v-form @submit.prevent="resetPassword()" v-model="isValid">
      <v-text-field v-model="form.email" :rules="[rules.required]" label="Email" filled rounded></v-text-field>
      <v-btn :disabled="!isValid" type="submit" color="primary" rounded block>Send link</v-btn>
      <br />
      <v-btn to="/auth/signup" color="white" text small rounded block>Dont have an account?</v-btn>
    </v-form>
  </section>
</template>

<script lang="ts">
import Vue, { PropOptions } from "vue";
import { required } from "~/utils/validationRules";

export default Vue.extend({
  layout: "auth",
  data() {
    return {
      form: {
        email: "",
      },
      isValid: false,
      rules: {
        required
      }
    };
  },
  methods: {
      resetPassword() {
          // TODO
      }
  },
});
</script>