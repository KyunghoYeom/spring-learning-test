package cholog;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QueryingDAO {
    private JdbcTemplate jdbcTemplate;

    public QueryingDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    private final RowMapper<Customer> actorRowMapper = (resultSet, rowNum) -> {
        Customer customer = new Customer(
                resultSet.getLong("id"),
                resultSet.getString("first_name"),
                resultSet.getString("last_name")
        );
        return customer;
    };



    /**
     * public <T> T queryForObject(String sql, Class<T> requiredType)
     */
    public int count() {
        //TODO : customers 디비에 포함되어있는 row가 몇개인지 확인하는 기능 구현
        int rowCount = jdbcTemplate.queryForObject("select count(*) from customers", Integer.class);
        return rowCount;

    }

    /**
     * public <T> T queryForObject(String sql, Class<T> requiredType, @Nullable Object... args)
     */
    public String getLastName(Long id) {
        String lastName = jdbcTemplate.queryForObject("select last_name from customers where id = ?", String.class, id);
        return lastName;
    }

    /**
     * public <T> T queryForObject(String sql, RowMapper<T> rowMapper, @Nullable Object... args)
     */
    public Customer findCustomerById(Long id) {
        String sql = "select id, first_name, last_name from customers where id = ?";
        Customer customer = jdbcTemplate.queryForObject(sql,
                (resultSet, rowNum)->{
                Customer customer1 = new Customer(
                        resultSet.getLong("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name")
                );
                return customer1;

                },id);
        return customer;


    }

    /**
     * public <T> List<T> query(String sql, RowMapper<T> rowMapper)
     */
    public List<Customer> findAllCustomers() {
        String sql = "select id, first_name, last_name from customers";
        List<Customer> customers = jdbcTemplate.query(
                sql,
                (resultSet, rowNum) -> {
                    Customer customer = new Customer(
                            resultSet.getLong("id"),
                            resultSet.getString("first_name"),
                            resultSet.getString("last_name")
                    );
                    return customer;
                });
        return customers;

    }

    /**
     * public <T> List<T> query(String sql, RowMapper<T> rowMapper, @Nullable Object... args)
     */
    public List<Customer> findCustomerByFirstName(String firstName) {

        String sql = "select id, first_name, last_name from customers where first_name = ?";
        List<Customer>customers =jdbcTemplate.query(sql, actorRowMapper, firstName);
        return customers;
    }

}
