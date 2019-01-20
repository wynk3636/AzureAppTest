package servlet;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;

public class SQLExecution {
	
	//WebAppsの環境変数から値を取得
	String hostName = System.getenv("SQLCONNSTR_serverId"); // update me
	String user = System.getenv("SQLCONNSTR_useId"); // update me
	String password = System.getenv("SQLCONNSTR_pass"); // update me
	String dbName = System.getenv("SQLAZURECONNSTR_dbId"); // update me
    
    String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;"
        + "hostNameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
    Connection connection = null;
    String sql = null;
    
    void select() {
    }
    
    public void insert(Health health) {
    	try {
    		//JDBCドライバを指定
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
            connection = DriverManager.getConnection(url);

            // Create and execute a SELECT SQL statement.
            sql = "insert into testTBL("
            		+ "height,"
            		+ "weight,"
            		+ "bmi,"
            		+ "bodyType"
            		+ ")"
            		+ "Values"
            		+ "("
            		+ health.getHeight()
            		+ ","
            		+ health.getWeight()
            		+ ","
            		+ health.getBmi()
            		+ ","
            		+ "N'"
            		+ health.getBodyType()
            		+ "'"
            		+ ")";

            try (Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)) {
                connection.close();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            //e.toString();
        }
    }
}
