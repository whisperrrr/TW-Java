public class DemoTest {
    public static void main(String[] args) {
        Person client = new Person("小明", 300);
        RoutePlan plan = new RoutePlan(client, "武汉", "北京");

        plan.bestRoutePlanShow();
    }
}
