import { Module, VuexModule, Mutation, Action } from "vuex-module-decorators";
import { $axios } from "~/utils/api";
import { UserDto } from "~/models/models";

@Module({
  name: "user",
  stateFactory: true,
  namespaced: true
})
export default class UserModule extends VuexModule {
  loading: boolean = false;
  error: any = null;
  self: UserDto | null = null;

  @Mutation
  setLoading(loading: boolean) {
    this.loading = loading;
  }

  @Mutation
  setError(error: any) {
    this.error = error;
  }

  @Mutation
  clearStore() {
      this.error = null;
      this.self = null;
      this.loading = false;
  }

  @Mutation
  setSelf(self: UserDto) {
      this.self = self
  }

  @Action
  async getSelf() {
    this.setLoading(true);
    try {
        let response: UserDto = await $axios.$get("/user/self");
        this.setSelf(response);
    } catch (error) {
      this.setError(error);
    } finally {
      this.setLoading(false);
    }
  }
}
