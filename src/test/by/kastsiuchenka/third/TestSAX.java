package test.by.kastsiuchenka.third;

import by.kastsiuchenka.third.sax.ToySAXBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class TestSAX {
    private static Logger testLogger = LogManager.getRootLogger();
    private final String FILE_NAME_SAX = "data/toys.xml";


    @Test(enabled = true, priority=1)
    public void testSAX() {
        ToySAXBuilder saxBuilder = new ToySAXBuilder();
        saxBuilder.buildSetToys(FILE_NAME_SAX);
        int numberСreatedToys  = saxBuilder.getToys().size();
        testLogger.info(saxBuilder.getToys());
        AssertJUnit.assertEquals(16, numberСreatedToys);
    }

}
