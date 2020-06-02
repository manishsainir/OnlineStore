package com.onlineStore.demo.repositry;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onlineStore.demo.model.Login;
import com.onlineStore.demo.model.Register;

@Repository
public class LoginDaoImp implements LoginDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void insert(Register register) {
		Session session = sessionFactory.getCurrentSession();
		session.save(register.getLoginId());
		session.save(register);
	}

	@Override
	public boolean verify(Login login) {
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery(
				"from Login where username='" + login.getUsername() + "' and password='" + login.getPassword() + "'");
		int i = q.list().size();
		if (i > 0)
			return true;
		else
			return false;
	}

}
