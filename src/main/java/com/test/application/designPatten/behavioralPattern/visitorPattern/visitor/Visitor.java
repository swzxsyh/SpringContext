package com.test.application.designPatten.behavioralPattern.visitorPattern.visitor;

import com.test.application.designPatten.behavioralPattern.visitorPattern.shapes.Circle;
import com.test.application.designPatten.behavioralPattern.visitorPattern.shapes.CompoundShape;
import com.test.application.designPatten.behavioralPattern.visitorPattern.shapes.Dot;
import com.test.application.designPatten.behavioralPattern.visitorPattern.shapes.Rectangle;

/**
 * 通用访问者接口
 *
 * @author swzxsyh
 */
public interface Visitor {

    String visitDot(Dot dot);

    String visitCircle(Circle circle);

    String visitRectangle(Rectangle rectangle);

    String visitCompoundGraphic(CompoundShape cg);
}
