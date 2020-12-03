package org.autoservice.dao.api;

import org.autoservice.model.Master;

import java.util.List;

public interface MasterDao extends GenericDao<Master> {
    List<Master> getFreeMasters();
}
