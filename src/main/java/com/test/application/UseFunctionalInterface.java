package com.test.application;

import com.test.domain.functionalInterface.Converter;
import com.test.domain.functionalInterface.Formula;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

@Slf4j
public class UseFunctionalInterface {

    public String useConverter(Integer value) {
        Converter<Integer, String> converter = String::valueOf;
        String result = converter.convert(value);
        log.info("UseConverter:{}", result);
        return result;
    }

    public void useFormula() {
        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a * 1000);
            }
        };
    }

    public void usePredicate() {
        Predicate<String> predicate = s -> s.length() > 0;
        boolean foo = predicate.test("foo");
        boolean negateFoo = predicate.negate().test("foo");
        log.info("usePredicate test foo:{}", foo);
        log.info("usePredicate negate test foo:{}", negateFoo);

        Predicate<Boolean> nonNull = Objects::nonNull;
        Predicate<Boolean> isNull = Objects::isNull;
        log.info("usePredicate nonNull :{}", nonNull);
        log.info("usePredicate isNull :{}", isNull);

        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();
        log.info("usePredicate isEmpty :{}", isEmpty);
        log.info("usePredicate isNotEmpty :{}", isNotEmpty);
    }

    public void useFunction() {
        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString = toInteger.andThen(String::valueOf);
        backToString.apply("123");
    }

    public void useSupplier() {
        Supplier<Object> objectSupplier = Object::new;
        Object o = objectSupplier.get();
        log.info("o:{}", o);
    }

    public void useConsumer() {
        Consumer<Object> greeter = p -> System.out.println("Hey" + p);
        greeter.accept(new Object());
    }
}
