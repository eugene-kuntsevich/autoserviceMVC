package org.autoservice.dao.impl;

import org.autoservice.dao.AbstractDao;
import org.autoservice.dao.api.AdminDao;
import org.autoservice.model.entity.Admin;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
public class AdminDaoImpl extends AbstractDao<Admin> implements AdminDao {
    public AdminDaoImpl() {
        super(Admin.class);
    }

    @Override
    public Admin getAdminByLogin(String login) {
        CriteriaBuilder criteriaBuilder = sessionFactory.getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Admin> criteriaQuery = criteriaBuilder.createQuery(Admin.class);
        Root<Admin> rootEntry = criteriaQuery.from(Admin.class);

        criteriaQuery.where(criteriaBuilder.equal(rootEntry.get("login"), login));

        TypedQuery<Admin> getAdminByLoginQuery = sessionFactory.getCurrentSession().createQuery(criteriaQuery);

        return getAdminByLoginQuery.getSingleResult();
    }
}
