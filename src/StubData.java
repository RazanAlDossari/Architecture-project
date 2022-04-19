import java.util.ArrayList;
import java.util.List;

public class StubData {

    private static List<Triplet> getQAList() {
        //sheet3
        List<Triplet> list = new ArrayList<>();
        list.add(new Triplet(1.0, 1.0, 1.0));
        list.add(new Triplet(1.0, 2.0, 3.0));
        list.add(new Triplet(2.0, 3.0, 4.0));
        list.add(new Triplet(0.33, 0.50, 1.00));
        ////
        list.add(new Triplet(0.33, 0.50, 1.00));
        list.add(new Triplet(1.0, 1.0, 1.0));
        list.add(new Triplet(1.00, 2.00, 3.00));
        list.add(new Triplet(0.25, 0.33, 0.50));
        ////
        list.add(new Triplet(0.25, 0.33, 0.50));
        list.add(new Triplet(0.33, 0.50, 1.00));
        list.add(new Triplet(1.0, 1.0, 1.0));
        list.add(new Triplet(0.20, 0.25, 0.33));
        ////
        list.add(new Triplet(1.00, 2.00, 3.00));
        list.add(new Triplet(2.00, 3.00, 4.00));
        list.add(new Triplet(3.00, 4.00, 5.00));
        list.add(new Triplet(1.0, 1.0, 1.0));
        return list;
    }

    private static Triplet[][] getInputData() {
        List<Triplet> list = getQAList1();

        int rootList = (int) Math.sqrt(list.size());
        Triplet[][] qaMatrix = new Triplet[rootList][rootList];

        for (int rowIndex = 0; rowIndex < qaMatrix.length; rowIndex++) {
            for (int colIndex = 0; colIndex < qaMatrix[rowIndex].length; colIndex++) {
                qaMatrix[rowIndex][colIndex] = list.get((rowIndex * qaMatrix.length) + colIndex);///new Triplet(1.0, 2.0, 3.0); //do constructor-y stuff here
                System.out.print("[" + qaMatrix[rowIndex][colIndex].getLower() + "," + qaMatrix[rowIndex][colIndex].getMiddle() + "," + qaMatrix[rowIndex][colIndex].getUpper() + "]\t");
            }
            System.out.println("");
        }
        return qaMatrix;
    }
    private static List<Triplet> getQAList1() {
        //sheet2
        List<Triplet> list = new ArrayList<>();
        list.add(new Triplet(1.0, 1.0, 1.0));
        list.add(new Triplet(1.0, 2.0, 3.0));
        list.add(new Triplet(4.00, 5.00, 6.00));
        list.add(new Triplet(2.00, 3.00, 4.00));
        ////
        list.add(new Triplet(0.33, 0.50, 1.00));
        list.add(new Triplet(1.0, 1.0, 1.0));
        list.add(new Triplet(2.00, 3.00, 4.00));
        list.add(new Triplet(1.00, 2.00, 3.00));
        ////
        list.add(new Triplet(0.17, 0.20, 0.25));
        list.add(new Triplet(0.25, 0.33, 0.50));
        list.add(new Triplet(1.0, 1.0, 1.0));
        list.add(new Triplet(0.25, 0.33, 0.50));
        ////
        list.add(new Triplet(0.25, 0.33, 0.50));
        list.add(new Triplet(0.33, 0.50, 1.00));
        list.add(new Triplet(2.00, 3.00, 4.00));
        list.add(new Triplet(1.0, 1.0, 1.0));
        return list;
    }

}
