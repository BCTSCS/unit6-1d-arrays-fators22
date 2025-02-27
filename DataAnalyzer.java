import java.io.IOException;
import java.io.File;
import java.util.*;
public class DataAnalyzer {


    public static int reverseSearch(int[] list, int target) {
        for (int i = list.length - 1; i >= 0; i--) if (list[i] == target) return i;
        return -1;
    }

    public static String[] toStringArray(String filePath, int arraySize) {
        String[] array = new String[arraySize];
        try (Scanner input = new Scanner(new File(filePath))) {
            int index = 0;
            while (input.hasNextLine() && index < arraySize) {
                array[index] = input.nextLine();
                index++;
            }
        }catch(IOException e){
            System.out.println("File not found");
        }
        return array;
    }

    public static int[] toIntArray(String filePath, int arraySize) {
        int[] array = new int[arraySize];
        try (Scanner input = new Scanner(new File(filePath))) {
            int index = 0;
            while (input.hasNextLine() && index < arraySize) {
                array[index] = input.nextInt();
                index++;
            }
        }catch(IOException e){
            System.out.println("File not found");
        }
        return array;
    }

    public static double[] toDoubleArray(String filePath, int arraySize) {
        double[] array = new double[arraySize];
        try (Scanner input = new Scanner(new File(filePath))) {
            int index = 0;
            while (input.hasNextLine() && index < arraySize) {
                array[index] = input.nextDouble();
                index++;
            }
        }catch(IOException e){
            System.out.println("File not found");
        }
        return array;
    }

    public static int[] findString(String[] list, String target) {
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < list.length; i++) {
            if (list[i].equals(target)) {
                indices.add(i);
            }
        }
        int[] result = new int[indices.size()];
        for (int i = 0; i < indices.size(); i++) {
            result[i] = indices.get(i);
        }
        return result;
    }

    public static String[] birdsWith(String[] list, String target) {
        int[] indexes = findString(list, target);
        String[] birdNames = toStringArray("names.txt", 98);
        String[] birds = new String[indexes.length];
        for(int i = 0; i < indexes.length; i++) {
            birds[i] = birdNames[indexes[i]];
        }

        return birds;
    }

    public static String[] birdsWithDiet(String target){
        String filePath = "data/diets.txt";
        int arraySize = 98;

        String[] stringArray = toStringArray(filePath, arraySize);
        String[] birdNames = birdsWith(stringArray, target);
        return birdNames;
    }

    public static int[] findIndexes(String[] list, String target){
        int[] l= new int[list.length];


        for(int i=0; i<list.length; i++){
            if(target.equals(list[i])){
                System.out.println(target+" "+i);

                l[i]=i;
            }else{
                l[i]=-1;
            }
        }
        System.out.println(target+" "+Arrays.toString( l));
        return l;

    }
    public static String birdsWithColor(String target){
        String filePath = "colors.txt";
        int arraySize = 98;
        String[] stringArray = toStringArray(filePath, arraySize);
        String diets= "diets.txt";
        String[] dietsArray = toStringArray(diets, arraySize);
        String r="\n";


        int[] indexes= findIndexes(stringArray, target);
        for(int i: indexes){

            if (i != -1){
                r=r+dietsArray[i]+"\n";
                System.out.println(i+" "+dietsArray[i]);
            }
        }

    return r;


    }

    public static String[] birdsWithStatus(String target){
        String filePath = "data/status.txt";
        int arraySize = 98;

        String[] stringArray = toStringArray(filePath, arraySize);
        String[] birdNames = birdsWith(stringArray, target);
        return birdNames;
    }

    public static int countInstances(String[] list, String target) {
        int count = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i].equals(target)) {
                count++;
            }
        }
        return count;
    }

    public static int countWithColor(String target) {
        String filePath = "colors.txt";
        int arraySize = 98;

        String[] stringArray = toStringArray(filePath, arraySize);
        return countInstances(stringArray, target);
    }

    public static int countWithDiet(String target) {
        String filePath = "diets.txt";
        int arraySize = 98;

        String[] stringArray = toStringArray(filePath, arraySize);
        return countInstances(stringArray, target);
    }

    public static int countWithStatus(String target) {
        String filePath = "data/status.txt";
        int arraySize = 98;

        String[] stringArray = toStringArray(filePath, arraySize);
        return countInstances(stringArray, target);
    }

    public static double statusPercentage(String target) {
        String filePath = "data/status.txt";
        int arraySize = 98;

        String[] stringArray = toStringArray(filePath, arraySize);
        int count = countInstances(stringArray, target);
        return (double) count / arraySize * 100;
    }



    //linear search
    public static int linearSearch(int[] numbers, int target){
        for (int i = 0; i < numbers.length; i++){
            if (numbers[i] == target){
                return i;
            }
        }
        return -1;
    }

    //binary search
    public static int binarySearch(int[] numbers, int target){
        int min = 0;
        int max = numbers.length - 1;
        while (min <= max){
            int mid =  (min+max)/2;
            if (numbers[mid] == target){
                return mid;
            }
            if (numbers[mid] < target){
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return -1;
    }

    public static int[] reverseList(int[] numbers) {
        int[] n= new int[numbers.length];
        int index=0;
        for (int i = numbers.length-1; i >= 0; i--) {
            n[index]= numbers[i];
            index++;
        }
        return n;
    }

    public static void main(String[] args){

        FileOperator reader = new FileOperator("numbers.txt");
        String[] nums = reader.toStringArray(10);
        for(String n : nums){
            System.out.println(n);
        }


    }


}
