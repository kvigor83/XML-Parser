package by.kastsiuchenka.third.сreator;

import by.kastsiuchenka.third.entity.Toy;
import by.kastsiuchenka.third.exception.CreatorException;


public abstract class AbstractToyCreator {
    public abstract Toy createToy(String[] dataString) throws CreatorException;
}

