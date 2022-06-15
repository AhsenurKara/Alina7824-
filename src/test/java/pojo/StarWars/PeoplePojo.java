package pojo.StarWars;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PeoplePojo {
    private int count;
    private String next;
    private String previous;
    private List<DescPeople> results;
}
