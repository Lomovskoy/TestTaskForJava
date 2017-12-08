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
    
    public ProgramData getInitialInformation() {

        System.out.println(message.getMessage("greeting"));
        System.out.println(message.getMessage("query.Date"));
        System.out.println(message.getMessage("query.Flors"));
        String quanFloarStr = scanner.nextLine();
        System.out.println(message.getMessage("query.HeightFloors"));
        String heightFloorsStr = scanner.nextLine();
        System.out.println(message.getMessage("query.LiftSpeed"));
        String liftSpeedStr = scanner.nextLine();
        System.out.println(message.getMessage("query.DoorOpeningClosingTime"));
        String openingClosingTimeStr = scanner.nextLine();

        try {
            byte quanFloar = Byte.parseByte(quanFloarStr);
            byte heightFloors = Byte.parseByte(heightFloorsStr);
            byte liftSpeed = Byte.parseByte(liftSpeedStr);
            byte openingClosingTime = Byte.parseByte(openingClosingTimeStr);
            
            if ((quanFloar < 1) || (heightFloors < 1 ||  heightFloors > 4) ||
                    (liftSpeed < 1 || liftSpeed > 19) || 
                    (openingClosingTime < 2 || openingClosingTime > 20)){
                return null;
            }else{
                progDate.setQuantityFloors(quanFloar);
                progDate.setHeightFloors(heightFloors);
                progDate.setLiftSpeed(liftSpeed);
                progDate.setDoorOpeningClosingTime(openingClosingTime);
            }
        } catch (Exception e) {
            return null;
        }


        return progDate;

    }
    
    public String inputRequest(Lift lift) {
        
        System.out.println(message.getMessage("trait"));
        System.out.println(message.getMessage("query.Imput"));
        
        //Если пустой лифт закрыл двери
        if("3".equals(lift.getState())){
            System.out.println(message.getMessage("firstOption"));
        }
        //полный лифт закрыл двери
        else if("5".equals(lift.getState())){
            System.out.println(message.getMessage("lastOption"));
        }

        System.out.println(message.getMessage("exitOption"));
        String userChoice = scanner.nextLine();
        
        return userChoice;
    }
    
    public Lift runningLift(Lift lift){
        
        System.out.println(message.getMessage("query.Liftopendoor"));
        System.out.println(message.getMessage("query.Liftclossedoor"));
        lift.setState("5");
        return lift;
    }
    
    public String choiceOfFloor(Lift lift){
        
        return userChoice;
    }
    
    public void endProgram() {
        System.out.println(message.getMessage("query.EndProgramm"));
    }
}
