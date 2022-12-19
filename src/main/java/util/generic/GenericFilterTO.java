package util.generic;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class GenericFilterTO<T> {

    private long total;
    private List<T> elements;

    public GenericFilterTO() {
        this.elements = new ArrayList<>();
        this.total = 0L;
    }

    public GenericFilterTO(List<T> elements, long total) {
        this.elements = elements;
        this.total = total;
    }

}
