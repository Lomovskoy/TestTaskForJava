package classes;

import java.util.Objects;

/**
 * Этот класс предназначен для ввода пользователя
 * @author imxo
 */
public class ProgramData {
    
    private Byte quantityFloors;
    private Byte heightFloors;
    private Byte liftSpeed;
    private Byte doorOpeningClosingTime;

    public ProgramData() {
    }

    public ProgramData(Byte quantityFloors, Byte heightFloors, Byte liftSpeed, Byte doorOpeningClosingTime) {
        this.quantityFloors = quantityFloors;
        this.heightFloors = heightFloors;
        this.liftSpeed = liftSpeed;
        this.doorOpeningClosingTime = doorOpeningClosingTime;
    }

    public Byte getQuantityFloors() {
        return quantityFloors;
    }

    public void setQuantityFloors(Byte quantityFloors) {
        this.quantityFloors = quantityFloors;
    }

    public Byte getHeightFloors() {
        return heightFloors;
    }

    public void setHeightFloors(Byte heightFloors) {
        this.heightFloors = heightFloors;
    }

    public Byte getLiftSpeed() {
        return liftSpeed;
    }

    public void setLiftSpeed(Byte liftSpeed) {
        this.liftSpeed = liftSpeed;
    }

    public Byte getDoorOpeningClosingTime() {
        return doorOpeningClosingTime;
    }

    public void setDoorOpeningClosingTime(Byte doorOpeningClosingTime) {
        this.doorOpeningClosingTime = doorOpeningClosingTime;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.quantityFloors);
        hash = 31 * hash + Objects.hashCode(this.heightFloors);
        hash = 31 * hash + Objects.hashCode(this.liftSpeed);
        hash = 31 * hash + Objects.hashCode(this.doorOpeningClosingTime);
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
        final ProgramData other = (ProgramData) obj;
        if (!Objects.equals(this.quantityFloors, other.quantityFloors)) {
            return false;
        }
        if (!Objects.equals(this.heightFloors, other.heightFloors)) {
            return false;
        }
        if (!Objects.equals(this.liftSpeed, other.liftSpeed)) {
            return false;
        }
        if (!Objects.equals(this.doorOpeningClosingTime, other.doorOpeningClosingTime)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UserInterface{" + "quantityFloors=" + quantityFloors + ", heightFloors=" + heightFloors + ", liftSpeed=" + liftSpeed + ", doorOpeningClosingTime=" + doorOpeningClosingTime + '}';
    }
    
    
    
}
