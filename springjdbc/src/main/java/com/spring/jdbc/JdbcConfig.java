package com.spring.jdbc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/*WHEN WE ARE
 *USING THIS JAVA CLASS AS 
 *A CONFIGURATION CLASS WE DON'T
 *NEED THE CONFIG FILE
 *BUT I WILL NOT DELETE THAT JUST 
 *(OR I COULD LEAVE IT AS IT IS AS IN MAIN METHOD I WILL NOT BE ACESSING IT)
 *COMMENT THE WHOLE DAMN THING
 *¯\_(ツ)_/¯ 
 * 
*/

@Configuration
@ComponentScan(basePackages = {"com.spring.jdbc.Dao"})
public class JdbcConfig {
	@Bean("datasource")
	public DriverManagerDataSource getDataSource() {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		datasource.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		datasource.setUsername("root");
		datasource.setPassword("0829");
		return datasource;
	}
	@Bean("jdbcTemplate")
	public JdbcTemplate getJdbcTemplate() {
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate;		
	}
	/*NOW WE ARE USING THE AUTO WIREING SO WE DON'T NEED TO DECLARE DAO IMPLIMENTATION HERE
	 * @Bean("studentDao") public StudentDao getStudentDao() { StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
	 * studentDaoImpl.setJdbcTemplate(getJdbcTemplate()); return studentDaoImpl; }
	 */

}
