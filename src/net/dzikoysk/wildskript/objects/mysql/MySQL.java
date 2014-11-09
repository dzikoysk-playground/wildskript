package net.dzikoysk.wildskript.objects.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import org.bukkit.Bukkit;

public class MySQL{
	
	public static ArrayList<MySQL> list = new ArrayList<>();
	
	private final String id;
    private final String user;
    private final String database;
    private final String password;
    private final String port;
    private final String hostname;
    private Connection connection;

    
    public MySQL(String id, String hostname, String port, String database, String username, String password) {
        this.id = id;
    	this.hostname = hostname;
        this.port = port;
        this.database = database;
        this.user = username;
        this.password = password;
        this.connection = null;
        list.add(this);
    }
    
    public static MySQL get(String id){
    	for(MySQL sql : list) if(sql.getID().equals(id)) return sql;
    	return null;
    }
    
    public String getID(){
    	return this.id;
    }

    public Connection openConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://" + this.hostname + ":" + this.port + "/" + this.database, this.user, this.password);
        } catch (SQLException e) {
        	Bukkit.getLogger().severe("Could not connect to MySQL server! because: " + e.getMessage());
        } catch (ClassNotFoundException e) {
        	Bukkit.getLogger().severe("JDBC Driver not found!");
        }
        return connection;
    }

    public boolean checkConnection() {
        return connection != null;
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
            	Bukkit.getLogger().severe("Error closing the MySQL Connection!");
                e.printStackTrace();
            }
        }
    }

    public ResultSet querySQL(String query) {
        Connection c = openConnection();
        Statement s = null;
        try {
            s = c.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet ret = null;
        try {
            ret = s.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection();
        return ret;
    }

    public void updateSQL(String[] update) {
        Connection c = openConnection();
        Statement s = null;
        try {
            s = c.createStatement();
            for(String u : update){
            	s.executeUpdate(u);
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        closeConnection();
    }
    
    public String[] getAll(){
    	return new String[] { this.hostname, this.port, this.database, this.user, this.password  };
    }

}