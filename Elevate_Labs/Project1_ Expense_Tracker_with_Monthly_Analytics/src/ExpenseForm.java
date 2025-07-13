import javafx.scene.control.*;
import javafx.scene.layout.*;

public class ExpenseForm {
    public static VBox getForm() {
        TextField nameField = new TextField();
        TextField amountField = new TextField();
        ComboBox<String> monthBox = new ComboBox<>();
        monthBox.getItems().addAll("Jan", "Feb", "Mar", "Apr", "May", "Jun",
                                   "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");

        Button submit = new Button("Add Expense");
        
        submit.setOnAction(e -> {
    try {
        String name = nameField.getText();
        double amount = Double.parseDouble(amountField.getText());
        String month = monthBox.getValue();

        if (name.isEmpty() || month == null) {
            throw new IllegalArgumentException("All fields must be filled.");
        }

        Expense expense = new Expense(name, amount, month);
        ExpenseDAO.insertExpense(expense);

        // Clear fields after success
        nameField.clear();
        amountField.clear();
        monthBox.getSelectionModel().clearSelection();

        // ✅ Show success alert
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("Expense added successfully!");
        alert.showAndWait();
    } catch (NumberFormatException ex) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Invalid Input");
        alert.setHeaderText(null);
        alert.setContentText("Amount must be a valid number.");
        alert.showAndWait();
    } catch (IllegalArgumentException ex) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Missing Fields");
        alert.setHeaderText(null);
        alert.setContentText(ex.getMessage());
        alert.showAndWait();
    }
});


        VBox form = new VBox(5, new Label("Expense Name:"), nameField,
                                new Label("Amount:"), amountField,
                                new Label("Month:"), monthBox,
                                submit);
        form.setStyle("-fx-padding: 10;");
        return form;
    }
}
