import java.sql.Connection;

public class DBTest {
    public static void main(String[] args) {
        try (Connection c = DBConnection.getConnection()) {
            System.out.println("Connection OK: " + c.getMetaData().getURL());
            // quick product listing test (not required)
            try {
                ProductDAO pdao = new ProductDAO();
                System.out.println("Products: " + pdao.listProducts());
            } catch (Exception e) {
                System.out.println("ProductDAO test failed: " + e.getMessage());
            }
        } catch (Exception e) {
            System.err.println("DB connection failed: " + e.getMessage());
            e.printStackTrace(System.err);
            System.exit(1);
        }
    }
}

