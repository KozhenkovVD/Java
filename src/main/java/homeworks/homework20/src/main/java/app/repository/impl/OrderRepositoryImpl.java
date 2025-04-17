package app.repository.impl;

import app.model.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import app.repository.OrderRepository;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.List;

public class OrderRepositoryImpl implements OrderRepository {

    private static final DataSource DATASOURCE = new DriverManagerDataSource("jdbc:postgresql://localhost:5432/java?currentSchema=shop",
            "postgres", "postgres");
    private static final String SQL_SELECT_ALL = "select * from orders order by id";
    private static final String SQL_DELETE_ALL = "truncate orders cascade";
    private static final String SQL_SELECT_BY_ID = "select * from orders where id = ? order by id";
    private static final String SQL_SELECT_BY_DATE = "select * from orders where order_date = '01/01/2025'";
    private final JdbcTemplate jdbcTemplate;

    public OrderRepositoryImpl() {
        this.jdbcTemplate = new JdbcTemplate(DATASOURCE);
    }
    private static final RowMapper<Order> orderRowMapper = (row, rowNumber) -> {
        Integer id = row.getInt("id");
        Integer customerId = row.getInt("customer_id");
        LocalDate orderDate = row.getDate("order_date").toLocalDate();
        Integer ordersCount = row.getInt("orders_count");
        Integer discount = row.getInt("discount");

        return new Order(id, customerId, orderDate, ordersCount, discount);
    };
    @Override
    public List<Order> getAll() {
        return jdbcTemplate.query(SQL_SELECT_ALL,orderRowMapper);
    }

    @Override
    public List<Order> findById(Integer id) {
        return jdbcTemplate.query(SQL_SELECT_BY_ID,orderRowMapper, id);
    }



    @Override
    public void deleteAll() {
        jdbcTemplate.update(SQL_DELETE_ALL);
    }

}
