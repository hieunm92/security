package com.codegym.demo_security.repo;

import com.codegym.demo_security.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAppUserRepository extends JpaRepository<AppUser,Long> {
    AppUser getAppUserByName(String name);
}
