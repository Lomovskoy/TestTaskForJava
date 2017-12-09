package classes;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

/**
 * Это класс таймер - 
 * контроллер который будет отвечать за все таймеры в программе
 * @author imxo
 */
public class Timers {
    
    private Long сurentTime;
    private Long finalTime;
    private Long lengthTime;
    
    
    public Timers() {
    }

    public Timers(Long lengthTime) {
        this.lengthTime = lengthTime * 1000;
        finalTime = 0L;
    }

    public Timers(Float lengthTime) {
        Double newlengthTime = new BigDecimal(lengthTime).setScale(4, RoundingMode.UP).doubleValue();
        this.lengthTime = (new Double(newlengthTime * 1000)).longValue();

        finalTime = 0L;
    }
    
    public Boolean timerControllerStart(){
        
        сurentTime = System.currentTimeMillis();
        if (finalTime == 0){
            finalTime = сurentTime + lengthTime;
        }
        
        
        //System.out.println(Long.toString((finalTime - сurentTime) / 1000));
        
        if (finalTime <= сurentTime){
            timerControllerStop();
            return true;
        }

        return false;
    }
    
    public void timerControllerStop(){
        
        finalTime = 0L;
    }
    
    
    
//    
//    public Boolean timerGeneratorStart(Long time){
//        Timers timer = new Timers();
//    }

    public Long getСurentTime() {
        return сurentTime;
    }

    public void setСurentTime(Long сurentTime) {
        this.сurentTime = сurentTime;
    }

    public Long getFinalTime() {
        return finalTime;
    }

    public void setFinalTime(Long finalTime) {
        this.finalTime = finalTime;
    }

    public Long getLengthTime() {
        return lengthTime;
    }

    public void setLengthTime(Long lengthTime) {
        this.lengthTime = lengthTime;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.сurentTime);
        hash = 29 * hash + Objects.hashCode(this.finalTime);
        hash = 29 * hash + Objects.hashCode(this.lengthTime);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Timers other = (Timers) obj;
        if (!Objects.equals(this.сurentTime, other.сurentTime)) {
            return false;
        }
        if (!Objects.equals(this.finalTime, other.finalTime)) {
            return false;
        }
        if (!Objects.equals(this.lengthTime, other.lengthTime)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Timer{" + "\u0441urentTime=" + сurentTime + ", finalTime=" + finalTime + ", lengthTime=" + lengthTime + '}';
    }
    
    
}
