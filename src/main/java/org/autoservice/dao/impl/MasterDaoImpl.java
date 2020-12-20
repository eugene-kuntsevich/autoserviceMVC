package org.autoservice.dao.impl;

import org.autoservice.dao.AbstractDao;
import org.autoservice.dao.api.MasterDao;
import org.autoservice.model.entity.Master;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class MasterDaoImpl extends AbstractDao<Master> implements MasterDao {
    public MasterDaoImpl() {
        super(Master.class);
    }

    @Override
    public List<Master> getFreeMasters() {
        CriteriaBuilder criteriaBuilder = sessionFactory.getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Master> criteriaQuery = criteriaBuilder.createQuery(Master.class);
        Root<Master> rootEntry = criteriaQuery.from(Master.class);

        CriteriaQuery<Master> free =
                criteriaQuery.select(rootEntry)
                        .where(criteriaBuilder.isEmpty(rootEntry.get("orders")));

        TypedQuery<Master> freeMastersQuery = sessionFactory.getCurrentSession().createQuery(free);

        return freeMastersQuery.getResultList();
    }
}
