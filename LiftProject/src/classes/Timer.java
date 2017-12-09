package classes;

import java.awt.event.ActionListener;

/**
 * Это класс таймер - 
 * контроллер который будет отвечать за все таймеры в программе
 * @author imxo
 */
public class Timer {
    
    private Long сurentTime;
    private Long finalTime;
    private Long lengthTime;
    
    
    public Timer() {
    }

    public Timer(Long lengthTime) {
        this.lengthTime = lengthTime;
        сurentTime = 0L;
    }

    public Boolean timerControllerStart(){
        
        if (сurentTime == 0){
            сurentTime = System.currentTimeMillis();
            finalTime = сurentTime + lengthTime;
        }
        if (finalTime <= System.currentTimeMillis()){
            timerControllerStop();
            return true;
        }
        else{
            return false;
        }
    }
    
    public void timerControllerStop(){
        
        сurentTime = 0L;
    }
    
//    
//    public Boolean timerGeneratorStart(Long time){
//        Timer timer = new Timer();
//    }
}
