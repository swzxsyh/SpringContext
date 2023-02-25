package com.test.application.designPatten.behavioralPattern.mementoPattern.commands;

/**
 * 基础命令类
 *
 * @author swzxsyh
 */
public interface Command {

    String getName();

    void execute();
}
