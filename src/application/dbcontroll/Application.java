package application.dbcontroll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Application {

		   
		   public static void main(String[] args) throws SQLException {
			   DatabaseController ctrl = DatabaseController.getInstance();
			   
			   ctrl.executeDBCtrl();
			   

	}

}
