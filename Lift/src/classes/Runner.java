package classes;

import java.util.Scanner;

/**
 * Этот класс отвечает за этапы запуска программы
 *
 * @author imxo
 */
public class Runner {

    Message message = new Message();
    Scanner scanner = new Scanner(System.in);
    ProgramData progDate = new ProgramData();
    
    public Boolean getInitialInformation() {

        System.out.println(message.getMessage("greeting"));
        System.out.println(message.getMessage("queryDate"));
        System.out.println(message.getMessage("queryFlors"));
        String quanFloarStr = scanner.nextLine();
        System.out.println(message.getMessage("queryHeightFloors"));
        String heightFloorsStr = scanner.nextLine();
        System.out.println(message.getMessage("queryLiftSpeed"));
        String liftSpeedStr = scanner.nextLine();
        System.out.println(message.getMessage("queryDoorOpeningClosingTime"));
        String openingClosingTimeStr = scanner.nextLine();

        try {
            byte quanFloar = Byte.parseByte(quanFloarStr);
            byte heightFloors = Byte.parseByte(heightFloorsStr);
            byte liftSpeed = Byte.parseByte(liftSpeedStr);
            byte openingClosingTime = Byte.parseByte(openingClosingTimeStr);
            
            if ((quanFloar < 1) || (heightFloors < 1 ||  heightFloors > 4) ||
                    (liftSpeed < 1 || liftSpeed > 19) || 
                    (openingClosingTime < 2 || openingClosingTime > 20)){
                return false;
            }else{
                progDate.setQuantityFloors(quanFloar);
                progDate.setHeightFloors(heightFloors);
                progDate.setLiftSpeed(liftSpeed);
                progDate.setDoorOpeningClosingTime(openingClosingTime);
            }
        } catch (Exception e) {
            return false;
        }


        return true;

    }
    
    public void endProgram() {
        System.out.println(message.getMessage("greeting"));
    }
}
