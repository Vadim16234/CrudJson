package view;

import controller.LabelController;
import controller.PostController;
import controller.WriterController;
import repository.*;
import repository.gson.GsonLabelRepositoryImpl;
import repository.gson.GsonPostRepositoryImpl;
import repository.gson.GsonWriterRepositoryImpl;
import view.LabelView;
import view.PostView;
import view.WriterView;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainView {
    private final Scanner scanner = new Scanner(System.in);

    public MainView() {}

    private final LabelView labelView = new LabelView();
    private final PostView postView = new PostView();
    private final WriterView writerView = new WriterView();

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
        writerView.startMenuWriter();
    }

    public void startLabels() {
        labelView.startMenuLabel();
    }

    public void startPosts() {
        postView.startMenuPost();
    }
}
