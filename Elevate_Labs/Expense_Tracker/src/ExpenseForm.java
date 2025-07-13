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
            String name = nameField.getText();
            double amount = Double.parseDouble(amountField.getText());
            String month = monthBox.getValue();

            Expense expense = new Expense(name, amount, month);
            ExpenseDAO.insertExpense(expense);
            nameField.clear(); amountField.clear(); monthBox.getSelectionModel().clearSelection();
        });

        VBox form = new VBox(5, new Label("Name:"), nameField,
                                new Label("Amount:"), amountField,
                                new Label("Month:"), monthBox,
                                submit);
        form.setStyle("-fx-padding: 10;");
        return form;
    }
}
