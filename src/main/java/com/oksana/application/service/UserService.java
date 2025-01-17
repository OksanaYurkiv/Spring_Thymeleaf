package com.oksana.application.service;

import com.oksana.infrastructure.persistence.dao.UsuarioDao;
import com.oksana.infrastructure.persistence.RoleEntity;
import com.oksana.infrastructure.persistence.UserEntity;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

/**
 * User service
 *
 * @author Oksana Yurkiv
 */
@RequiredArgsConstructor
@Service("userDetailsService")
public class UserService implements UserDetailsService {

    private final UsuarioDao usuarioDao;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = usuarioDao.findByUsername(username);

        if (userEntity == null) {
            throw new UsernameNotFoundException(username);
        }
        var roles = new ArrayList<GrantedAuthority>();

        for (RoleEntity roleEntity : userEntity.getRoleEntities()) {
            roles.add(new SimpleGrantedAuthority(roleEntity.getNombre()));
        }
        return new User(userEntity.getUsername(), userEntity.getPassword(), roles);
    }

}
