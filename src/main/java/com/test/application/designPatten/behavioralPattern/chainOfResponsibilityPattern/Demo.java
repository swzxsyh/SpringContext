package com.test.application.designPatten.behavioralPattern.chainOfResponsibilityPattern;

import com.test.application.designPatten.behavioralPattern.chainOfResponsibilityPattern.middleware.RoleCheckMiddleware;
import com.test.application.designPatten.behavioralPattern.chainOfResponsibilityPattern.middleware.ThrottlingMiddleware;
import com.test.application.designPatten.behavioralPattern.chainOfResponsibilityPattern.middleware.UserExistsMiddleware;
import com.test.application.designPatten.behavioralPattern.chainOfResponsibilityPattern.server.Server;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Slf4j
public class Demo {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Server server;

    private static void init() {
        server = new Server();
        server.register("admin@example.com", "admin_pass");
        server.register("user@example.com", "user_pass");

        ThrottlingMiddleware middleware = new ThrottlingMiddleware(2);
        middleware.linkWith(new UserExistsMiddleware(server)).linkWith(new RoleCheckMiddleware());

        server.setMiddleware(middleware);
    }

    public static void main(String[] args) throws IOException {
        init();

        boolean success;

        do {
            log.info("Enter email: ");
            String email = reader.readLine();
            log.info("Input password: ");
            String password = reader.readLine();

            success = server.login(email, password);

        } while (!success);
    }
}
