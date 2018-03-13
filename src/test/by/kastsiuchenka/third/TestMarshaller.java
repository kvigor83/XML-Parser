package test.by.kastsiuchenka.third;

import by.kastsiuchenka.third.entity.Toys;
import by.kastsiuchenka.third.exception.CreatorException;
import by.kastsiuchenka.third.marshal.MarshalActionToy;
import by.kastsiuchenka.third.сreator.ToyFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestMarshaller {
    MarshalActionToy actionToy;
    private static Logger testLogger = LogManager.getRootLogger();
    private final String FILE_NAME_MARSHALLER = "data/toys_marshaller.xml";
    private final String FILE_NAME_UNMARSHALLER = "data/toys.xml";
    private final String SCHEMA_NAME= "data/toy.xsd";


    @BeforeClass
    private void setUp() {
        actionToy = new MarshalActionToy();
    }

    @Test
    public void testMarshaller() {

        String[] dataToy1 = new String[]{"dudka", "polesie", "PLASTIC", "7.50", "300", "15", "15", "15", "t1",
                "MUSIC_TOY", "PIPE", "12", "YELLOW", "true"};
        String[] dataToy2 = new String[]{"molniya", "polesie", "PLASTIC", "12.00", "250", "15", "15", "25", "t2",
                "TRANSPORT_TOY", "SPORTCAR", "MANUAL", "RED", "4", "1:15"};
        try {
            Toys toys = new Toys() {
                {
                    this.addToy(ToyFactory.createToyFromFactory(dataToy1));
                    this.addToy(ToyFactory.createToyFromFactory(dataToy2));
                }
            };
            actionToy.saveWithMarshaller(toys,FILE_NAME_MARSHALLER);

        } catch (CreatorException e) {
            testLogger.error("Creation XML-file error",e);
        }
    }

    @Test(enabled = false, priority=1)
    public void testUnMarshalWithXSD() {
        Toys toys=actionToy.useUnMarshalWithXSD(FILE_NAME_UNMARSHALLER,SCHEMA_NAME);
        testLogger.info(toys.toString());
        int numberСreatedToys = toys.getSize();
        AssertJUnit.assertEquals(16, numberСreatedToys);
    }

}
