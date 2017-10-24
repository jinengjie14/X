package com.db.article0.dao;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.db.article0.domain.User;

import java.util.List;



@Component
@Transactional
public class UserDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	public Session getSession(){
		return entityManager.unwrap(Session.class);
	}
	
	
	public void save(User user){
		this.getSession().save(user);
	}
	
	
	public void delete(User user){
		this.getSession().delete(user);
	}
	
	public User findById(String Id){
		User user = getSession().get(User.class, Id);
		return user;
	}
	  public User update(User user){
		  return (User) getSession().merge(user);
	   }
	  
	  
	  public User findByAccount (String account){
		  DetachedCriteria dc = DetachedCriteria.forClass(User.class);
		  Disjunction dis = Restrictions.disjunction();
		  dis.add(Property.forName("account").eq(account));
		  dis.add(Property.forName("email").eq(account));
		  dis.add(Property.forName("mobile").eq(account));
		  dc.add(dis);
		  Criteria c = dc.getExecutableCriteria(getSession());
		  List list = c.list();
		  
		  if (list != null && list.size()> 0) {
			list.get(0);
		}	
		return null;
	  }
	  
	  
	
}
