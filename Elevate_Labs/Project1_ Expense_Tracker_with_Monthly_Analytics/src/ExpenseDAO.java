import java.sql.*;
import java.util.*;

public class ExpenseDAO {
    public static void insertExpense(Expense e) {
        try {
            PreparedStatement stmt = DBUtil.getConnection().prepareStatement("INSERT INTO expenses (name, amount, month) VALUES (?, ?, ?)");
            stmt.setString(1, e.name);
            stmt.setDouble(2, e.amount);
            stmt.setString(3, e.month);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static Map<String, Double> getMonthlyTotals() {
        Map<String, Double> data = new HashMap<>();
        try {
            ResultSet rs = DBUtil.getConnection().createStatement().executeQuery("SELECT month, SUM(amount) as total FROM expenses GROUP BY month");
            while (rs.next()) {
                data.put(rs.getString("month"), rs.getDouble("total"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }
}
