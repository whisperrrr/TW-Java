public class RoutePlan {
    private Person client;
    private String from;
    private String to;
    private Vehicle[] vehicles = {new Car(), new Bus(), new Train(), new Plane()};

    public RoutePlan(Person client, String from, String to) {
        this.client = client;
        this.from = from;
        this.to = to;
    }

    public Vehicle bestRoutePlan() {
        Vehicle bestVeh = vehicles[0];
        for (Vehicle veh:vehicles) {
            if (veh.cost() <= client.getBudget()
                && veh.cost() < bestVeh.cost()) {
                bestVeh = veh;
            }
        }
        return bestVeh;
    }

    public void bestRoutePlanShow() {
        String planStr = "尊敬的" + client.getName() + "先生\n"
                + "您的路线是从" + from + "到" + to + '\n'
                + "您的预算为" + client.getBudget() + '\n'
                + "目前最优的交通方式为" + bestRoutePlan().getClass().getSimpleName() + '\n'
                + "祝您旅途愉快！";
        System.out.println(planStr);
    }
}
