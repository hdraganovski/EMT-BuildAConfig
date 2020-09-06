<template>
  <v-app dark>
    <v-navigation-drawer app color="primary" expand-on-hover dark permanent>
      <v-list dense nav class="py-0">
        <v-list-item>
          <v-list-item-icon>
            <v-icon>mdi-anchor</v-icon>
          </v-list-item-icon>
          <v-list-item-content>
            <v-list-item-title>Build a config</v-list-item-title>
          </v-list-item-content>
        </v-list-item>

        <v-divider></v-divider>

        <v-list-item two-line class="px-0" v-if="self">
          <v-list-item-avatar>
            <img :src="self.imageUrl" />
          </v-list-item-avatar>

          <v-list-item-content>
            <v-list-item-title>{{self.fullName}}</v-list-item-title>
          </v-list-item-content>
        </v-list-item>

        <v-list-item v-else to="/auth/login" link>
          <v-list-item-icon>
            <v-icon>mdi-account</v-icon>
          </v-list-item-icon>
          <v-list-item-content>
            <v-list-item-title>Log in</v-list-item-title>
          </v-list-item-content>
        </v-list-item>

        <v-divider></v-divider>

        <v-list-item v-for="item in items" :key="item.title" link>
          <v-list-item-icon>
            <v-icon>{{ item.icon }}</v-icon>
          </v-list-item-icon>

          <v-list-item-content>
            <v-list-item-title>{{ item.title }}</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>
    <v-main>
      <v-container class="fill-height">
        <nuxt></nuxt>
      </v-container>
    </v-main>
  </v-app>
</template>

<script lang="ts">
import Vue from "vue";
import { UserDto } from "~/models/models";
import { authStore, userStore, notificationModule, categoryStore } from "~/utils/store-accessor";

export default Vue.extend({
  data() {
    return {
      items: [
        {
          icon: "mdi-apps",
          title: "Welcome",
          to: "/",
        },
        {
          icon: "mdi-chart-bubble",
          title: "Inspire",
          to: "/inspire",
        },
      ],
      title: "Vuetify.js",
    };
  },
  mounted() {
    categoryStore.fetchCategories()
  },
  computed: {
    self(): UserDto | null {
      return userStore.self;
    },
  },
  methods: {
    logOut() {
      authStore.logOut();
      userStore.clearStore();
    },
  },
});
</script>
