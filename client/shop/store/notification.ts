import { Module, VuexModule, Mutation, Action } from "vuex-module-decorators";
import { Notificaton as Notification } from "~/models/models"

@Module({
  name: "notification",
  stateFactory: true,
  namespaced: true
})
export default class NotificationModule extends VuexModule {
    notification: Notification = {
        message: "",
        color: ""
    }

    @Mutation
    setNotification(notification: Notification) {
        this.notification = notification;
    }
}
