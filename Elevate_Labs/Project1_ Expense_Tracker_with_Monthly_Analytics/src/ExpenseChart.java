import javafx.scene.chart.*;
import javafx.scene.Node; // Add this
import java.util.Map;

public class ExpenseChart {
    public static Node getChart() {
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        BarChart<String, Number> chart = new BarChart<>(xAxis, yAxis);
        chart.setTitle("Monthly Expenses");
        xAxis.setLabel("Month");
        yAxis.setLabel("Amount");

        XYChart.Series<String, Number> series = new XYChart.Series<>();
        Map<String, Double> data = ExpenseDAO.getMonthlyTotals();

        for (Map.Entry<String, Double> entry : data.entrySet()) {
            series.getData().add(new XYChart.Data<>(entry.getKey(), entry.getValue()));
        }

        chart.getData().add(series);
        return chart;
    }
}
