package classes;

import java.util.Objects;
import java.util.Scanner;
import java.util.Timer;

/**
 * Этот класс отвечает за этапы запуска программы
 *
 * @author imxo
 */
public class Runner {

    Message message = new Message();
    Scanner scanner = new Scanner(System.in);
    ProgramData progDate = new ProgramData();
    Timers timer;

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

            if ((quanFloar < 1) || (heightFloors < 2 || heightFloors > 8)
                    || (liftSpeed < 1 || liftSpeed > 19)
                    || (openingClosingTime < 2 || openingClosingTime > 20)) {
                return null;
            } else {
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
        if ("3".equals(lift.getState())) {

            System.out.println(message.getMessage("firstOption"));
        } //полный лифт закрыл двери
        else if ("5".equals(lift.getState())) {

            System.out.println(message.getMessage("lastOption"));
        }

        System.out.println(message.getMessage("exitOption"));
        String userChoice = scanner.nextLine();

        return userChoice;
    }

    public Lift runningLift(Lift lift) {
        System.out.println(message.getMessage("query.Liftopendoor"));
        Long openDoorTime = (long) progDate.getDoorOpeningClosingTime();
        timer = new Timers(openDoorTime);

        while (true) {
            Boolean time = timer.timerControllerStart();
            if (time) {
                System.out.println(message.getMessage("query.Liftclossedoor"));
                lift.setState("5");

                break;
            }
        }

        return lift;
    }

    public String choiceOfFloor(Lift lift) {

        System.out.println(message.getMessage("query.ChoiceOfFloor") + " от 1 до " + progDate.getQuantityFloors().toString());
        String userChoice = scanner.nextLine();

        try {
            if ((Byte.parseByte(userChoice) > 0) && (Byte.parseByte(userChoice) <= progDate.getQuantityFloors())) {
                return userChoice;
            } else {
                System.out.println(message.getMessage("query.ErrorFloor"));
                return null;
            }

        } catch (Exception e) {
            System.out.println(message.getMessage("query.ErrorFloor"));
            return null;
        }

        //return userChoice;
    }

    public Lift switchStateLift(Lift lift, String userChoice) {
        lift.setState("1");
        return lift;
    }

    public Lift moveLift(Lift lift, String userChoice) {
        Byte floor = Byte.parseByte(userChoice);
        Byte currentFloor = lift.getFloor();

        if (Objects.equals(currentFloor, floor)) {

            System.out.println(message.getMessage("query.Liftopendoor"));
            Long openDoorTime = (long) progDate.getDoorOpeningClosingTime();
            timer = new Timers(openDoorTime);

            while (true) {
                Boolean time = timer.timerControllerStart();
                if (time) {
                    System.out.println(message.getMessage("query.Liftclossedoor"));
                    lift.setState("5");

                    break;
                }
            }
            lift.setState("3");
        } else {

            while (!Objects.equals(currentFloor, floor)) {

                if (currentFloor < floor) {
                    currentFloor++;
                    lift.setFloor(currentFloor);
                } else {
                    currentFloor--;
                    lift.setFloor(currentFloor);
                }
                System.out.printf(message.getMessage("query.LiftMove"), lift.getFloor().toString());

            }

        }

        return lift;
    }

    public void endProgram() {
        System.out.println(message.getMessage("query.EndProgramm"));
    }
}
