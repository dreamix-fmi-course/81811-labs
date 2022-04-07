package labs.week3.task1;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileManagement {

    private final Map<String, File> files = new HashMap<>();

    public void makeFile(String... args) {
        if (args.length != 3) {
            System.out.println("Invalid args count");
            return;
        }

        if (args[2].startsWith("CONTENT")) {
            String content = args[2].substring(args[2].indexOf("=") + 1);

            if (args[0].contains(".")) {
                String extension = args[0].substring(args[0].indexOf("."));
                if (extension.equals("avi") || extension.equals("mp3")) {
                    files.put(args[0], new MediaContentFile(args[0], args[1], LocalDate.now(), content));
                } else {
                    files.put(args[0], new DocumentContentFile(args[0], args[1], LocalDate.now(), content));
                }
            }

            files.put(args[0], new ContentFile(args[0], args[1], LocalDate.now(), content));
        } else {
            createExecutableFile(args[0], args[1], args[2]);
        }

    }

    private void createExecutableFile(String name, String location, String arg) {
        List<String> resources = Arrays.asList(arg.substring(1, arg.length() - 2).split(","));
        files.put(name, new ExecutableFile(name, location, LocalDate.now(), resources, LocalDate.now()));
        System.out.println(files.size());
    }

    public void copy(String... args) {
        if (args.length != 2) {
            System.out.println("Invalid args count");
            return;
        }

        File file = files.get(args[0]);
        if (file == null) {
            System.out.println("File not found");
        } else {
            File copyFile = file.copy(args[1]);
            files.put(copyFile.getName(), copyFile);
        }
    }

    public void delete(String... args) {
        if (args.length != 1) {
            System.out.println("Invalid args count");
            return;
        }

        File file = files.get(args[0]);
        if (file == null) {
            System.out.println("File not found");
        } else {
            file.delete();
            files.remove(file.getName());
        }
    }

    public void execute(String... args) {
        if (args.length != 1) {
            System.out.println("Invalid args count");
            return;
        }

        File file = files.get(args[0]);
        if (file == null) {
            System.out.println("File not found");
        } else {
            file.execute();
        }
    }

    public void modify(String... args) {
        if (args.length != 2) {
            System.out.println("Invalid args count");
            return;
        }

        File file = files.get(args[0]);
        if (file == null) {
            System.out.println("File not found");
        } else {
            file.modify(args[1]);
            files.put(file.getName(), file);
        }
    }

    public void getInfo(String... args) {
        if (args.length != 1) {
            System.out.println("Invalid args count");
            return;
        }

        File file = files.get(args[0]);
        if (file == null) {
            System.out.println("File not found");
        } else {
            System.out.println(file.getInfo());
        }

    }

    public void move(String... args) {
        if (args.length != 2) {
            System.out.println("Invalid args count");
            return;
        }

        File file = files.get(args[0]);
        if (file == null) {
            System.out.println("File not found");
        } else {
            file.move(args[1]);
        }
    }
}
