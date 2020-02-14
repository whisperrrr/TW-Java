public class SoftWare {
    private final String platform = "Window";

    public static void install() {
        System.out.println("安装中...");
        System.out.println("安装完成");
    }

    public static void uninstall() {
        System.out.println("卸载中...");
        System.out.println("卸载完成");
    }

    public void pressF5() {
        System.out.println("reloading...");
    }
}
