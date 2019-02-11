package useSql;

import java.sql.Connection;
import java.sql.Statement;

import doHealthCheck.Health;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;

public class HealthSQL {
	
	//WebAppsの環境変数から値を取得
	String hostName = System.getenv("SQLCONNSTR_serverId"); // update me
	String user = System.getenv("SQLCONNSTR_useId"); // update me
	String password = System.getenv("SQLCONNSTR_pass"); // update me
	String dbName = System.getenv("SQLAZURECONNSTR_dbId"); // update me
    
    String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;"
        + "hostNameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
    String sql = null;
    
    void select() {
    }
    
    public void insert(Health health) {
		//JDBCドライバを指定(JDBC3.0以下）
		//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    	
    	//接続する(try-with-resource)で切断が自動で行われるコーディング
    	try(Connection connection = DriverManager.getConnection(url)) {
    		
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
            //SQL発行の為のStatementオブジェクトを生成
            Statement statement = connection.createStatement();          
            //実行（ResultSet resultSetで値を受け取ることも可能）
            statement.executeQuery(sql);
            /*
            if(resultSet.next()) {
            }
            */
        }
    	//SQLエラー
    	catch (SQLException e) {
    		e.printStackTrace();
    	}
        catch (Exception e) {
            e.printStackTrace();
            //e.toString();
        }
    	/*
    	//JDBCドライバが見つからなかった時（JDBC3.0以下の処理）
    	catch (ClassNotFoundException e) {
    		
    	}
    	*/
    }
}
