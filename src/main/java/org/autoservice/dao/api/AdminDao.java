package org.autoservice.dao.api;

import org.autoservice.model.entity.Admin;

public interface AdminDao extends GenericDao<Admin> {
    Admin getAdminByLogin(String login);
}
