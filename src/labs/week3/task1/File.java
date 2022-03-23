package labs.week3.task1;

import java.time.LocalDate;

public abstract class File {
    protected static final String copyFileName = "%s_(%d)";
    protected int copyFileCounter = 0;

    private final String name;
    private String location;
    private final LocalDate creationDate;
    private boolean isDeleted;

    public File(String name, String location, LocalDate creationDate) {
        this.name = name;
        this.location = location;
        this.creationDate = creationDate;
    }

    public void move(String newLocation) {
        this.location = newLocation;
    }

    public abstract File copy(String newLocation);

    public abstract void execute();

    public abstract void modify(String newData);

    public void delete() {
        this.isDeleted = true;
    }

    public abstract String getInfo();

    public String getName() {
        return name;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public String getLocation() {
        return location;
    }
}
