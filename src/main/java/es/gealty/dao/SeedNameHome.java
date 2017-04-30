package es.gealty.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import es.gealty.bean.SeedName;
import es.gealty.persistance.HibernateUtil;

/**
 * Home object for domain model class SeedName.
 * 
 * @see .SeedName
 * @author Hibernate Tools
 */
public class SeedNameHome {

	private static final Log log = LogFactory.getLog(SeedNameHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		SessionFactory sessionFactory = null;
		try {
			sessionFactory = HibernateUtil.getSessionFactory();
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
		return sessionFactory;
	}

	public void persist(SeedName transientInstance) {
		log.debug("persisting SeedName instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(SeedName instance) {
		log.debug("attaching dirty SeedName instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SeedName instance) {
		log.debug("attaching clean SeedName instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(SeedName persistentInstance) {
		log.debug("deleting SeedName instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SeedName merge(SeedName detachedInstance) {
		log.debug("merging SeedName instance");
		try {
			SeedName result = (SeedName) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public SeedName findById(java.lang.Integer id) {
		log.debug("getting SeedName instance with id: " + id);
		try {
			SeedName instance = (SeedName) sessionFactory.getCurrentSession().get("SeedName", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(SeedName instance) {
		log.debug("finding SeedName instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("SeedName").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
