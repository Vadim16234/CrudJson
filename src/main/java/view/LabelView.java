package view;

import controller.LabelController;
import model.Label;
import model.Status;

import java.util.List;
import java.util.Scanner;

public class LabelView {
    private final Scanner scanner;
    private final LabelController labelController;

    public LabelView(LabelController labelController) {
        this.labelController = labelController;
        this.scanner = new Scanner(System.in);
    }


    public void startMenuLabel() {
        System.out.println("Доступные действия: ");
        System.out.println("1 - Показать всех Labels\n2 - Найти Label по id\n3 - Создать Label");
        System.out.println("4 - Редактировать Label\n5 - Удалить Label");
        System.out.print("Введите ваш выбор: ");
        int inputNumber = scanner.nextInt();
        scanner.nextLine();

        switch (inputNumber) {
            case 1:
                showAllLabel();
                break;
            case 2:
                searchLabelById();
                break;
            case 3:
                addLabel();
                break;
            case 4:
                updateLabel();
                break;
            case 5:
                deleteLabelById();
                break;
            case 6:
                break;
            default:
                System.out.println("Неверный ввод");
        }
    }

    public void showAllLabel() {
        List<Label> labelList = labelController.getAllLabels();
        for (Label label : labelList) {
            System.out.println(label);
        }
    }

    public void searchLabelById() {
        System.out.print("Введите искомый id: ");
        Long id = scanner.nextLong();
        System.out.println(labelController.getLabelById(id));
    }

    public void deleteLabelById() {
        System.out.print("Введите id для удаления: ");
        Long id = scanner.nextLong();
        labelController.deleteLabelById(id);
    }

    public void addLabel() {
        System.out.print("Введите name: ");
        String name = scanner.nextLine();
        Status status = Status.ACTIVE;

        labelController.addLabel(name, status);
    }

    public void updateLabel() {
        System.out.print("Введите id, который хотите изменить: ");
        Long id = scanner.nextLong();

        System.out.print("Введите name: ");
        String name = scanner.next();

        Status status = Status.ACTIVE;

        labelController.updateLabel(new Label(id, name, status));
    }
}
