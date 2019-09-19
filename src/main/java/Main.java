import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println((int) (Math.random()*118));
        }
        System.out.println("__");
        Stream.generate(() -> (int) (Math.random() * 118)).limit(5).forEach(System.out::println);
    }
}
