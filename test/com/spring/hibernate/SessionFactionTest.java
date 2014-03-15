package com.spring.hibernate;

import javax.sql.DataSource;

import junit.framework.TestCase;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.orm.hibernate3.LocalSessionFactoryBean;

import com.test.dao.User;
import com.test.dao.UserDao;
import com.test.dao.UserDaoImpl;
import com.test.service.TableServiceImpl;
import com.test.util.ApplicationContextUtils;

public class SessionFactionTest extends TestCase {

	public void testSession() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "spring/applicationContext.xml" });

		LocalSessionFactoryBean bean = (LocalSessionFactoryBean) context
				.getBean("sessionFactory");

		SessionFactory sessionFactory = bean.getObject();

		Session session = sessionFactory.openSession();

		System.out.println("");
	}

	public void testIoc() {

		ApplicationContext context = ApplicationContextUtils.getContextByXml();

		TableServiceImpl ts = (TableServiceImpl) context
				.getBean("tableService");
		String message = ts.getMessage("hello word!");
		for (int i : ts.getListInt()) {
			System.out.println("int number = " + i);
		}
		System.out.println("the result is :" + message);
	}

	public void testDataSource() {
		ApplicationContext context = ApplicationContextUtils.getContextByXml();

		DataSource source = (DataSource) context.getBean("dataSource");
	}

	public void testResource() {
		ApplicationContext context = ApplicationContextUtils.getContextByXml();
		Resource template = context.getResource("classpath:spring/dao/dao.xml");
		System.out.println();
	}

	public void testDao() {
		ApplicationContext context = ApplicationContextUtils.getContextByXml();

		UserDao userDao = (UserDaoImpl) context.getBean("userDao");

		long count = userDao.getCount();

		System.out.println("count=" + count);
	}

	public void testHibernate() {
		ApplicationContext context = ApplicationContextUtils.getContextByXml();
		SessionFactory sessionFactory = (SessionFactory) context
				.getBean("sessionFactory");

		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			
			User user = (User)session.load(User.class, 1);
			
			System.out.println("user name : " + user.getName());
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

}
