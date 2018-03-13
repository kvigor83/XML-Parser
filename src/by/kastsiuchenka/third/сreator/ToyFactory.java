package by.kastsiuchenka.third.сreator;


import by.kastsiuchenka.third.entity.Toy;
import by.kastsiuchenka.third.entity.ToyType;
import by.kastsiuchenka.third.exception.CreatorException;

public class ToyFactory {

    public static Toy createToyFromFactory(String[] dataString) throws CreatorException {

        ToyType toyType= ToyType.valueOf(dataString[9].toUpperCase());

        switch (toyType) {
            case TRANSPORT_TOY:
                return new TransportAbstractToyCreator().createToy(dataString);
            case MUSIC_TOY:
                return new MusicAbstractToyCreator().createToy(dataString);
            default:
                throw new CreatorException(toyType.name());

        }
    }


}