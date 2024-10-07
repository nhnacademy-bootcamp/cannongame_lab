package com.nhnacademy;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class BallTest {

    Ball ball;

    @BeforeEach
    void setUp() {
        // 테스트 시작 전에 기본 Ball 객체 생성
        ball = new Ball(10, 20, 5);
    }

    @Test
    void testConstructor() {
        // 생성자가 올바르게 설정되었는지 확인
        assertEquals(10, ball.getX());
        assertEquals(20, ball.getY());
        assertEquals(5, ball.getRadius());
    }

    @Test
    void testGetX() {
        assertEquals(10, ball.getX());
    }

    @Test
    void testGetY() {
        assertEquals(20, ball.getY());
    }

    @Test
    void testGetRadius() {
        assertEquals(5, ball.getRadius());
    }

    @Test
    void testGetMinX() {
        // Min X = x - radius = 10 - 5 = 5
        assertEquals(5, ball.getMinX());
    }

    @Test
    void testGetMaxX() {
        // Max X = x + radius = 10 + 5 = 15
        assertEquals(15, ball.getMaxX());
    }

    @Test
    void testGetMinY() {
        // Min Y = y - radius = 20 - 5 = 15
        assertEquals(15, ball.getMinY());
    }

    @Test
    void testGetMaxY() {
        // Max Y = y + radius = 20 + 5 = 25
        assertEquals(25, ball.getMaxY());
    }

    @Test
    void testGetWidth() {
        // Width = 2 * radius = 2 * 5 = 10
        assertEquals(10, ball.getWidth());
    }

    @Test
    void testGetHeight() {
        // Height = 2 * radius = 2 * 5 = 10
        assertEquals(10, ball.getHeight());
    }

    @Test
    void testToString() {
        // toString 메서드가 올바르게 동작하는지 확인
        assertEquals("[(10,20),5]", ball.toString());
    }

    @ParameterizedTest
    @MethodSource("legalCreationParamsProvider")
    void testLegalCreation(int x, int y, int radius) {
        assertDoesNotThrow(() -> {
            new Ball(x, y, radius);
        });
    }

    static Stream<Arguments> legalCreationParamsProvider() {
        return Stream.of(
                Arguments.of(0, 0, 1),
                Arguments.of(0, 0, Integer.MAX_VALUE),
                Arguments.of(100, 100, 100),
                Arguments.of(100, -100, 100),
                Arguments.of(-100, 100, 100),
                Arguments.of(-100, -100, 100),
                Arguments.of(Integer.MIN_VALUE + 1, Integer.MIN_VALUE + 1, 1),
                Arguments.of(Integer.MIN_VALUE + 1, Integer.MAX_VALUE - 1, 1),
                Arguments.of(Integer.MAX_VALUE - 1, Integer.MIN_VALUE + 1, 1),
                Arguments.of(Integer.MAX_VALUE - 1, Integer.MAX_VALUE - 1, 1));
    }

    @ParameterizedTest
    @MethodSource("outOfBoundsExceptionProvider")
    void testOutOfBoundsException(int x, int y, int radius) {
        assertThrowsExactly(OutOfBoundsException.class, () -> {
            new Ball(x, y, radius);
        });
    }

    static Stream<Arguments> outOfBoundsExceptionProvider() {
        return Stream.of(
                Arguments.of(Integer.MAX_VALUE, 0, 1),
                Arguments.of(0, Integer.MAX_VALUE, 1),
                Arguments.of(Integer.MIN_VALUE, 0, 1),
                Arguments.of(0, Integer.MIN_VALUE, 1),
                Arguments.of(Integer.MIN_VALUE, Integer.MIN_VALUE, 1),
                Arguments.of(Integer.MAX_VALUE, Integer.MIN_VALUE, 1),
                Arguments.of(Integer.MIN_VALUE, Integer.MAX_VALUE, 1),
                Arguments.of(Integer.MAX_VALUE, Integer.MAX_VALUE, 1),
                Arguments.of(Integer.MAX_VALUE, 0, Integer.MAX_VALUE),
                Arguments.of(0, Integer.MAX_VALUE, Integer.MAX_VALUE),
                Arguments.of(Integer.MIN_VALUE, 0, Integer.MAX_VALUE),
                Arguments.of(0, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    @ParameterizedTest
    @MethodSource("invalidSizeExceptionProvider")
    void testInvalidSizeException(int x, int y, int radius) {
        assertThrowsExactly(InvalidSizeException.class, () -> {
            new Ball(x, y, radius);
        });
    }

    static Stream<Arguments> invalidSizeExceptionProvider() {
        return Stream.of(
                Arguments.of(0, 0, 0),
                Arguments.of(0, 0, -1),
                Arguments.of(0, 0, -100),
                Arguments.of(0, 0, Integer.MIN_VALUE));
    }
}
