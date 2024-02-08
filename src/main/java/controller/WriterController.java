package controller;

import model.Writer;
import view.WriterView;

import java.io.File;

public class WriterController {
    private final WriterView writerView;

    public WriterController(WriterView writerService) {
        this.writerView = writerService;
    }
}
