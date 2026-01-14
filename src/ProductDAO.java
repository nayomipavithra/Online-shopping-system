import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    public void insertProduct(String name, String type, int quantity) throws SQLException {
        String sql = "INSERT INTO products (product_name, product_type, quantity) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, type);
            ps.setInt(3, quantity);
            ps.executeUpdate();
        }
    }

    public List<String> listProducts() throws SQLException {
        String sql = "SELECT product_id, product_name, product_type, quantity FROM products";
        List<String> out = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                out.add(rs.getInt("product_id") + ": " + rs.getString("product_name")
                        + " [" + rs.getString("product_type") + "] x" + rs.getInt("quantity"));
            }
        }
        return out;
    }
}

