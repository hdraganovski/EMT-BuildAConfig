import { Plugin } from "@nuxt/types";

const plugin: Plugin = ({ $axios, store }) => {
  $axios.defaults.baseURL = "http://localhost:8080/";

  if (process.server) {
    return;
  }

  $axios.interceptors.request.use(request => {
    request.baseURL = "http://localhost:8080/";

    // Get token from auth.js store
    // @ts-ignore
    const token = store.state["auth"]["token"];

    // Update token axios header
    if (token) {
      request.headers.common["Authorization"] = token;
    }
    return request;
  });
};

export default plugin;
