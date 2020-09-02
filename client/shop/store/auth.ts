import { Module, VuexModule, Mutation, Action } from "vuex-module-decorators";
import { $axios } from "~/utils/api";

@Module({
  name: "auth",
  stateFactory: true,
  namespaced: true
})
export default class AuthModule extends VuexModule {
  loading: boolean = false;
  error?: any = undefined;

  @Mutation
  setLoading(loading: boolean) {
    this.loading = loading;
  }

  @Mutation
  setError(error?: any) {
    this.error = error;
  }

  @Action({ rawError: true })
  async logIn(request: LogInRequest) {
    this.setLoading(true);
    try {
      let response = await $axios.post("/login", request);
      $axios.setToken(response.headers["Authorization"]);
    } catch (error) {
      this.setError(error);
    } finally {
      this.setLoading(false);
    }
  }

  @Action
  async signUp(request: SignUpRequest) {
    this.setLoading(true);
    try {
      await $axios.post("/user", request);
    } catch (error) {
      this.setError(error);
    } finally {
      this.setLoading(false);
    }
  }

  @Action({ commit: "setToken" })
  async logOut() {
    $axios.setToken(false);
  }
}
