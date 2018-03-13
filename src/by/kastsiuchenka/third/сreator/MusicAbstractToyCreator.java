package by.kastsiuchenka.third.сreator;

import by.kastsiuchenka.third.entity.*;
import by.kastsiuchenka.third.exception.CreatorException;

public class MusicAbstractToyCreator extends AbstractToyCreator {

    @Override
    public Toy createToy(String[] dataString) throws CreatorException {
        Toy.ExternalParameter externalParameter = new Toy.ExternalParameter(Integer.parseInt(dataString[4]),
                Integer.parseInt(dataString[5]), Integer.parseInt(dataString[6]), Integer.parseInt(dataString[7]));
        Material material = Material.valueOf(dataString[2].toUpperCase());
        ToyType toyType = ToyType.valueOf(dataString[9].toUpperCase());
        TypeMusicToy typeMusicToy = TypeMusicToy.valueOf(dataString[10].toUpperCase());
        Colour colour = Colour.valueOf(dataString[12].toUpperCase());
        Toy toy = new MusicToy(dataString[0], dataString[1], material, Double.parseDouble(dataString[3]),
                externalParameter, dataString[8], toyType, typeMusicToy, Integer.parseInt(dataString[11]),
                colour, Boolean.parseBoolean(dataString[3]));
        return toy;
    }
}
