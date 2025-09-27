package Homework9.repository;

public class TxtLogger extends FileLogger {

    public TxtLogger(String fileName) {
        super(fileName);
    }

    public TxtLogger() {
        super();
    }

    @Override
    public String getFileExtension() {
        return ".txt";
    }
}
