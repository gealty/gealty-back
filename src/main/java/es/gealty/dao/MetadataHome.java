package es.gealty.dao;


import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import es.gealty.bean.Metadata;
import es.gealty.persistance.HibernateUtil;

/**
 * Home object for domain model class Metadata.
 * @see .Metadata
 * @author Hibernate Tools
 */
public class MetadataHome {

	private static final Log log = LogFactory.getLog(MetadataHome.class);

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

	public void persist(Metadata transientInstance) {
		log.debug("persisting Metadata instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Metadata instance) {
		log.debug("attaching dirty Metadata instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Metadata instance) {
		log.debug("attaching clean Metadata instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Metadata persistentInstance) {
		log.debug("deleting Metadata instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Metadata merge(Metadata detachedInstance) {
		log.debug("merging Metadata instance");
		try {
			Metadata result = (Metadata) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Metadata findById(java.lang.Integer id) {
		log.debug("getting Metadata instance with id: " + id);
		try {
			Metadata instance = (Metadata) sessionFactory.getCurrentSession().get("Metadata", id);
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

	public List findByExample(Metadata instance) {
		log.debug("finding Metadata instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("Metadata").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
