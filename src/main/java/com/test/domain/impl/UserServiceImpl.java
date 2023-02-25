package com.test.domain.impl;

import com.test.domain.BaseService;
import com.test.domain.UserService;
import com.test.infrastructure.model.entity.TestFullEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseService implements UserService {

    @Override
    public void testUser() {
        TestFullEntity entity = new TestFullEntity();
        String currentUser = super.getCurrentUser();
        entity.setTestCode(currentUser);
    }
}
