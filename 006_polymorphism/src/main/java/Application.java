public class Application {
    public static void main(String[] args) {
        SoftWare intellijIdea = new IntelijIdea();
        SoftWare chrome = new Chrome();
        SoftWare wechat = new Wechat();

        intellijIdea.pressF5();
        chrome.pressF5();
        wechat.pressF5();
    }
}
