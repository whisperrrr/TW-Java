public class Application {
    public static void main(String[] args) {
        F5 IdeaF5 = new F5InIDEA();
        F5 ChromeF5 = new F5InChrome();
        F5 WechatF5 = new F5InWechat();
        IdeaF5.pressDown();
        ChromeF5.pressDown();
        WechatF5.pressDown();
    }
}
