package day09; 
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 
import java.sql.Statement; 
public class UpdateDB { 
    public static void main(String args[]) { 

        String url = "jdbc:mysql://localhost:3306/javadb?useUnicode=true&characterEncoding=utf8"; 
        String driver = "org.gjt.mm.mysql.Driver";
        Connection con = null; 
        Statement  stmt = null; 
        try { 
            Class.forName(driver); 
        } catch(Exception e) { 
            System.err.print(e.toString()); 
        } 
        try { 
            con = DriverManager.getConnection(url,"javauser","1234"); 
            stmt = con.createStatement(); 
            String sql = "UPDATE address SET handphone='777-777-7777',"; 
            sql = sql + "address='캐나다' WHERE addressnum=5"; 
           int ret = stmt.executeUpdate(sql); 
           System.out.println("레코드 " + ret + "개가 수정되었습니다."); 
        } catch(SQLException e) { 
            System.out.println("SQLException: " + e.getMessage()); 
        } finally{ 
            try{ 
                if ( stmt != null){ stmt.close(); } 
            }catch(Exception e){} 
            try{ 
                if ( con != null){ con.close(); } 
            }catch(Exception e){} 
        } 
    } 
} 
