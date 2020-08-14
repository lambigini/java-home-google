package swb.ch16table.mapper;

import swb.framework.Element;
import swb.ch16table.domain.City;

import java.util.List;
import java.util.function.Function;

public class CityMapper {

    public final static Function<List<Element>, City> MAPPER_LAMBDA =
        cells ->
            new City(Integer.parseInt(cells.get(0).getText()),
                cells.get(1).getText(),
                cells.get(2).getText());
}