package com.test.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class UserDaoImpl implements UserDao {

	private JdbcTemplate jdbcTemplate;
	
	private DataSource dataSource;

	@Override
	public long getCount() {
		jdbcTemplate  = new JdbcTemplate(dataSource);
		String sql = "select count(*) from t_user2";
		long count = jdbcTemplate.queryForInt(sql, int.class);
		return count;
	}
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
}
