import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

public class OrderDAO {
    /**
     * Creates an order for userId with given products (productId -> quantity).
     * Returns generated order_id.
     */
    public int createOrder(int userId, Map<Integer, Integer> products) throws SQLException {
        String orderSql = "INSERT INTO orders (user_id) VALUES (?)";
        String detailSql = "INSERT INTO order_details (order_id, product_id, quantity) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection()) {
            conn.setAutoCommit(false);
            try (PreparedStatement psOrder = conn.prepareStatement(orderSql, Statement.RETURN_GENERATED_KEYS);
                 PreparedStatement psDetail = conn.prepareStatement(detailSql)) {

                psOrder.setInt(1, userId);
                psOrder.executeUpdate();
                try (ResultSet rs = psOrder.getGeneratedKeys()) {
                    if (!rs.next()) throw new SQLException("Failed to create order");
                    int orderId = rs.getInt(1);

                    for (Map.Entry<Integer, Integer> e : products.entrySet()) {
                        psDetail.setInt(1, orderId);
                        psDetail.setInt(2, e.getKey());
                        psDetail.setInt(3, e.getValue());
                        psDetail.addBatch();
                    }
                    psDetail.executeBatch();
                    conn.commit();
                    return orderId;
                }
            } catch (SQLException ex) {
                conn.rollback();
                throw ex;
            } finally {
                conn.setAutoCommit(true);
            }
        }
    }
}

