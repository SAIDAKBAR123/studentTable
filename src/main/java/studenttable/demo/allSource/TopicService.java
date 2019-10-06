package studenttable.demo.allSource;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Service
public class TopicService {

    @Autowired
    HikariDataSource hds;
    Connection conn = null;
    PreparedStatement ps = null;
    CallableStatement cs = null;
    ResultSet rs = null;

    public List<Topic> getTopics() {

        ArrayList<Topic> topics = new ArrayList<Topic>();
        try {
            conn = hds.getConnection();
            ps = conn.prepareStatement("select * from STUDENT");
            ps.execute();
            rs = ps.getResultSet();
            while (rs.next()) {
                Topic topic = new Topic();
                topic.setId(rs.getString("id"));
                topic.setDescription(rs.getString("des"));
                topic.setName(rs.getString("name"));
                topic.setEmail(rs.getString("email"));
                topics.add(topic);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DB.done(conn);
            DB.done(ps);
            DB.done(rs);
        }

        return topics;

    }

    public void addTopic(String id, String name, String faculty, String email) {

        try {
            conn = hds.getConnection();
            ps = conn.prepareStatement("insert into STUDENT(ID,NAME,DES,EMAIL) values (?,?,?,?)");

            ps.setString(1, id);
            ps.setString(2, name);
            ps.setString(3, faculty);
            ps.setString(4, email);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DB.done(conn);
            DB.done(ps);
            DB.done(rs);
        }
    }

    public void deleteTopic(String id) {

        try {
            conn = hds.getConnection();
            ps = conn.prepareStatement("DELETE FROM STUDENT WHERE ID=?");

            ps.setString(1,id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DB.done(conn);
            DB.done(ps);
            DB.done(rs);
        }

    }

    public void editTopic(String id, String name, String faculty, String email) {
        try {
            conn = hds.getConnection();
            ps = conn.prepareStatement("UPDATE STUDENT SET NAME=?, DES=?, EMAIL=? WHERE ID=?");

            ps.setString(1,name);
            ps.setString(2,faculty);
            ps.setString(3,email);
            ps.setString(4,id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DB.done(conn);
            DB.done(ps);
            DB.done(rs);
        }

    }
}