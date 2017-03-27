package MLPart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Author: Spikerman < mail4spikerman@gmail.com >
 * Created Date: 17/3/27
 */
public class RemoteDbController {
    public static final String url = "jdbc:mysql://115.159.100.165/Data";
    public static final String name = "com.mysql.jdbc.Driver";
    public static final String user = "GroupTie";
    public static final String password = "grouptie123456";
    public static final String insertCandidateClusterSql = "insert into Data.CandidateCluster (clusterId,appId) values (?,?)";
    public Connection connection = null;
    public PreparedStatement insertCCStmt = null;


    public RemoteDbController() {
        try {
            Class.forName(name);
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Remote Database Connect Success");
            insertCCStmt = connection.prepareStatement(insertCandidateClusterSql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
