/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MJA;

import robocode.*;
//import java.awt.Color;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/Robot.html
/**
 * MarcioBot - a robot by (your name here)
 */
public class MarcioBot extends Robot {

    double direcao = 0.0f;

    /**
     * run: MarcioBot's default behavior
     */
    public void run() {

        // Initialization of the robot should be put here
        // After trying out your robot, try uncommenting the import at the top,
        // and the next line:
        // setColors(Color.red,Color.blue,Color.green); // body,gun,radar
        // Robot main loop
        while (true) {
            // Replace the next 4 lines with any behavior you would like
            mover();
            monitorar();
        }
    }

    private void mover() {
        int virar = 0;
        /*if ((getBattleFieldWidth()/2 - getX())>100){//tem que ir pra direita
            virar = 90 -(int)getHeading();
            turnRight(virar);
            ahead(100);
        }/*else if((getBattleFieldWidth()/2 - getX())>100){//tem que ir pra direita
            virar = 90 -(int)getHeading();
            turnRight(virar); 
            ahead(100);
        }  */
        turnRight(direcao);
        ahead(100);
    }

    private void monitorar() {
        turnRadarRight(60);
        turnRadarLeft(120);

    }

    public void rizadinha() {
        for (int i = 0; i < 50; i++) {
            turnRight(30);
            turnLeft(30);
        }
    }

    private void fugirDoMeio() {
        if (((getBattleFieldWidth() / 2) % getY()) < 100) {
            if (((getBattleFieldHeight() / 2) % getX()) < 100) {
                rizadinha();
                ahead(200);

            }
        }
    }

    /**
     * onScannedRobot: What to do when you see another robot
     */
    public void onScannedRobot(ScannedRobotEvent e) {
        // Replace the next line with any behavior you would like
        double dirTiro = getHeading() + e.getBearing() - getGunHeading();
        direcao = e.getBearing()+90 ;
        
        turnGunRight(dirTiro);
        if (e.getDistance() < 100) {
            fire(3);
        }else if (e.getDistance() < 300) {
            fire(2);
        }else{
            fire(1);
        }

    }

    /**
     * onHitByBullet: What to do when you're hit by a bullet
     */
    public void onHitByBullet(HitByBulletEvent e) {
        // Replace the next line with any behavior you would like
        back(10);
    }

    /**
     * onHitWall: What to do when you hit a wall
     */
    public void onHitWall(HitWallEvent e) {
        // Replace the next line with any behavior you would like
        back(20);
    }
}
