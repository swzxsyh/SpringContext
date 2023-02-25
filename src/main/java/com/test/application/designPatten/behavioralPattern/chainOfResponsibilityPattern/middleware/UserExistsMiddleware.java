package com.test.application.designPatten.behavioralPattern.chainOfResponsibilityPattern.middleware;

import com.test.application.designPatten.behavioralPattern.chainOfResponsibilityPattern.server.Server;
import lombok.extern.slf4j.Slf4j;

/**
 * 检查用户登录信息
 *
 * @author swzxsyh
 */
@Slf4j
public class UserExistsMiddleware extends Middleware {

    private Server server;

    public UserExistsMiddleware(Server server) {
        this.server = server;
    }

    public boolean check(String email, String password) {
        if (!server.hasEmail(email)) {
            log.info("This email is not registered!");
            return false;
        }

        if (!server.isValidPassword(email, password)) {
            log.info("Wrong password!");
            return false;
        }

        return checkNext(email, password);
    }

}
