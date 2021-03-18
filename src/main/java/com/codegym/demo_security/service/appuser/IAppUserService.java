package com.codegym.demo_security.service.appuser;

import com.codegym.demo_security.model.AppUser;

public interface IAppUserService {
    AppUser getUserByName(String name);
}
