import java.io.*;
import java.util.*;
public class FileOperator {
    private String myFile;
    private Scanner fileReader;

    public FileOperator(String filename) {
        setFile(filename);
    }
    public void setFile(String filename) {
        myFile = filename;
        try {
            fileReader = new Scanner(new File(myFile));
        } catch(FileNotFoundException error) {
            System.out.println("File not found.");
        }
    }

    public int[]  toIntArray(int count) {
        int[] arr = new int[count];
        for(int i=0; i< count; i++){
            arr[i]=fileReader.nextInt();
        }
       return arr;
    }

    public String[]  toStringArray(int count) {
        String[] arr = new String[count];
        for(int i=0; i< count; i++){
            arr[i]=fileReader.nextLine();
        }
        return arr;
    }

    //read from file
    //write to file
    //convert to arrays



}
