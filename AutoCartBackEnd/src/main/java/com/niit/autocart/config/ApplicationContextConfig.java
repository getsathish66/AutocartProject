package com.niit.autocart.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.autocart.dao.BillingDAO;
import com.niit.autocart.dao.CategoryDAO;
import com.niit.autocart.dao.MycartDAO;
import com.niit.autocart.dao.ProductDAO;
import com.niit.autocart.dao.RoleDAO;
import com.niit.autocart.dao.ShippingDAO;
import com.niit.autocart.dao.SupplierDAO;
import com.niit.autocart.dao.UserDAO;
import com.niit.autocart.daoimpl.BillingDAOImpl;
import com.niit.autocart.daoimpl.CategoryDAOImpl;
import com.niit.autocart.daoimpl.MycartDAOImpl;
import com.niit.autocart.daoimpl.ProductDAOImpl;
import com.niit.autocart.daoimpl.RoleDAOImpl;
import com.niit.autocart.daoimpl.ShippingDAOImpl;
import com.niit.autocart.daoimpl.SupplierDAOImpl;
import com.niit.autocart.daoimpl.UserDAOImpl;
import com.niit.autocart.domain.Billing;
import com.niit.autocart.domain.Category;
import com.niit.autocart.domain.Mycart;
import com.niit.autocart.domain.Product;
import com.niit.autocart.domain.Role;
import com.niit.autocart.domain.Shipping;
import com.niit.autocart.domain.Supplier;
import com.niit.autocart.domain.User;


@Configuration
@ComponentScan("com.niit.autocart")
@EnableTransactionManagement
public class ApplicationContextConfig {

	@Autowired
	@Bean(name = "dataSource")
	public DataSource getH2DataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
			
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/AutoCart");

		dataSource.setDriverClassName("org.h2.Driver");

		dataSource.setUsername("sa");
		dataSource.setPassword("sa");
		
		
		return dataSource;
	}

	
	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
	    properties.put("hibernate.format_sql", "true");
		
		return properties;
	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {

		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClass(User.class);
		sessionBuilder.addAnnotatedClass(Product.class);
		sessionBuilder.addAnnotatedClass(Category.class);
		sessionBuilder.addAnnotatedClass(Supplier.class);
		sessionBuilder.addAnnotatedClass(Shipping.class);
		sessionBuilder.addAnnotatedClass(Billing.class);
		sessionBuilder.addAnnotatedClass(Mycart.class);
		sessionBuilder.addAnnotatedClass(Role.class);
	
		return sessionBuilder.buildSessionFactory();
	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);

		return transactionManager;
	}

	
@Autowired
@Bean(name="userDAO")

	public UserDAO getUserDAO(SessionFactory sessionFactory)
	{
	return new UserDAOImpl(sessionFactory);
	
}
@Autowired
@Bean(name="productDAO")

	public ProductDAO getProductDAO(SessionFactory sessionFactory)
	{
	return new ProductDAOImpl(sessionFactory);
	
}
@Autowired
@Bean(name="categoryDAO")

	public CategoryDAO getCategoryDAO(SessionFactory sessionFactory)
	{
	return new CategoryDAOImpl(sessionFactory);
	
}
@Autowired
@Bean(name="supplierDAO")

	public SupplierDAO getSupplierDAO(SessionFactory sessionFactory)
	{
	return new SupplierDAOImpl(sessionFactory);
	
}
@Autowired
@Bean(name="shippingDAO")

	public ShippingDAO getShippingDAO(SessionFactory sessionFactory)
	{
	return new ShippingDAOImpl(sessionFactory);
	
}
@Autowired
@Bean(name="billingDAO")

	public BillingDAO getBillingDAO(SessionFactory sessionFactory)
	{
	return new BillingDAOImpl(sessionFactory);
	
}
@Autowired
@Bean(name="mycartDAO")

public MycartDAO getMycartDAO(SessionFactory sessionFactory)
{
return new MycartDAOImpl(sessionFactory);

}
@Autowired
@Bean(name="roleDAO")

public RoleDAO getRoleDAO(SessionFactory sessionFactory)
{
return new RoleDAOImpl(sessionFactory);

}

}

