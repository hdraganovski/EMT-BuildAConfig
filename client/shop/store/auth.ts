import { Module, VuexModule, Mutation, Action } from "vuex-module-decorators";
import { $axios } from "~/utils/api";
import { notificationModule } from "~/utils/store-accessor";
import { NotificationType } from "~/models/enums";
@Module({
  name: "auth",
  stateFactory: true,
  namespaced: true
})
export default class AuthModule extends VuexModule {
  loading: boolean = false;
  loggedIn: boolean = false;
  error: any = null;
  token: string = "";

  @Mutation
  setLoading(loading: boolean) {
    this.loading = loading;
  }

  @Mutation
  setError(error: any) {
    this.error = error;
  }

  @Mutation
  setLoggedIn(loggedIn: boolean) {
    this.loggedIn = loggedIn;
  }

  @Mutation
  setToken(token: string) {
    this.token = token;
  }

  @Action
  async logIn(request: LogInRequest) {
    this.setLoading(true);
    try {
      let response = await $axios.post("/login", request);
      this.setToken(response.headers["authorization"]);
      this.setLoggedIn(true);
    } catch (error) {
      notificationModule.setNotification({
        color: NotificationType.Error,
        message: error
      });
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
      notificationModule.setNotification({
        color: NotificationType.Success,
        message: "Signed up"
      });
    } catch (error) {
      notificationModule.setNotification({
        color: NotificationType.Error,
        message: error
      });
      this.setError(error);
    } finally {
      this.setLoading(false);
    }
  }

  @Action({ commit: "setToken" })
  async logOut() {
    this.setLoggedIn(false);
    this.setToken("");
  }
}
