package ITSpaceAcademy.chapters.chapter14.map;

import java.util.Objects;

public final class ImmutableCompany {
    private final String id;
    private final String name;
    private final Person director;

    public ImmutableCompany(String id, String name, Person director) {
        this.id = id;
        this.name = name;
        this.director = new Person(director.getName(),director.getSurname());
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Person getDirector() {
        return new Person(director.getName(),director.getSurname());
    }

    @Override
    public String toString() {
        return "ImmutableCompany{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", director=" + director +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ImmutableCompany)) return false;
        ImmutableCompany that = (ImmutableCompany) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getName(), that.getName()) && Objects.equals(getDirector(), that.getDirector());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDirector());
    }
}
