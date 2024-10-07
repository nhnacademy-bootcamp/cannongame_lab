package com.nhnacademy;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    void testToString() {
        // toString 메서드가 올바르게 동작하는지 확인
        assertEquals("[(10,20),5]", ball.toString());
    }
}
