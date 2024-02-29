import java.util.function.Predicate;

public class Main implements Predicate<Integer[]> {

    @Override
    public boolean test(Integer[] scores) {
        for(int i = 0; i < scores.length; i++){
            if (scores[i] == 100){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Predicate<Integer[]> isMax = new Main();

        Integer[] scores = {95, 87, 100, 92};

        boolean containsMaxScore = isMax.test(scores);

        if (containsMaxScore) {
            System.out.println("Массив содержит студента с максимальным количеством баллов");
        } else {
            System.out.println("Массив не содержит студента с максимальным количеством баллов");
        }
    }
}
