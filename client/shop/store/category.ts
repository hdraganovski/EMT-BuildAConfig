import { Module, VuexModule, Mutation, Action } from "vuex-module-decorators";
import { CategoryDto } from "~/models/models";
import { $axios } from "~/utils/api";

@Module({
  name: "category",
  stateFactory: true,
  namespaced: true
})
export default class CategoryModule extends VuexModule {
  categories: CategoryDto[] = [];
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
  setCategories(categories: CategoryDto[]) {
    this.categories = categories;
  }

  @Action
  async fetchCategories() {
    this.setLoading(true);
    this.setError("");
    try {
      let response: CategoryDto[] = await $axios.$get("/category");
      this.setCategories(response);
    } catch (error) {
      this.setError(error);
    } finally {
      this.setLoading(false);
    }
  }
}
