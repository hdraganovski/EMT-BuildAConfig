import { Store } from "vuex";
import { getModule } from "vuex-module-decorators";
import AuthModule from "~/store/auth";
import UserModule from "~/store/user";

let authStore: AuthModule;
let userStore: UserModule;

function initialiseStores(store: Store<any>): void {
  authStore = getModule(AuthModule, store);
  userStore = getModule(UserModule, store);
}

export { initialiseStores, authStore, userStore };
