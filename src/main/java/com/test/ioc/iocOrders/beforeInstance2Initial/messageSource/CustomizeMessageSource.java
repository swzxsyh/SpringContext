package com.test.ioc.iocOrders.beforeInstance2Initial.messageSource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * 国际化功能, refresh 注册BeanPostProcessors后-1，Debug不进入
 * todo
 */
@Slf4j
@Component
public class CustomizeMessageSource implements MessageSource {
    @Override
    public String getMessage(String code, Object[] args, String defaultMessage, Locale locale) {
        log.debug("MessageSource getMessage code:{}, args:{}, defaultMessage:{}, locale:{}", code, args, defaultMessage, locale);
        return null;
    }

    @Override
    public String getMessage(String code, Object[] args, Locale locale) throws NoSuchMessageException {
        log.debug("MessageSource getMessage code:{}, args:{}, locale:{}", code, args, locale);
        return null;
    }

    @Override
    public String getMessage(MessageSourceResolvable resolvable, Locale locale) throws NoSuchMessageException {
        log.debug("MessageSource getMessage resolvable:{}, locale:{}", resolvable, locale);
        return null;
    }
}
