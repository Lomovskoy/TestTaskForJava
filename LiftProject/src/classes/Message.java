package classes;

import java.util.ResourceBundle;

/**
 * Этот класс отвечает за приветствие пользователя.
 * @author imxo
 */
public class Message {
    
    public String getMessage(String typeMessage){
        
        ResourceBundle resourceBundle = ResourceBundle.getBundle("resource.messages");
        String message = resourceBundle.getString(typeMessage);
        return message;
    }

}
