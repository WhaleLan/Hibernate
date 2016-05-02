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
		
		// �������ö���
		Configuration config = new Configuration().configure();
		
		// ��������ע�����
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties())
				.buildServiceRegistry();
		
		// �����Ự��������
		sessionFactory = config.buildSessionFactory(serviceRegistry);
		
		// �����Ự����
		session = sessionFactory.openSession();
		
		// ��������
		transaction = session.beginTransaction();
		
		
		
	}

	@Test
	public void testSaveStudent() {
		// ���ɶ���
		Student student_1 = new Student(1, "������", "��", new Date(), "�䵱ɽ");
		Student student_2 = new Student(2, "����", "��", new Date(), "�һ���");
		session.save(student_1);
		session.save(student_2);
	}

	@After
	public void destory() {

		// �ύ����
		transaction.commit();
		
		// �رջỰ
		session.close();
		
		// �رջỰ����
		sessionFactory.close();
		
	}

}
