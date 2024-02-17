import controller.LabelController;
import controller.WriterController;
import repository.GsonLabelRepositoryImpl;
import repository.GsonWriterRepositoryImpl;
import repository.LabelRepository;
import repository.WriterRepository;
import view.LabelView;
import view.WriterView;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuCrud {
    private final Scanner scanner = new Scanner(System.in);

    public MenuCrud() {
    }

    public void start() {
        System.out.println("Выберите сущность для дальнейшей работы: ");
        System.out.println("1 - Writer\n2 - Post\n3 - Label\n0 - Закрыть приложение");
        System.out.print("Введите ваш выбор: ");
        int numberScan = scanner.nextInt();

        try {
            boolean flag = true;
            while (flag) {
                switch (numberScan) {
                    case 1:
                        startWriters();
                        break;
                    case 2:
                        break;
                    case 3:
                        startLabels();
                        break;
                    case 0:
                        flag = false;
                        break;
                    default:
                        System.out.println("Неверный ввод");
                        flag = false;
                        start();
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Ошибка ввода " + e);
        }
    }

//    public int inputIntScan(Scanner scanner) {
//        boolean flag = true;
//        int result = 0;
//        while (flag) {
//            try {
//                result = scanner.nextInt();
//                break;
//            } catch (Exception e) {
//                System.out.println("Вы ввели не число, попробуйте заново");
//                flag = false;
//
//            }
//
//        }
//        return result;
//    }

    public void startWriters() {
        WriterRepository writerRepository = new GsonWriterRepositoryImpl();
        WriterController writerController = new WriterController(writerRepository);
        WriterView writerView = new WriterView(writerController);
        writerView.startMenuWriter();
    }

    public void startLabels() {
        LabelRepository labelRepository = new GsonLabelRepositoryImpl();
        LabelController labelController = new LabelController(labelRepository);
        LabelView labelView = new LabelView(labelController);
        labelView.startMenuLabel();
    }
}
