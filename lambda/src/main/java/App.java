import java.util.function.Consumer;
import java.util.function.Function;

public class App {
    public static void main(String[] args) {
        String string = "Hello World";
        // 自定义函数式接口
        ChangeStr myaddStar = str -> System.out.println(String.format("*%s*", str));
        myAddStar(myaddStar, string);
        // Consumer
        Consumer<String> consumerAddStar = str -> System.out.println(String.format("*%s*", str));
        consumerAddStar(consumerAddStar, string);

        int num = 330;
        // 自定义函数式接口
        Calculator mySquare = number -> number * number;
        System.out.println(mySquare(mySquare, num));
        // Function
        Function<Integer, Integer> functionSquare = number -> number * number;
        System.out.println(functionSquare(functionSquare, num));

    }

    public static void myAddStar(ChangeStr function, String str) {
        function.print(str);
    }

    public static void consumerAddStar(Consumer<String> function, String str) {
        function.accept(str);
    }

    public static int mySquare(Calculator function, int num) {
        return function.calculate(num);
    }

    public static int functionSquare(Function<Integer, Integer> function, int num) {
        return function.apply(num);
    }
}
