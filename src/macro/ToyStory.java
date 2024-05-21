package macro;

import java.util.ArrayList;
import java.util.List;

public class ToyStory {
    private List<Toy> listToys;
    private LoadListToys loadListToys;

    public ToyStory(String nameCSVFile) {
        this.loadListToys = new LoadListToys(nameCSVFile);
        this.listToys = new ArrayList<Toy>();
    }

    protected void createListToys(){
        List<List<String>> lists = loadListToys.readFile();
        lists.forEach(strings ->
                listToys.add(
                        new Toy(
                                getLength()+1,
                                strings.get(0),
                                Float.parseFloat(strings.get(2)),
                                Integer.parseInt(strings.get(1))
                        )
                )
        );

    }

    public void print(){
        createListToys();
//        listToys.stream().sorted();
        listToys.forEach(toy -> toy.open());
    }

    public int getLength(){
        return listToys.size();
    }
}
