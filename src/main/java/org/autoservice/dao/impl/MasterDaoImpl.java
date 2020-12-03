package org.autoservice.dao.impl;

import org.autoservice.dao.AbstractDao;
import org.autoservice.dao.api.MasterDao;
import org.autoservice.model.Master;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class MasterDaoImpl extends AbstractDao<Master> implements MasterDao {
    public MasterDaoImpl() {
        super(Master.class);
    }

    @Override
    public List<Master> getFreeMasters() {
        final String hql = "from Master mstr where mstr.orders.size = 0 ";
        TypedQuery<Master> query = sessionFactory.getCurrentSession().createQuery(hql);

        return query.getResultList();
    }
}
