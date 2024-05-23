package macro;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.*;

public class RaffleToys {

    private List<Toy> listToys;
    private static final List<String> listanswers = new ArrayList<>(List.of("yes","да", "нуы", "lf", "y", "д"));

    public RaffleToys(List<Toy> listToys) {
        this.listToys = listToys;

        DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
        DecimalFormatSymbols symbols = formatter.getDecimalFormatSymbols();

        symbols.setGroupingSeparator(' ');
        formatter.setDecimalFormatSymbols(symbols);
    }

    public void updateWeigthToys(){
        System.out.println("Обновить вероятность выподания игрушек?");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine().toLowerCase(Locale.ROOT);
        scanner.useLocale(Locale.ROOT);
        if (listanswers.contains(answer)) {
            listToys.forEach(toy -> {
                System.out.println(toy.toString());
                System.out.println("Изменить вес игрушки? Да/Нет");
                String flagChang = scanner.nextLine().toLowerCase(Locale.ROOT);

                if (listanswers.contains(flagChang)){
                    System.out.println("Введите новый вес игрушки от 0.0 до 1.0");
                    float newWeight = scanner.nextFloat();
                    toy.setWeight(newWeight);
                }
            });
        }


    }

    public Toy getRandomToys(){
        updateWeigthToys();
        Random random = new Random();
        float randomFloat = random.nextFloat();
//        System.out.println("randomFloat:" + String.format(Locale.ROOT, "%.2f", randomFloat));
        Toy prizzToy = listToys.stream().min(
                (toy1, toy2) -> {
//                    System.out.println("toy1: " + toy1);
//                    System.out.println("toy2: " + toy2);
//                    System.out.println("compare: " + Float.compare(Math.abs(toy1.weight-randomFloat),Math.abs(toy2.weight-randomFloat)));
//                    System.out.println();
                    return Float.compare(Math.abs(toy1.weight-randomFloat),Math.abs(toy2.weight-randomFloat));
                }).get();
//        System.out.println("prizzToy: " + prizzToy);
//        System.out.println();
//        System.out.println();
//        System.out.println();

//        listToys.stream().forEach(toy -> System.out.println(toy));
    return prizzToy;
    }

}
