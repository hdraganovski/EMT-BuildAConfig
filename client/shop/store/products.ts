import { Module, VuexModule, Mutation, Action } from "vuex-module-decorators";
import { $axios } from "~/utils/api";
import { ProductDto, Page } from "~/models/models";

@Module({
  name: "products",
  stateFactory: true,
  namespaced: true
})
export default class ProductsModule extends VuexModule {
  products: Page<ProductDto> | null = null;
  loading: boolean = false;
  error: any = "";

  @Mutation
  setLoading(loading: boolean) {
    this.loading = loading;
  }

  @Mutation
  setError(error: any) {
    this.error = error;
  }

  @Mutation
  setProducts(products: Page<ProductDto> | null) {
    this.products = products;
  }

  @Action
  async getProductsForCategory(category: string) {
    this.setLoading(true);
    try {
      const result = await $axios.$get("/product/category/" + category);
      this.setProducts(result);
    } catch (error) {
      this.setError(error);
    } finally {
      this.setLoading(false);
    }
  }
}
