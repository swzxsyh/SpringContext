package com.test.application.designPatten.behavioralPattern.interpreterPattern;

import com.test.application.designPatten.behavioralPattern.interpreterPattern.expression.AndExpression;
import com.test.application.designPatten.behavioralPattern.interpreterPattern.expression.Expression;
import com.test.application.designPatten.behavioralPattern.interpreterPattern.expression.OrExpression;
import com.test.application.designPatten.behavioralPattern.interpreterPattern.expression.TerminalExpression;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Demo {
    /**
     * 规则：Robert 和 John 是男性
     *
     * @return
     */
    public static Expression getMaleExpression() {
        Expression robert = new TerminalExpression("Robert");
        Expression john = new TerminalExpression("John");
        return new OrExpression(robert, john);
    }

    /**
     * 规则：Julie 是一个已婚的女性
     *
     * @return
     */
    public static Expression getMarriedWomanExpression() {
        Expression julie = new TerminalExpression("Julie");
        Expression married = new TerminalExpression("Married");
        return new AndExpression(julie, married);
    }

    public static void main(String[] args) {
        Expression isMale = getMaleExpression();
        Expression isMarriedWoman = getMarriedWomanExpression();

        log.info("John is male? ,{}", isMale.interpret("John"));
        log.info("Julie is a married women? {}", isMarriedWoman.interpret("Married Julie"));
    }
}
