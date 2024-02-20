package repository.gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Post;
import model.Status;
import repository.PostRepository;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GsonPostRepositoryImpl implements PostRepository {
    private final String FILE_NAME = "src/main/resources/posts.json";

    private List<Post> readFromPostFile() {
        try (FileReader fileReader = new FileReader(FILE_NAME)){
            Type typeToken = new TypeToken<List<Post>>() {}.getType();
            List<Post> postList = new Gson().fromJson(fileReader, typeToken);

            if (postList == null) {
                postList = new ArrayList<>();
            }
            return postList;
        } catch (IOException e) {
            System.out.println("Ошибка чтения данных из файла " + e);
            return Collections.emptyList(); // в случае возникновения исключения, вернется пустой неизменяемый лист
        }
    }

    private void writeInFile(List<Post> postList) {
        try (FileWriter fileWriter = new FileWriter(FILE_NAME)) {
            String jsonCollection = new Gson().toJson(postList);
            fileWriter.write(jsonCollection);
        } catch (IOException e) {
            System.out.println("Ошибка при записи " + e);
        }
    }

    private Long generatedId(List<Post> postList) {
        Long postIdMax = 1L;

        if (postList == null) {
            return postIdMax;
        } else {
            for (Post post : postList) {
                if (post.getId() >= postIdMax) {
                    postIdMax = post.getId() + 1L;
                }
            }
            return postIdMax;
        }
    }

    @Override
    public List<Post> findAll() {
        return readFromPostFile();
    }

    @Override
    public Post findById(Long id) {
        return readFromPostFile()
                .stream()
                .filter(p -> p.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        List<Post> posts = readFromPostFile();

        for (Post post : posts) {
            if (post.getId().equals(id)) {
                post.setStatus(Status.DELETED);
            }
        }
    }

    @Override
    public Post add(Post post) {
        List<Post> posts = readFromPostFile();

        Long generatedId = generatedId(posts);

        post.setId(generatedId);
        posts.add(post);
        writeInFile(posts);
        return post;
    }

    @Override
    public Post update(Post post) {
        List<Post> postList = readFromPostFile();

        for (Post p : postList) {
            if (p.getId().equals(post.getId())) {
                p.setTitle(post.getTitle());
                p.setContent(post.getContent());
            }
        }
        writeInFile(postList);

        return post;
    }
}
