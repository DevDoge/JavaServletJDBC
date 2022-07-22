import com.example.javaservletjdbc.dao.ConnectionFactory;

import java.sql.Connection;

public class TestConnection {
    public static void main(String[] args) throws Exception {
        Connection conn = ConnectionFactory.getConnection();

        if (conn != null){
            System.out.println("OK");
            conn.close();
        }
    }
}
