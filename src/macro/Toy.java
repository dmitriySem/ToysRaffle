package macro;

import java.util.Locale;

public class Toy extends AbstractToy implements ToyItem{

    public Toy() {
    }

    public Toy(int id, String name, float weight, int quantity) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.quantity = quantity;
    }

    @Override
    public void setWeight(float weight) {
        this.weight = weight;
    }



    @Override
    public void open() {
        System.out.println("Выпала игрушка: " + this.name);
    }

    @Override
    public String toString() {
        return "Игрушка{" +
                "id=" + id +
                ", название=" + name +
                ", частота выподания=" + String.format(Locale.ROOT, "%.2f", weight)  +
                ", количество=" + quantity + "шт." +
                " }";
    }
}
