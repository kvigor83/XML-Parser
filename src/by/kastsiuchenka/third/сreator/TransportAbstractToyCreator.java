package by.kastsiuchenka.third.сreator;

import by.kastsiuchenka.third.entity.*;
import by.kastsiuchenka.third.exception.CreatorException;

public class TransportAbstractToyCreator extends AbstractToyCreator {
   
    @Override
    public Toy createToy(String[] dataString) throws CreatorException {
        Toy.ExternalParameter externalParameter = new Toy.ExternalParameter(Integer.parseInt(dataString[4]),
                Integer.parseInt(dataString[5]), Integer.parseInt(dataString[6]), Integer.parseInt(dataString[7]));
        Material material = Material.valueOf(dataString[2].toUpperCase());
        ToyType toyType = ToyType.valueOf(dataString[9].toUpperCase());
        TypeTransportToy typeTransportToy = TypeTransportToy.valueOf(dataString[10].toUpperCase());
        TypeControl typeControl = TypeControl.valueOf(dataString[11].toUpperCase());
        Colour colour = Colour.valueOf(dataString[12].toUpperCase());
        Toy toy = new TransportToy(dataString[0], dataString[1], material, Double.parseDouble(dataString[3]),
                externalParameter, dataString[8], toyType, typeTransportToy, typeControl, colour,
                Integer.parseInt(dataString[13]),dataString[14]);
        return toy;
    }
}
