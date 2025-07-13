import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        DBUtil.connect(); // ✅ REQUIRED
        VBox root = new VBox(10);
        root.getChildren().addAll(
    ExpenseForm.getForm(),
    ExpenseChart.getChart()
    );


        Scene scene = new Scene(root, 600, 500);
        primaryStage.setTitle("Expense Tracker");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        DBUtil.connect();
        launch(args);
        DBUtil.disconnect();
    }
}
