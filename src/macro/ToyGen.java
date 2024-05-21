package macro;

public class ToyGen implements ItemGen{

    private ToyStory toyStory;


    @Override
    public ToyItem createItem(int id, String name, float weight, int quantity) {
        return new Toy(id, name, weight, quantity);
    }
}
