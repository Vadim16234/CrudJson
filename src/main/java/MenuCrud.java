import controller.LabelController;
import controller.PostController;
import controller.WriterController;
import repository.*;
import view.LabelView;
import view.PostView;
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
                        startPosts();
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

    public void startPosts() {
        PostRepository postRepository = new GsonPostRepositoryImpl();
        PostController postController = new PostController(postRepository);
        PostView postView = new PostView(postController);
        postView.startMenuPost();
    }
}
