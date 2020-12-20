package org.autoservice.security;

import org.autoservice.dao.api.AdminDao;
import org.autoservice.model.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdminDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private AdminDao adminDao;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Admin admin = adminDao.getAdminByLogin(s);

        if (admin == null) {
            throw new UsernameNotFoundException("Admin with login " + s + " not found");
        }

        return new User(
                admin.getLogin(),
                admin.getPassword(),
                AuthorityUtils.createAuthorityList("ADMIN")
        );
    }
}
