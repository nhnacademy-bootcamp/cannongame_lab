package com.nhnacademy;

import java.awt.Color;
import java.awt.Graphics;

/**
 * PaintableBall 클래스는 Ball 클래스를 확장하여, 공의 색상을 관리하고, 그래픽스에서 공을 그리는 기능을 제공합니다.
 */
public class PaintableBall extends Ball {
    public static final Color DEFAULT_COLOR = Color.BLACK;

    private Color color; // 공의 색상

    /**
     * PaintableBall 객체를 생성합니다.
     *
     * @param x      공의 x 좌표
     * @param y      공의 y 좌표
     * @param radius 공의 반지름
     * @param color  공의 색상
     */
    public PaintableBall(int x, int y, int radius, Color color) {
        super(x, y, radius);

        this.color = color;
    }

    /**
     * PaintableBall 객체를 생성합니다.
     *
     * @param x      공의 x 좌표
     * @param y      공의 y 좌표
     * @param radius 공의 반지름
     */
    public PaintableBall(int x, int y, int radius) {
        this(x, y, radius, DEFAULT_COLOR);
    }

    /**
     * 공의 색상을 반환합니다.
     *
     * @return 공의 색상
     */
    public Color getColor() {
        return color;
    }

    /**
     * 공의 색상을 설정합니다.
     *
     * @param color 공의 색상
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * 그래픽스에서 공을 그립니다.
     *
     * @param g 그래픽스 객체
     */
    public void paint(Graphics g) {

        g.setColor(color);
        g.fillOval(getMinX(), getMinY(), getWidth(), getHeight());
    }

    /**
     * PaintableBall 객체의 문자열 표현을 반환합니다.
     *
     * @return PaintableBall 객체의 문자열 표현
     */
    @Override
    public String toString() {
        return String.format("[(%d, %d), %d, %s]", getX(), getY(), getRadius(), getColor());
    }
}
