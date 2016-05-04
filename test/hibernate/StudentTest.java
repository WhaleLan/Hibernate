package hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class StudentTest {

	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;

	@Before
	public void init() {
		
		// 创建配置对象
		Configuration config = new Configuration().configure();
		
		// 创建服务注册对象
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties())
				.buildServiceRegistry();
		
		// 创建会话工厂对象
		sessionFactory = config.buildSessionFactory(serviceRegistry);
		
		// 创建会话对象
		session = sessionFactory.openSession();
		
		// 开启事务
		transaction = session.beginTransaction();
		
		
		
	}

	@Test
	public void testSaveStudent() {
		// 生成对象
//		Student student_1 = new Student(1, "张三丰", "男", new Date(), "武当山");
//		Student student_2 = new Student(2, "郭靖", "男", new Date(), "桃花岛");
//		session.save(student_1);
//		session.save(student_2);
		
		// 主键自增长
		for(int i=0; i<10; i++)
		{
			Student s = new Student();
			s.setName("段誉");
			s.setGender("男");
			s.setBirthday(new Date());
			s.setAddress("大理");
			session.save(s);
		}
		
	}

	@After
	public void destory() {

		// 提交事务
		transaction.commit();
		
		// 关闭会话
		session.close();
		
		// 关闭会话工厂
		sessionFactory.close();
		
	}

}
