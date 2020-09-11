import { Store } from "vuex";
import { getModule } from "vuex-module-decorators";
import AuthModule from "~/store/auth";
import UserModule from "~/store/user";
import NotificationModule from "~/store/notification";
import CategoryModule from "~/store/category";
import ProductsModule from "~/store/products";

let authStore: AuthModule;
let userStore: UserModule;
let categoryStore: CategoryModule;
let productStore: ProductsModule;
let notificationModule: NotificationModule;

function initialiseStores(store: Store<any>): void {
  authStore = getModule(AuthModule, store);
  userStore = getModule(UserModule, store);
  categoryStore = getModule(CategoryModule, store);
  productStore = getModule(ProductsModule, store);
  notificationModule = getModule(NotificationModule, store);
}

export {
  initialiseStores,
  authStore,
  userStore,
  categoryStore,
  productStore,
  notificationModule
};
