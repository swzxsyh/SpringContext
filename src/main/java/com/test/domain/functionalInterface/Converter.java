package com.test.domain.functionalInterface;

@FunctionalInterface
public interface Converter<F, T> {

    T convert(F from);
}