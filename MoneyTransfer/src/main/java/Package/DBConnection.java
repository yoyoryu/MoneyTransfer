package Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBConnection {


    Connection conn;

    public DBConnection()
    {
        try {
            Properties properties = new Properties();
            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties"));
            String url = properties.getProperty("url");
            String username = properties.getProperty("user");
            String password = properties.getProperty("password");
            //DBConnection conn = new Connection(url, username, password);
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,username.toString(),password.toString());
        }
        catch(Exception ex)
        {
            conn = null;
        }
    }

    /*
    public  DBConnection(String username, String password, String url)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,userName.toString(),password.toString());
        } catch (Exception ex)
        {
            conn = null;
        }

    }
    */
}
