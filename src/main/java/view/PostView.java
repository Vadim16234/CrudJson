package view;

import controller.PostController;
import model.Label;
import model.Post;
import model.Status;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class PostView {
    private final Scanner scanner;
    private final PostController postController;

    public PostView(PostController postController) {
        this.postController = postController;
        this.scanner = new Scanner(System.in);
    }

    public void startMenuPost() {
        System.out.println("Доступные действия:");
        System.out.println("1 - Показать всех Posts\n2 - Найти Post по id\n3 - Создать Post");
        System.out.println("4 - Редактировать Post\n5 - Удалить Post");
        System.out.print("Введите ваш выбор: ");
        int inputNumber = scanner.nextInt();
        scanner.nextLine();

        switch (inputNumber) {
            case 1:
                getPostList();
                break;
            case 2:
                getPostById();
                break;
            case 3:
                addPost();
                break;
            case 4:
                updatePost();
                break;
            case 5:
                deletePostById();
                break;
            default:
                System.out.println("Неверный ввод");
        }
    }

    public void getPostList() {
        List<Post> posts = postController.showAll();

        for (Post post : posts) {
            System.out.println(post);
        }
    }

    public void getPostById() {
        System.out.print("Введите искомый id: ");
        Long id = scanner.nextLong();
        System.out.println(postController.showById(id));
    }

    public void deletePostById() {
        System.out.print("Введи id для удаления: ");
        Long id = scanner.nextLong();
        postController.deleteById(id);
    }

    public void addPost() {
        System.out.print("Введите title: ");
        String title = scanner.nextLine();

        System.out.print("Введите context: ");
        String content = scanner.nextLine();

        List<Label> labels = new ArrayList<>();

        Status status = Status.ACTIVE;

        postController.addPost(title, content, labels, status);
    }

    public void updatePost() {
        System.out.print("Введите id, который хотите изменить: ");
        Long id = scanner.nextLong();

        System.out.print("Введите title для изменения: ");
        String title = scanner.next();

        System.out.print("Введите context для изменения: ");
        String context = scanner.next();

        List<Label> labels = new ArrayList<>();

        Status status = Status.ACTIVE;

        postController.update(new Post(id, title, context, labels, status));
    }
}
