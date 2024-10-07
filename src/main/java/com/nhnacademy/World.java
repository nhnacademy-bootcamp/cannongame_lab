package com.nhnacademy;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * World 클래스는 JPanel을 확장하여, 공의 목록을 관리하고, 그래픽스에서 공을 그리는 기능을 제공합니다.
 */
public class World extends JPanel {
    private List<Ball> ballList; // 공의 목록을 저장하는 리스트
    private Logger log; // 로그를 기록하는 로거

    /**
     * World 객체를 생성합니다.
     * 공의 목록과 로거를 초기화합니다.
     */
    public World() {
        ballList = new LinkedList<>();
        log = LoggerFactory.getLogger(World.class);
    }

    /**
     * 공을 목록에 추가합니다.
     *
     * @param ball 추가할 공
     */
    public void addBall(Ball ball) {
        ballList.add(ball);
    }

    /**
     * 공을 목록에서 제거합니다.
     *
     * @param ball 제거할 공
     */
    public void removeBall(Ball ball) {
        ballList.remove(ball);
    }

    /**
     * 공을 목록에서 제거합니다.
     *
     * @param index 제거할 공의 인덱스
     */
    public void removeBall(int index) {
        ballList.remove(index);
    }

    /**
     * 목록에 있는 공의 총 개수를 반환합니다.
     *
     * @return 공의 총 개수
     */
    public int getBallCount() {
        return ballList.size();
    }

    /**
     * 목록에서 특정 인덱스의 공을 반환합니다.
     *
     * @param index 공의 인덱스
     * @return 해당 인덱스의 공
     */
    public Ball getBall(int index) {
        return ballList.get(index);
    }

    /**
     * JPanel의 paintComponent 메서드를 오버라이딩하여, 공을 그래픽스에서 그립니다.
     *
     * @param g 그래픽스 객체
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Ball ball : ballList) {
            if (ball instanceof PaintableBall) {
                ((PaintableBall) ball).paint(g);
            }
        }
    }
}
