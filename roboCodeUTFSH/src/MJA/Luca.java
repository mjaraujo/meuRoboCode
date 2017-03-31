package MJA;


import robocode.HitByBulletEvent;
import robocode.HitWallEvent;
import robocode.RateControlRobot;
import robocode.ScannedRobotEvent;
import robocode.WinEvent;

public class Luca extends RateControlRobot {

    public void rizadinha() {
        for (int i = 0; i < 50; i++) {
            turnRight(30);
            turnLeft(30);
        }
    }
    public void onScannedRobot(ScannedRobotEvent Inimigo) {
	double distancia = Inimigo.getDistance();
	
	if ( distancia < 50 ) {
		fire(5);
	}else if(distancia < 150){
                fire(4);
        }else if(distancia < 250){
                fire(3);
        }else if(distancia < 300){
                fire(2);
        }else{
                fire(1);
        }
    }
    public void run() {
       
        while (true) {
            
            setVelocityRate(8); //velocidade maxima
            ahead(100); //pixels pra frente
            //turnGunRight(360);
            //setVelocityRate(-8);
            //back(400);
           // turnGunRight(360);
            turnGunRight(360);
            //turnRadarRight(360);
            
}
}

    
    public void onHitByBullet(HitByBulletEvent e) {
        back(100);
    }

    public void onHitWall(HitWallEvent e) {
        turnRight(45);

    }
    public void onWin(WinEvent e) { //é chamada quando o robo vence
	rizadinha();
}
}
