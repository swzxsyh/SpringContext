package com.test.application.designPatten.behavioralPattern.visitorPattern.shapes;

import com.test.application.designPatten.behavioralPattern.visitorPattern.visitor.Visitor;

/**
 * 通用形状接口
 *
 * @author swzxsyh
 */
public interface Shape {

    void move(int x, int y);

    void draw();

    String accept(Visitor visitor);
}
