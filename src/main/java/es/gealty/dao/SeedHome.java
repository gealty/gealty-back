package es.gealty.dao;

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;

import es.gealty.bean.Seed;
import es.gealty.persistance.HibernateUtil;

/**
 * Home object for domain model class Seed.
 * 
 * @see .Seed
 * @author Hibernate Tools
 */
public class SeedHome {

	private static final Log log = LogFactory.getLog(SeedHome.class);

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

	public void persist(Seed transientInstance) {
		log.debug("persisting Seed instance");
		Transaction trans = null;
		try {
			trans = sessionFactory.getCurrentSession().beginTransaction();
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
			trans.commit();
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
		
	}

	public void attachDirty(Seed instance) {
		log.debug("attaching dirty Seed instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Seed instance) {
		log.debug("attaching clean Seed instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Seed persistentInstance) {
		log.debug("deleting Seed instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Seed merge(Seed detachedInstance) {
		log.debug("merging Seed instance");
		try {
			Seed result = (Seed) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Seed findById(java.lang.Integer id) {
		log.debug("getting Seed instance with id: " + id);
		try {
			Seed instance = (Seed) sessionFactory.getCurrentSession().get("Seed", id);
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

	public List findByExample(Seed instance) {
		log.debug("finding Seed instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("Seed").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
