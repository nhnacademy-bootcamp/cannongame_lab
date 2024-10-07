package com.nhnacademy;

public class Ball {
    /**
     * ball의 X축상에서의 위치
     */
    int x;

    /**
     * ball의 Y축상에서의 위치
     */
    int y;

    /**
     * ball의 반지름
     */
    int radius;

    /**
     * ball 인스턴스를 생성하고, 주어진 값으로 초기화한다.
     *
     * @param x      ball의 X축상에서의 위치 설정값
     * @param y      ball의 Y축상에서의 위치 설정값
     * @param radius ball의 반지름 설정값
     */
    public Ball(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    /**
     *
     * @return ball의 X축상에서의 좌표를 반환한다.
     */
    public int getX() {
        return x;
    }

    /**
     *
     * @return ball의 Y축상에서의 좌표를 반환한다.
     */
    public int getY() {
        return y;
    }

    /**
     *
     * @return ball의 반지름을 반환한다.
     */
    public int getRadius() {
        return radius;
    }

    /**
     * @return ball의 정보를 문자열로 변환해 반환한다.
     */
    @Override
    public String toString() {
        return String.format("[(%d,%d),%d]", x, y, radius);
    }
}
