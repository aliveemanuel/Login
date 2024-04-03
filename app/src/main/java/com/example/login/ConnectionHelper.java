package com.example.login;


import android.content.Context;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.util.Log;

import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionHelper{

    String username,password,ip,port,database;
    Connection connect;

    public Connection connectionclass(){
        ip="localhost";
        username="sa";
        password="test123";
        port="1433";
        database="Login";

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        Connection connection=null;
        String ConnectionURL=null;

        try{
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            ConnectionURL= "jdbc:jtds:sqlserver://"+ ip + ":"+ port+";"+ "databasename="+ database+";user="+username+";password="+password+";";
            connection= DriverManager.getConnection(ConnectionURL);
        Log.i("connected","connected to mssql");
        }catch(Exception e){
            Log.e("Error",e.toString());
        }

        return connection;
    }

    public void getText(Context context, TextView view){
        ConnectionHelper connectionHelper = new ConnectionHelper();
        connect = connectionHelper.connectionclass();
        try {
            if (connect != null) {
                String query = "select * from Login";
                Statement st = connect.createStatement();
                ResultSet rs = st.executeQuery(query);

                while(rs.next()){
                    Log.i("newEntry",rs.toString());
                    view.setText(rs.getString(2));
                }

            }
        } catch (SQLException e) {
            Log.e("error",e.getMessage().toString());
        }
    }
}






