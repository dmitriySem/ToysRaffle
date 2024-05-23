package macro;

import java.util.ArrayList;
import java.util.List;

public class ToyStory {
    private List<Toy> listToys;
    private ReaderListToysFromFile readerListToysFromFile;

    public ToyStory(String nameCSVFile) {
        this.readerListToysFromFile = new ReaderListToysFromFile(nameCSVFile);
        this.listToys = new ArrayList<Toy>();
    }

    protected List<Toy> createListToys(){
        List<List<String>> lists = readerListToysFromFile.readFile();
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
        return listToys;

    }

    public void print(){
        RaffleToys raffleToys = new RaffleToys(createListToys());
        raffleToys.getRandomToys();
//        listToys.stream().sorted();
        //listToys.forEach(toy -> toy.open());
    }

    public int getLength(){
        return listToys.size();
    }
}
