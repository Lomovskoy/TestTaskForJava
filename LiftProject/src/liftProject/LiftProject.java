/*
 * Backend Engineer — тестовое задание
 * Предлагаем вам решить тестовое задание — написать программу «симулятор лифта».
 * 
 * +Программа запускается из командной строки, в качестве параметров задается:
 * +- кол-во этажей в подъезде — N (от 5 до 20);
 * +- высота одного этажа;
 * +- скорость лифта при движении в метрах в секунду (ускорением пренебрегаем, считаем, 
 * +  что когда лифт едет — он сразу едет с определенной скоростью);
 * +- время между открытием и закрытием дверей.
 * 
 * После запуска программа должна постоянно ожидать ввода от пользователя и выводить 
 * действия лифта в реальном времени. События, которые нужно выводить:
 * - лифт проезжает некоторый этаж;
 * - лифт открыл двери;
 * - лифт закрыл двери.
 * 
 * Возможный ввод пользователя:
 * - вызов лифта на этаж из подъезда;
 * - нажать на кнопку этажа внутри лифта.
 * 
 * Считаем, что пользователь не может помешать лифту закрыть двери.
 * Все данные, которых не хватает в задаче, можно выбрать на свое усмотрение.
 * Решение можно прислать в виде ссылки на любой публичный git-репозиторий: GitHub, 
 * Bitbucket, GitLab и т.п.
 */
package liftProject;

import classes.Lift;
import classes.Message;
import classes.ProgramData;
import classes.Runner;

/**
 * Это главный класс приложения
 * @author imxo
 */
public class LiftProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Инициализация необходимых обьектов
        Runner runner = new Runner();
        Message message = new Message();
        
        //Ввод первичных данных пользоватля
        while (true){
            ProgramData progData = runner.getInitialInformation();
            if (progData != null){  
                break;
            }
            else{
                System.out.println(message.getMessage("queryFirstInputError"));
            }
        }
        
        //Вобар действия пользователя
        //в начале программы лифт стоит пустой с закрытыми дверьми по умолчени.
        Lift lift = new Lift("3");
        String userChoice = "";
        while (true){
            if (lift.getState().equals("3") || lift.getState().equals("4")){
                userChoice = runner.inputRequest(lift);
            }
            //Если выход
            if (userChoice.equals("3")){
                break;
            }
            //Если вызов лифта из подьезда
            else if (userChoice.equals("1") && lift.getState().equals("3")){
                break;
            }//Если нажать на кнопку этажа внутри лифта
            else if (userChoice.equals("2") && lift.getState().equals("4")){
                break;
            }
        }
 
        runner.endProgram();
    }
    
}
