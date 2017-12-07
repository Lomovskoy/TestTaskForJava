package classes;

import java.util.Objects;
import java.util.ResourceBundle;

/**
 * Этот обьект будет отвечать за состояние лифта едит он или нет (worth, moves)
 * @author imxo
 */
public class Lift {
    
    String state;

    public Lift() {
    }

    public Lift(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.state);
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
        final Lift other = (Lift) obj;
        if (!Objects.equals(this.state, other.state)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("resource.stateLift");
        String message = resourceBundle.getString(state);
        //return message;
        return "Lift{ " + "state = " + message + " }";
    }
    
    
   
   
    
}
