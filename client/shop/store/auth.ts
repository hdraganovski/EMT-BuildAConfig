import { Module, VuexModule, Mutation, Action } from "vuex-module-decorators";

@Module({
  name: "auth",
  stateFactory: true,
  namespaced: true
})
export default class AuthModule extends VuexModule {
  token?: string = "";

  @Mutation
  setToken(token?: string) {
    this.token = token;
  }

  @Action({commit: "setToken"})
  async logIn(request: LogInRequest) {
    console.log(request);
    return "token"
  }
}
