package view;

import controller.WriterController;
import model.Post;
import model.Status;
import model.Writer;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class WriterView {
    private final Scanner scanner;
    private final WriterController writerController;

    public WriterView(WriterController writerController) {
        this.writerController = writerController;
        this.scanner = new Scanner(System.in);
    }

    public void startMenuWriter() {
        System.out.println("Доступные действия:");
        System.out.println("1 - Показать всех Writers\n2 - Найти Writer по id\n3 - Создать Writer");
        System.out.println("4 - Редактировать Writer\n5 - Удалить Writer");
        System.out.print("Введите ваш выбор: ");
        int inputNumber = scanner.nextInt();
        scanner.nextLine();

        switch (inputNumber) {
            case 1:
                getWriterList();
                break;
            case 2:
                getWriterById();
                break;
            case 3:
                addWriter();
                break;
            case 4:

                break;
            case 5:
                deleteWriterById();
                break;
            default:
                System.out.println("Неверный ввод");

        }
    }

    public long inputLong(Scanner scanner) {
        long result;
        while (true) {
            try {
                result = scanner.nextLong();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Вы ввели не число, попробуйте заново");
            }
        }
        return result;
    }

    public void getWriterList() {
        List<Writer> writers = writerController.showAll();

        for (Writer writer : writers) {
            System.out.println(writer);
        }
    }

    public void getWriterById() {
        System.out.print("Введи искомый id: ");
        Long writerId = inputLong(scanner);
        System.out.println(writerController.showById(writerId));
    }

    public void deleteWriterById() {
        System.out.print("Введи id, который желаете удалить: ");
        Long writerId = inputLong(scanner);
        writerController.deleteById(writerId);
    }

    public void addWriter() {
        System.out.print("Введите firstName: ");
        String firstName = scanner.nextLine();

        System.out.print("Введите lastName: ");
        String lastName = scanner.nextLine();

        List<Post> posts = new ArrayList<>();

        Status status = Status.ACTIVE;

        Writer writer = writerController.addWriter(firstName, lastName, posts, status);
    }
}
