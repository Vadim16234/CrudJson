import controller.WriterController;
import repository.GsonWriterRepositoryImpl;
import repository.WriterRepository;
import view.WriterView;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuCrud {
    private final Scanner scanner = new Scanner(System.in);

    public MenuCrud() {
    }

    public void start() {
        System.out.println("Выберите сущность для дальнейшей работы: ");
        System.out.println("1 - Writer\n2 - Post\n3 - Label");
        System.out.print("Введите ваш выбор: ");
        int numberScan = inputIntScan(scanner);

        switch (numberScan) {
            case 1:
                startWriters();
                break;
            case 2:
                break;
            case 3:
                break;
            default:
                System.out.println("Неверный ввод");
                start();
        }
    }

    public int inputIntScan(Scanner scanner) {
        int result;
        while (true) {
            try {
                result = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Вы ввели не число, попробуйте заново");
                inputIntScan(scanner);
            }
        }
        return result;
    }

    public void startWriters() {
        WriterRepository writerRepository = new GsonWriterRepositoryImpl();
        WriterController writerController = new WriterController(writerRepository);
        WriterView writerView = new WriterView(writerController);
        writerView.startMenuWriter();
    }
}
