import { Store } from "vuex";
import { getModule } from "vuex-module-decorators";
import AuthModule from "~/store/auth";
import UserModule from "~/store/user";
import NotificationModule from "~/store/notification";
import CategoryModule from "~/store/category";

let authStore: AuthModule;
let userStore: UserModule;
let categoryStore: CategoryModule;
let notificationModule: NotificationModule;

function initialiseStores(store: Store<any>): void {
  authStore = getModule(AuthModule, store);
  userStore = getModule(UserModule, store);
  categoryStore = getModule(CategoryModule, store);
  notificationModule = getModule(NotificationModule, store);
}

export {
  initialiseStores,
  authStore,
  userStore,
  categoryStore,
  notificationModule
};
