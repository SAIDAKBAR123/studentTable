package studenttable.demo.allSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DB {
    public static void done(Connection obj){
        try{
            if(obj!=null){
                obj.close();
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public static void done(PreparedStatement obj){
        try{
            if(obj!=null){
                obj.close();
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public static void done(ResultSet obj){
        try{
            if(obj!=null){
                obj.close();
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}

