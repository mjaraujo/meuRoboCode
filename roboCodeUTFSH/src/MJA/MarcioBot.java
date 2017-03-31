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
/*
    public enum EnumDir {
        cimaEsq(0), cimaDir(1), baiEsq(2), baiDir(14);
        public int direcao;

        EnumDir(int valor) {
            direcao = valor;
        }
    }
    private EnumDir direcao;
*/
    //private double arenaAltura;
    //private double arenaLargura; = getBattleFieldWidth();
        
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
            ahead(100);
            turnGunRight(360);
            turnRadarRight(360);
            fugirDoMeio();
        }
    }
    public void rizadinha() {
	for (int i = 0; i < 50; i++) {
		turnRight(30);
		turnLeft(30);
	}
    }

    private void fugirDoMeio(){
        if(((getBattleFieldWidth()/2)%getY())<100){
            if(((getBattleFieldHeight()/2)%getX())<100){
                rizadinha();
                ahead(200);
                
            }
        }
    }
    
   /* private EnumDir verDirecao() {
        int heading = (int) getHeading();
        heading = heading % 90;
        switch (heading) {
            case 0:
                return EnumDir.cimaDir;
            case 1:
                return EnumDir.baiDir;
            case 2:
                return EnumDir.baiEsq;
            case 3:
                return EnumDir.cimaEsq;
        }
        return null;
    }*/

    /**
     * onScannedRobot: What to do when you see another robot
     */
    public void onScannedRobot(ScannedRobotEvent e) {
        // Replace the next line with any behavior you would like
        if (e.getDistance() < 100) {
            fire(3);
        } else if (e.getDistance() < 200) {
            fire(2);
        } else {
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
      /*  EnumDir verDirecao = verDirecao();
        if(verDirecao==EnumDir.baiDir){
            turnLeft(90);
        }*/
        back(20);
    }
}
