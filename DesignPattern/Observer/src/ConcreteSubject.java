import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.concurrent.TimeUnit;

public class ConcreteSubject extends Subject {
    private final String fileName;
    private final File file;
    private WatchService watchService;

    public ConcreteSubject(String fileName) {
        this.fileName = fileName;
        this.file = new File(fileName);
        try {
            this.watchService = FileSystems.getDefault().newWatchService();
            Paths.get(fileName).getParent().register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getFileName() {
        return fileName;
    }

    public long getLastModified() {
        return this.lastModified;
    }

    public void monitor() {
        while (true) {
            WatchKey key;
            try {
                key = watchService.poll(1, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                return;
            }

            if (key != null) {
                for (WatchEvent<?> event : key.pollEvents()) {
                    if (event.kind() == StandardWatchEventKinds.ENTRY_MODIFY
                            && event.context().toString().equals(file.getName())) {
                        notifyObservers();
                    }
                }
                key.reset();
            }
        }
    }
}
