package macro;

import java.util.ArrayList;
import java.util.List;

public class ToyStory {
    private List<Toy> listToys;
    private ReaderListToysFromFile readerListToysFromFile;
    private RaffleToys raffleToys;

    public ToyStory(String nameCSVFile) {
        this.readerListToysFromFile = new ReaderListToysFromFile(nameCSVFile);
        this.listToys = new ArrayList<Toy>();
        this.raffleToys = new RaffleToys(createListToys());
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
    public void runRaffle(){
        this.raffleToys.raffleToy();
    }

//    public void runRaffleToy(){
//        RaffleToys raffleToys = new RaffleToys(createListToys());
//        raffleToys.updateWeigthToys();
//        System.out.println("Сегодня разыгрывается" + listToys.size() + " штук игрушек, из них: ");
//        listToys.forEach(toy -> System.out.println(toy.name + " - " + toy.quantity + " штук."));
//        System.out.println();
//
//            while (listToys.size() != 0){
//                raffleToys.getRandomToys();
//                raffleToys.getToy();
//            }
////        listToys.stream().sorted();
//        //listToys.forEach(toy -> toy.open());
//    }

    public int getLength(){
        return listToys.size();
    }
}
