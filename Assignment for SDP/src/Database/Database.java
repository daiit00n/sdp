package Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class Database {
    String url = "jdbc:postgresql://localhost:5432/sdp";
    String user = "postgres";
    String password = "16112004";
    Statement s;
    public void connect(){

        try (Connection con = DriverManager.getConnection(url, user, password)){
            System.out.println("Opened database successfully");
        } catch (Exception e) {
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }

    }

//    public void print(){
//        try (Connection con = DriverManager.getConnection(url, user, password)){
//            s = con.createStatement();
//            ResultSet rs = s.executeQuery( "SELECT * FROM house;" );
//            while ( rs.next() ) {
//                int id = rs.getInt("id");
//                boolean garden = rs.getBoolean("garden");
//                boolean wifi  = rs.getBoolean("wifi");
//                boolean doghouse = rs.getBoolean("doghouse");
//                boolean pool = rs.getBoolean("pool");
//                System.out.println( "ID = " + id );
//                System.out.println( "NAME = " + garden );
//                System.out.println( "AGE = " + wifi );
//                System.out.println( "ADDRESS = " + doghouse );
//                System.out.println( "SALARY = " + pool );
//                System.out.println();
//            }
//            rs.close();
//            s.close();
//            c.close();
//        }catch ( Exception e ) {
//            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
//            System.exit(0);
//        }
//    }

    public boolean checkGarden(){
        boolean checker = false;
        try (Connection con = DriverManager.getConnection(url, user, password)){
            s = con.createStatement();
            ResultSet rs = s.executeQuery( "SELECT garden FROM house;" );
            while ( rs.next() ) {
                boolean garden = rs.getBoolean("garden");
                if (garden){
                    checker = true;
                    break;
                }
            }
            rs.close();
            s.close();
        }catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        return checker;
    }

    public boolean checkPool(){
        boolean checker = false;
        try (Connection con = DriverManager.getConnection(url, user, password)){
            s = con.createStatement();
            ResultSet rs = s.executeQuery( "SELECT pool FROM house;" );
            while ( rs.next() ) {
                boolean pool = rs.getBoolean("pool");
                if (pool){
                    checker = true;
                    break;
                }
            }
            rs.close();
            s.close();
        }catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        return checker;
    }

    public boolean checkWifi(){
        boolean checker = false;
        try (Connection con = DriverManager.getConnection(url, user, password)){
            s = con.createStatement();
            ResultSet rs = s.executeQuery( "SELECT wifi FROM house;" );
            while ( rs.next() ) {
                boolean wifi = rs.getBoolean("wifi");
                if (wifi){
                    checker = true;
                    break;
                }
            }
            rs.close();
            s.close();
        }catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        return checker;
    }

    public boolean checkDoghouse(){
        boolean checker = false;
        try (Connection con = DriverManager.getConnection(url, user, password)){
            s = con.createStatement();
            ResultSet rs = s.executeQuery( "SELECT doghouse FROM house;" );
            while ( rs.next() ) {
                boolean doghouse = rs.getBoolean("doghouse");
                if (doghouse){
                    checker = true;
                    break;
                }
            }
            rs.close();
            s.close();
        }catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        return checker;
    }
}
