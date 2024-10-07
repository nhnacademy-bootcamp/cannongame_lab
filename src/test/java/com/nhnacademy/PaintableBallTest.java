package com.nhnacademy;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class PaintableBallTest extends JFrame {
    static final int DEFAULT_X = 100;
    static final int DEFAULT_Y = 200;
    static final int DEFAULT_RADIUS = 50;
    static final Color DEFAULT_COLOR = Color.RED;

    PaintableBall paintableBall;

    @BeforeEach
    void setUp() {
        // 각 테스트 전에 PaintableBall 객체를 생성
        paintableBall = new PaintableBall(DEFAULT_X, DEFAULT_Y, DEFAULT_RADIUS, DEFAULT_COLOR);
    }

    @Test
    void testConstructor() {
        // 생성자가 올바르게 설정되었는지 확인
        assertEquals(DEFAULT_X, paintableBall.getX());
        assertEquals(DEFAULT_Y, paintableBall.getY());
        assertEquals(DEFAULT_RADIUS, paintableBall.getRadius());
        assertEquals(DEFAULT_COLOR, paintableBall.getColor());
    }

    @Test
    void testGetColor() {
        // getColor 메서드가 올바르게 색상을 반환하는지 확인
        assertEquals(Color.RED, paintableBall.getColor());
    }

    @Test
    void testSetColor() {
        // setColor 메서드가 색상을 올바르게 설정하는지 확인
        paintableBall.setColor(Color.BLUE);
        assertEquals(Color.BLUE, paintableBall.getColor());
    }

    @Test
    void testPaint() {
        // Graphics 객체에 대해 paint 메서드를 올바르게 호출하는지 확인
        Graphics g = Mockito.mock(Graphics.class);

        paintableBall.paint(g);

        // 색상 설정 확인
        Mockito.verify(g).setColor(Color.RED);
        // 공을 그리는 메서드가 올바르게 호출되는지 확인
        Mockito.verify(g).fillOval(paintableBall.getMinX(), paintableBall.getMinY(), paintableBall.getWidth(),
                paintableBall.getHeight());
    }

    @Test
    void testToString() {
        // toString 메서드가 올바르게 동작하는지 확인
        assertEquals(
                String.format("[(%d, %d), %d, %s]",
                        DEFAULT_X, DEFAULT_Y, DEFAULT_RADIUS, DEFAULT_COLOR),
                paintableBall.toString());
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        paintableBall.paint(g);
    }

    public static void main(String[] args) {
        PaintableBallTest test = new PaintableBallTest();

        test.setUp();

        test.setSize(500, 400);
        test.setVisible(true);
    }
}
