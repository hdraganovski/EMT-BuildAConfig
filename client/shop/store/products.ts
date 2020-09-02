import { Module, VuexModule, Mutation, Action } from "vuex-module-decorators";
import { $axios } from "~/utils/api";

@Module({
  name: "products",
  stateFactory: true,
  namespaced: true
})
export default class ProductsModule extends VuexModule {
}