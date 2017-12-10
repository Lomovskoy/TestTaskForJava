package classes;

import java.util.Objects;
import java.util.Scanner;

/**
 * Этот класс отвечает за этапы запуска программы
 * @author imxo
 */
public class Runner {

    Message message = new Message();
    Scanner scanner = new Scanner(System.in);
    ProgramData progDate = new ProgramData();
    Timers timer;

    /**
     * Метод инициализации основной информации о программе<br>
     * Ничего не принимает, возвращает обьеткт ProgramData
     * @return progDate
     */
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

    /**
     * Этот метод отвечает за закрытие и открытие дверей лифта:<br>
     * Принимает обьект Лифт и в зависимости от его состояния разрешает<br>
     * пользователю сделать выбор и вызвращает его
     * @param lift
     * @return userChoice
     */
    public String inputRequest(Lift lift) {

        System.out.println(message.getMessage("trait"));
        System.out.println(message.getMessage("query.Imput"));

        if ("3".equals(lift.getState())) {
            //Если пустой лифт закрыл двери
            System.out.println(message.getMessage("firstOption"));
        }
        else if ("5".equals(lift.getState())) {
            //Если полный лифт закрыл двери
            System.out.println(message.getMessage("lastOption"));
        }

        System.out.println(message.getMessage("exitOption"));
        String userChoice = scanner.nextLine();

        return userChoice;
    }
    /**
     * Метод отвечающий за запуск открывания и закрывания дверей<br>
     * через таймер, принимает обьект Лифт после закрытия дверей<br>
     * изменет поле состояния лифта и возвращает его
     * @param lift
     * @return lift
     */
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
    /**
     * Метод отвечающий за выбор этажа пользователем, возваращает userChoice<br>
     * если выбор верен и null если введён неверный этаж или буква
     * @param lift
     * @return userChoice
     */
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

    }

    /**
     * Метод переключения состояния лифта в исходно положение заданное при запуске<br>
     * Принимает обьект Лифт и отдаёт его с изменённым стстоянием
     * @param lift
     * @return lift
     */
    public Lift switchStateLift(Lift lift) {
        lift.setState("1");
        return lift;
    }

    /**
     * Метод отвечающий за передвижение лифта междуэтажами<br>
     * Принимает обьект Лифт и выбор пользователя<br>
     * С учётом введённых данных, и основных данных программы с помощью<br>
     * таймера осуществляет движение лифта, изменяет состояние лифта, этаж<br>
     * и возвращает обьект Лифт
     * @param lift
     * @param userChoice
     * @return lift
     */
    public Lift moveLift(Lift lift, String userChoice) {
        Byte floor = Byte.parseByte(userChoice);
        Byte currentFloor = lift.getFloor();

        if (Objects.equals(currentFloor, floor)) {
            //Если текущий этаж
            System.out.println(message.getMessage("query.Liftopendoor"));
            Long openDoorTime = (long) progDate.getDoorOpeningClosingTime();
            timer = new Timers(openDoorTime);
            //Открыть, закрыть двери
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
            //Если нет то ехать
            Float travelTimeFloor = (float) progDate.getHeightFloors() / progDate.getLiftSpeed();
            
            timer = new Timers(travelTimeFloor);
            while (!Objects.equals(currentFloor, floor)) {
                Boolean time = timer.timerControllerStart();
                if (time) {
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

        }

        return lift;
    }

    /**
     * Метод - выводит сообщение о конце программы.
     */
    public void endProgram() {
        System.out.println(message.getMessage("query.EndProgramm"));
    }
}
