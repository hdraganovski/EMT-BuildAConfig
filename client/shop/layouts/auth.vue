<template>
  <v-app dark class="auth-app">
    <v-main>
      <v-container class="fill-height" fluid>
        <v-row align="center" justify="center">
          <v-col cols="12" sm="8" md="4">
            <nuxt></nuxt>
          </v-col>
        </v-row>
      </v-container>
    </v-main>

    <v-snackbar v-model="snackbar" :color="color" timeout="10000" top dark>{{error}}</v-snackbar>
  </v-app>
</template>

<script lang="ts">
import Vue from "vue";
import { authStore, userStore } from "~/utils/store-accessor";

export default Vue.extend({
  data() {
    return {
      snackbar: false,
      text: "",
      color: "error",
    };
  },
  computed: {
    loggedIn() {
      return authStore.loggedIn;
    },
    error() {
      return authStore.error;
    },
  },
  watch: {
    loggedIn(value) {
      if (value) {
        userStore.getSelf();
        this.$router.push("/");
      }
    },
    error(value) {
      console.log(value)
      this.snackbar = true;
    },
  },
});
</script>

<style lang="scss" scoped>
.auth-app {
  background: rgb(0, 28, 119);
  background: linear-gradient(-45deg, rgb(0, 34, 146), rgb(0, 100, 146));
  background-size: 400% 400%;
  -webkit-animation: gradientBG 20s ease-in-out infinite;
  animation: gradientBG 20s ease-in-out infinite;
}

@-webkit-keyframes gradientBG {
  0% {
    background-position: 0% 50%;
  }
  50% {
    background-position: 100% 50%;
  }
  100% {
    background-position: 0% 50%;
  }
}

@keyframes gradientBG {
  0% {
    background-position: 0% 50%;
  }
  50% {
    background-position: 100% 50%;
  }
  100% {
    background-position: 0% 50%;
  }
}
</style>