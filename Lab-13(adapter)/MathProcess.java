import java.util.Arrays;
import java.util.Collections;
import java.util.List;

interface MathProcessing {
    public void mathFunction(String type, Integer[] data);
}

class BasicMathProcessing implements MathProcessing {

    @Override
    public void mathFunction(String type, Integer[] data) {

        if (type.equalsIgnoreCase("add")) {

            Integer sum = 0;
            for (Integer i : data) {
                sum += i;
            }
            System.out.println(sum);
        }

        if (type.equalsIgnoreCase("multiply")) {

            long ans = 1;
            for (Integer i : data) {
                ans *= i;
            }
            System.out.println(ans);
        }

        MathProcessing mp = new MathAdapter();
        mp.mathFunction(type, data);
    }
}

// Adaptee
class AdvancedMathProcessing {

    public void calculateAverage(List<Integer> ls) {
        int sum = 0;
        for (Integer i : ls) {
            sum += i;
        }
        int avg = sum / (ls.size());
        System.out.println(avg);
    };

    public void sortData(List<Integer> ls) {
        Collections.sort(ls);
        for (Integer i : ls) {
            System.out.print(i + " ");
        }
        System.out.println();
    };

    public void searchData(List<Integer> ls, int key) {
        if (ls.contains(key)) {
            System.out.println("Found");
        } else {
            System.out.println("Not found");
        }
    };

    public void replace(List<Integer> ls, int key, int replacement) {
        if (ls.contains(key)) {
            key = replacement;
        } else {
            System.out.println("Not found");
        }
        for (Integer i : ls) {
            System.out.print(i + " ");
        }
        System.out.println();
    };

    // public void copyListData(List<Integer> ls, List<Integer> copy) {
    // Collections.copy(ls, copy);
    // };

}

// Adapter
class MathAdapter implements MathProcessing {

    AdvancedMathProcessing amd = new AdvancedMathProcessing();

    @Override
    public void mathFunction(String type, Integer[] data) {
        if (type.equalsIgnoreCase("avg")) {
            amd.calculateAverage(Arrays.asList(data));
        }
        if (type.equalsIgnoreCase("sort")) {
            amd.sortData(Arrays.asList(data));
        }
        if (type.equalsIgnoreCase("search")) {
            amd.searchData(Arrays.asList(data), 5);
        }
        if (type.equalsIgnoreCase("replace")) {
            amd.replace(Arrays.asList(data), 2, 5);
        }

        // if (type.equalsIgnoreCase("search")) {
        // amd.copyListData(Arrays.asList(data), null);
        // }
    }

}

public class MathProcess {
    public static void main(String[] args) {

        MathProcessing m = new BasicMathProcessing();
        Integer[] arr = { 2, 3, 4 };
        m.mathFunction("add", arr);
        m.mathFunction("multiply", arr);
        m.mathFunction("avg", arr);
        m.mathFunction("sort", arr);
        m.mathFunction("search", arr);
        m.mathFunction("replace", arr);
    }
}
