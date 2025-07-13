import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.chart.*;
import javafx.scene.control.Alert;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.Map;

public class ExpenseChart {

    public static Pane getChart() {
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();

        BarChart<String, Number> chart = new BarChart<>(xAxis, yAxis);
        chart.setTitle("Monthly Expense Overview");
        xAxis.setLabel("Month");
        yAxis.setLabel("Amount (\u20B9)");

        chart.setLegendVisible(false);
        chart.setAnimated(false);
        chart.setVerticalGridLinesVisible(false);

        XYChart.Series<String, Number> series = new XYChart.Series<>();
        Map<String, Double> data = ExpenseDAO.getMonthlyTotals();

        for (Map.Entry<String, Double> entry : data.entrySet()) {
            XYChart.Data<String, Number> bar = new XYChart.Data<>(entry.getKey(), entry.getValue());
            series.getData().add(bar);
        }

        chart.getData().add(series);

        Platform.runLater(() -> {
            for (XYChart.Data<String, Number> bar : series.getData()) {
                Node barNode = bar.getNode();

                if (barNode == null) continue;

                // Styling
                barNode.setStyle("-fx-bar-fill: #42A5F5;");
                barNode.setEffect(new DropShadow(5, Color.GRAY));

                // Add centered label
                double value = bar.getYValue().doubleValue();
                Text label = new Text(String.format("\u20B9%.2f", value));
                label.setFont(Font.font("Segoe UI", 14));
                label.setFill(Color.web("#222"));
                label.setStyle("-fx-font-weight: bold;");

                // Click listener to show monthly details
                barNode.setOnMouseClicked(e -> {
                    String month = bar.getXValue();
                    String details = ExpenseDAO.getDetailsByMonth(month);

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Expenses for " + month);
                    alert.setHeaderText("Breakdown:");
                    alert.setContentText(details);
                    alert.showAndWait();
                });

                // Layout text above bar
                barNode.parentProperty().addListener((obs, oldParent, parent) -> {
                    if (parent instanceof Pane pane) {
                        pane.getChildren().add(label);

                        barNode.layoutBoundsProperty().addListener((obs2, oldBounds, bounds) -> {
                            label.layoutXProperty().bind(
                                barNode.layoutXProperty().add(bounds.getWidth() / 2).subtract(label.getBoundsInLocal().getWidth() / 2)
                            );
                            label.layoutYProperty().bind(
                                barNode.layoutYProperty().subtract(10)
                            );
                        });
                    }
                });
            }
        });

        VBox container = new VBox(chart);
        container.setAlignment(Pos.CENTER);
        container.setStyle("-fx-background-color: #f0f2f5; -fx-padding: 30;");
        chart.setPrefSize(800, 500);

        return container;
    }
}
