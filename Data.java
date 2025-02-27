import org.jfree.chart.*;
import org.jfree.data.category.*;

public class Data {
    public static void main(String[] args) {
        int[] data =new FileOperator("numbers.txt").toIntArray(100);  // your data array

        // Create dataset
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < data.length; i++) {
            dataset.addValue(data[i], "data", String.valueOf(i));
        }

        // Create chart - you can change to different chart types:
        JFreeChart chart = ChartFactory.createBarChart("","", "",dataset);

        // Display chart
        ChartFrame frame = new ChartFrame("Chart Window", chart);
        frame.setSize(600, 400);
        frame.setVisible(true);
    }
}