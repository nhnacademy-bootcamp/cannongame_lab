package com.nhnacademy;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WorldTest {

    World world;
    Ball ball1;
    Ball ball2;

    @BeforeEach
    void setUp() {
        // 각 테스트 전에 World 객체와 두 개의 Ball 객체 생성
        world = new World();
        ball1 = new Ball(10, 20, 5);
        ball2 = new Ball(30, 40, 10);
    }

    @Test
    void testAddBall() {
        // Ball을 추가하고 목록에 제대로 추가되었는지 확인
        world.addBall(ball1);
        world.addBall(ball2);
        assertEquals(2, world.getBallCount());
        assertEquals(ball1, world.getBall(0));
        assertEquals(ball2, world.getBall(1));
    }

    @Test
    void testRemoveBallByObject() {
        // 공을 추가 후 제거하고 제대로 제거되었는지 확인
        world.addBall(ball1);
        world.addBall(ball2);
        world.removeBall(ball1);
        assertEquals(1, world.getBallCount());
        assertEquals(ball2, world.getBall(0));
    }

    @Test
    void testRemoveBallByIndex() {
        // 공을 추가 후 인덱스로 제거하고 제대로 제거되었는지 확인
        world.addBall(ball1);
        world.addBall(ball2);
        world.removeBall(0);
        assertEquals(1, world.getBallCount());
        assertEquals(ball2, world.getBall(0));
    }

    @Test
    void testGetBallCount() {
        // 공의 개수를 확인하는 메서드 테스트
        assertEquals(0, world.getBallCount());
        world.addBall(ball1);
        assertEquals(1, world.getBallCount());
        world.addBall(ball2);
        assertEquals(2, world.getBallCount());
    }

    @Test
    void testGetBall() {
        // 특정 인덱스의 Ball을 반환하는 메서드 테스트
        world.addBall(ball1);
        world.addBall(ball2);
        assertEquals(ball1, world.getBall(0));
        assertEquals(ball2, world.getBall(1));
    }

    public static void main(String[] args) {
        final int WIDTH = 500;
        final int HEIGHT = 400;
        final int BALL_COUNT = 10;
        final int MIN_RADIUS = 10;
        final int MAX_RADIUS = 50;
        final Color[] colors = { Color.BLACK, Color.BLUE, Color.RED, Color.GREEN, Color.YELLOW, Color.WHITE };

        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);

        World world = new World();
        frame.add(world);
        frame.setVisible(true);

        Random random = new Random();

        for (int i = 0; i < BALL_COUNT; i++) {
            int x = random.nextInt(WIDTH);
            int y = random.nextInt(HEIGHT);
            int radius = MIN_RADIUS + random.nextInt(MAX_RADIUS - MIN_RADIUS + 1);
            Color color = colors[random.nextInt(colors.length)];

            world.addBall(new PaintableBall(x, y, radius, color));
        }

        frame.repaint();
    }
}
