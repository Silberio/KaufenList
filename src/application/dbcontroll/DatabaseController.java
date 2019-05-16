package application.dbcontroll;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DatabaseController {
	 // JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/KaufenListDB";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "";
	   
	   //	Connection session
	   private static Connection conn = null;
	   
	   private static DatabaseController instance = null;
	   
	   public static DatabaseController getInstance() {
		   if(instance==null) {
			   instance = new DatabaseController();
		   } return instance;
	   }
	   
	   private boolean isRunning;
	   /**
	    * Establishes a connection with the database and initializes the db controll interface.
	    * At the end of the process, the connection is closed.
	 * @throws SQLException 
	    */
	   public void executeDBCtrl() throws SQLException {
		   try {
			   
			   Class.forName("com.mysql.cj.jdbc.Driver"); 
			   conn = DriverManager.getConnection(DB_URL, USER, PASS);
			   System.out.println("Connected to Database");
			   
			   Statement st = conn.createStatement();
			   			   
			   
			   sql = "SELECT * FROM items_to_buy";
			   
				rs = st.executeQuery(sql);
				while(rs.next()) {
					String output = "DBID: " + rs.getInt("item_id")
						+ " " + rs.getString("item_name")
						+ " $"+ rs.getInt("item_price")
						+ " " + rs.getString("item_sig")
						+ " type_"+ rs.getInt("item_type");
					
					System.out.println(output);
					System.out.println( "-----------------------------");
				}
				

			   
		   } catch(LinkageError le) {
			   System.out.println("Linkage Error on Class.forName()");
			   
		   } catch(ClassNotFoundException ee) {
			   System.out.println("Class Driver in 'com.mysql.cj.jdbc.Driver.*' not found");
		   } catch(SQLException e) {
			   //Later this will have to be dynamic.
			   System.out.println("FATAL :: SQL Database not found or link corrupt");
		   } finally {
			   conn.close();
			   System.out.println("Au Revoir! Closing connection...");
		   }
	   }
	   
	   //	Retrieving stuff from DB 
	   private String sql;
	   private ResultSet rs;
	   
	   private boolean awaitInput() {
		   Scanner sc = new Scanner(System.in);
		   
		   System.out.println("Input 1) return all \n2) exit: ");
		   
		   if(sc.nextInt()==1) {
			   return true;
		   } else
		   return false;

	   }

	   
	   /*
	   protected void DISCARD() {
		   try{
			      

			      query = "SELECT * FROM items_to_buy";
			      ResultSet rs = stmt.executeQuery(query);

			      //STEP 5: Extract data from result set
			      while(rs.next()) {
			    	  System.out.println(rs.getString("item_name"));
			      }
			      
			      //STEP 6: Clean-up environment
			      stmt.close();
			      conn.close();
			      
			   }catch(SQLException se){
			      //Handle errors for JDBC
			      se.printStackTrace();
			   }catch(Exception e){
			      //Handle errors for Class.forName
			      e.printStackTrace();
			   }finally{
			      //finally block used to close resources
			      try{
			         if(stmt!=null)
			            stmt.close();
			      }catch(SQLException se2){
			      }// nothing we can do
			      try{
			         if(conn!=null)
			            conn.close();
			      }catch(SQLException se){
			         se.printStackTrace();
			      }//end finally try
			   }//end try
	   }
	   */
	   
	   public ResultSet retrieveAllFromDB() {
		   
		   return null;   
	   }
		
}