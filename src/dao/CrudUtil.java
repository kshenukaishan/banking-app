package dao;

import db.DBConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CrudUtil {


    public static <T> T execute(String sql, Object...params) throws SQLException, ClassNotFoundException {

        PreparedStatement statement = DBConnection.getInstance().connection().prepareStatement(sql);

        for (int i = 0; i < params.length; i++) {
            statement.setObject((i + 1), params[i]);
        }

        if(sql.startsWith("SELECT")){
            return (T) statement.executeQuery();
        }

        return (T) (Boolean) (statement.executeUpdate() > 0);

    }

}
