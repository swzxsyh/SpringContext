package com.test.onlyTest;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.jexl3.*;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 测试自定义公式功能
 * <p>
 * 来源：https://blog.csdn.net/amosjob/article/details/100137460
 */
@Slf4j
public class JexlTest {

    /**
     * 假设为传入参数对应的K-V对象
     */
    private static final Map<String, String> INPUT_MAP = new HashMap<>(16);

    static {
        INPUT_MAP.put("count", "1");
        INPUT_MAP.put("difference", "8");
        INPUT_MAP.put("cost", "1.5");
        INPUT_MAP.put("excepted", "0.3978f");
    }

    private static volatile JexlEngine jexlEngine = null;

    private JexlEngine getInstance() {
        if (Objects.nonNull(jexlEngine)) {
            return jexlEngine;
        }
        synchronized (JexlEngine.class) {
            if (Objects.isNull(jexlEngine)) {
                jexlEngine = new JexlBuilder().create();
            }
            return jexlEngine;
        }
    }

    /**
     * 根据公式选择与入参转换公式并计算结果
     *
     * @param formula 公式
     * @param map     入参
     * @return 结果
     */
    private Object convertToCode(String formula, Map<String, String> map) {
        //Singleton
        JexlEngine jexlEngine = getInstance();
        if (Objects.isNull(jexlEngine)) {
            throw new RuntimeException("Instance Couldn't Be Loaded!");
        }
        final String NULL_RESULT = "";

        JexlExpression expression = jexlEngine.createExpression(formula);
        MapContext mapContext = new MapContext();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            mapContext.set(entry.getKey(), entry.getValue());
        }

        Object result = expression.evaluate(mapContext);
        return Objects.isNull(result) ? NULL_RESULT : result;
    }

    /**
     * 字符串转化公式功能测试
     */
    @Test
    public void jexlTest() {
        //假设为数据库曾经存储的公式
        String formula = "(count + difference) * cost/excepted";
        Object result = convertToCode(formula, INPUT_MAP);
        log.info("result: {}", result);
    }

    /**
     * 异常公式测试
     */
    @Test(expected = JexlException.Parsing.class)
    public void wrongFormulaTest() {
        // 异常公式，转化时会报错，可在存储时先运行转换检查
        String Error_Formula = "(a+b";
        //org.apache.commons.jexl3.JexlException$Parsing: com.test.onlyTest.JexlTest.wrongFormulaTest@1:4 parsing error in ''
        JexlExpression expression = getInstance().createExpression(Error_Formula);
    }

    /**
     * 异常入参测试
     */
    @Test(expected = JexlException.Variable.class)
    public void wrongInputSourceTest() {
        //非Serverless，清除测试新参数
        String formula = "count  * cost/excepted";

        INPUT_MAP.clear();
        INPUT_MAP.put("count", "5");
        INPUT_MAP.put("difference", "8");
        INPUT_MAP.put("cost", "");
        //可以输入时直接判断参数数量，减少运算
        //org.apache.commons.jexl3.JexlException$Variable: com.test.onlyTest.JexlTest.convertToCode@1:15 undefined variable excepted
        Object result2 = convertToCode(formula, INPUT_MAP);
    }
}