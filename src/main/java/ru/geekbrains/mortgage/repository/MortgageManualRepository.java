package ru.geekbrains.mortgage.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.geekbrains.mortgage.entity.MortgageApplication;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.sql.DataSource;
import javax.swing.text.html.parser.Entity;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Repository
public class MortgageManualRepository {

//    DataSource dataSource;
//    JdbcTemplate jdbcTemplate;
    EntityManager manager;

    public MortgageManualRepository(EntityManager manager) {
        this.manager = manager;
    }

    public List<MortgageApplication> getAllSuccessful() {
        Query nativeQuery = manager.createNativeQuery(
            " SELECT * FROM mortgage_application WHERE status = 0",
            MortgageApplication.class
        );
        List<MortgageApplication> resultList = nativeQuery.getResultList();
        return resultList;
    }

    //    public List<MortgageApplication> getAllSuccessful() {
//        jdbcTemplate.query(
//            " SELECT * FROM mortgage_application WHERE status = 0", new RowMapper<Object>() {
//                @Override
//                public MortgageApplication mapRow(ResultSet resultSet, int i) throws SQLException {
//                    MortgageApplication mortgageApplication = new MortgageApplication();
//                    mortgageApplication.setId(resultSet.getLong(1));
//                    return mortgageApplication;
//                }
//            });
//
//    }

//    public List<MortgageApplication> getAllSuccessful() {
//        Connection connection = null;
//        try {
//           connection  = dataSource.getConnection();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//
//        Statement statement = null;
//        try {
//            statement = connection.createStatement();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//
//        try {
//            ResultSet resultSet = statement.executeQuery(" SELECT * FROM mortgage_application WHERE status = 0");
//            while (resultSet.next()) {
//                MortgageApplication application = new MortgageApplication();
//                application.setId(resultSet.getLong(1));
//                application.setName(resultSet.getString(2));
//                /*
//                bla bla bla
//                 */
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }
}
