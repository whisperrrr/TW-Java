import java.util.function.Consumer;
import java.util.function.Function;

public class App {
    public static void main(String[] args) {
        String string = "Hello World";
        // 自定义函数式接口
        ChangeStr addStar = str -> System.out.println(String.format("*%s*", str));
        addStar.print(string);
        // Consumer
        // 方法一
        Consumer<String> consumer = System.out::println;
        consumer.accept(String.format("*%s*", string));
        // 方法二
        Consumer<String> consumer1 = str -> System.out.println(String.format("*%s*", str));
        consumer1.accept(string);

        int num = 330;
        // 自定义函数式接口
        Calculator mySquare = number -> number * number;
        System.out.println(mySquare.calculate(num));
        // Function
        Function<Integer, Integer> square = number -> number * number;
        System.out.println(square.apply(num));

    }
}
