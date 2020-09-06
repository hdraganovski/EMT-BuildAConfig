export class NotificationType {
  public static readonly Error = "error";
  public static readonly Success = "success";
  public static readonly Info = "primary";
  public static readonly Warn = "warning";
}

export class HardwareType {
  public static readonly MOTHERBOARD = "MOTHERBOARD";
  public static readonly CPU = "CPU";
  public static readonly GPU = "GPU";
  public static readonly MEMORY = "MEMORY";
  public static readonly STORAGE = "STORAGE";
  public static readonly COOLING = "COOLING";
  public static readonly TOWER = "TOWER";
  public static readonly POWER = "POWER";
  public static readonly KEYBOARD = "KEYBOARD";
  public static readonly MOUSE = "MOUSE";
  public static readonly MONITOR = "MONITOR";

  public static getAll(): string[] {
    return [
      HardwareType.MOTHERBOARD,
      HardwareType.CPU,
      HardwareType.GPU,
      HardwareType.MEMORY,
      HardwareType.STORAGE,
      HardwareType.COOLING,
      HardwareType.TOWER,
      HardwareType.POWER,
      HardwareType.KEYBOARD,
      HardwareType.MOUSE,
      HardwareType.MONITOR
    ];
  }
}
