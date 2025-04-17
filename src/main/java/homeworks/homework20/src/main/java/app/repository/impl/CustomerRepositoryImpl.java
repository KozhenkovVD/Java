package app.repository.impl;

import app.model.Customer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import app.repository.CustomerRepository;

import javax.sql.DataSource;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {

    private static final DataSource DATASOURCE = new DriverManagerDataSource("jdbc:postgresql://localhost:5432/java?currentSchema=shop",
            "postgres", "postgres");
    private static final String SQL_SELECT_ALL = "select * from customers order by id";
    private static final String SQL_DELETE_ALL = "truncate customers cascade";
    private static final String SQL_SELECT_BY_ID = "select * from customers where customers.id = ? order by id";
    private static final String SQL_INSERT_CUSTOMER = "insert into customers (first_name, last_name) values (?, ?)";
    private final JdbcTemplate jdbcTemplate;

    public CustomerRepositoryImpl() {
        this.jdbcTemplate = new JdbcTemplate(DATASOURCE); //this.jdbcTemplate = new JdbcTemplate(DATASOURCE);
    }

    private static final RowMapper<Customer> customerRowMapper = (row, rowNumber) -> {
        int id = row.getInt("id");
        String firstName = row.getString("first_name");
        String lastName = row.getString("last_name");

        return new Customer(id, firstName, lastName);
    };
    @Override
    public List<Customer> getAll() {
        return jdbcTemplate.query(SQL_SELECT_ALL,customerRowMapper);
    }

    @Override
    public List<Customer> getById(Integer id) {
        return jdbcTemplate.query(SQL_SELECT_BY_ID, customerRowMapper, id);
    }

    @Override
    public void deleteAll() {
        jdbcTemplate.update(SQL_DELETE_ALL);
    }

    @Override
    public void addCustomer(Customer customer) {
        jdbcTemplate.update(SQL_INSERT_CUSTOMER, customer.getFirstName(), customer.getLastName());

    }
}
