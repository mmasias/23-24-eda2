import java.util.Objects;

public class Keywords {
    private String keyword;

    public Keywords(String keyword) {
        this.keyword = keyword;
    }

    public String getKeyword() {
        return keyword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Keywords keywords = (Keywords) o;
        return Objects.equals(keyword, keywords.keyword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(keyword);
    }

    @Override
    public String toString() {
        return keyword;
    }
}

