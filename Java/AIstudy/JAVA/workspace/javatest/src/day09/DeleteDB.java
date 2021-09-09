package day09; 
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 
import java.sql.Statement; 
public class DeleteDB { 
    public static void main(String args[]) { 
        String url = "jdbc:mysql://localhost:3306/javadb?useUnicode=true&characterEncoding=utf8"; 
        String driver = "org.gjt.mm.mysql.Driver";
        Connection con = null; 
        Statement  stmt = null; 
        
       
        try { 
            try {
              Class.forName(driver);
            } catch (ClassNotFoundException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
            } 
            
            con = DriverManager.getConnection(url,"javauser","1234");
            
            String sql = "delete from address ";
            sql +="where addressnum = 10 ";
            
            stmt = con.createStatement();
            int cnt = stmt.executeUpdate(sql);
            System.out.println("레코드 " + cnt + "개가 삭제 되었습니다."); 
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