package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import util.Util;

public class ConexaoDB {
	protected Connection con;
	public void openConnection(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            this.con = DriverManager.
                getConnection("jdbc:sqlserver://127.0.0.1:1433;database=BDProjetoPOO;"+"IntegratedSecurity=true;"
            					,"admin","admin");  
            con.setAutoCommit(false);
            Util.geraLog("Conexão aberta...");
        } catch (ClassNotFoundException e) {          
            e.printStackTrace();
            Util.geraLog(e.getMessage());
        } catch (SQLException e) {            
            e.printStackTrace();
            Util.geraLog(e.getMessage());
        }
    }
	public void closeConnection() {
		try {
			this.con.close();
			Util.geraLog("Conexão fechada...");
		} catch (SQLException e) {         
            e.printStackTrace();
            Util.geraLog(e.getMessage());
        }
	}
}
