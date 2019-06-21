package com.example.jpa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;

public class JDBI_Example {

    public static void main(String[] args) throws SQLException {

        new Test12().get();
        
        
        
    }

}
class Test1 {
    private static final String url="jdbc:mysql://localhost:3306/idaasdb_cosmos?useSSL=true&requireSSL=false&serverTimezone=UTC&autoReconnect=true";
    private static final String username="root";
    private static final String password="root";
    private static final String className="com.mysql.jdbc.Driver";
    private Connection con=null;
    Handle handle=null;
    public void getData() throws Exception { 
      //  String sql="select * from employee";
        String sql = "SELECT id, connectorInitClass, connectorInitMethod, connectorJNDIName from provAssetConnectors";
    
        try {
           //s Class.forName(className);
            con=DriverManager.getConnection(url,username,password);
            handle=Jdbi.open(con);
            handle.begin();
            List<Map<String,Object>> optionalList=handle.createQuery(sql).mapToMap().list();
           // System.out.println(mapInList.get(0).values());
        } catch (Exception e) {
            System.out.println("exception in main method :: getData : "+e);
            throw e;
        }
    }
    
}
class Test12{
    void get(){
        try {
       new Test1().getData();
        }catch(Exception e) {
          System.out.println("catched in sub method :: get "+e);  
        }
    }
    
}
