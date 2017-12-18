package org.airsonic.player.service.metadata;

import java.io.File;
import junit.framework.TestCase;
import org.airsonic.player.service.SettingsService;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author manuel müller <manuel.mueller@geekinbusiness.de>
 */
public class JaudiotaggerParserTest extends TestCase {

    private static Logger LOG = LoggerFactory.getLogger(JaudiotaggerParserTest.class);

    //@TODO Starkad add other File with Lyrics
    private final static String testFilePath = "src" + File.separator + "test"
            + File.separator + "resources" + File.separator
            + "MEDIAS" + File.separator + "piano.mp3";

    private static SettingsService settingServiceMock;

    public JaudiotaggerParserTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        settingServiceMock = Mockito.mock(SettingsService.class);
    }

    /**
     * Test of getRawMetaData method, of class JaudiotaggerParser.
     */
    @Test
    public void testGetRawMetaDataPositiv() {

        File file = new File(testFilePath);

        JaudiotaggerParser instance = new JaudiotaggerParser(settingServiceMock);

        MetaData expResult = new MetaData();
        expResult.setLyrics("[piano_playing]");
        expResult.setBitRate(128);
        expResult.setDurationSeconds(6);
        expResult.setGenre("Blues");
        expResult.setVariableBitRate(false);
        expResult.setYear(-1);

        MetaData result = instance.getRawMetaData(file);

//        Assertions.assertThat(result).isEqualToComparingFieldByField(expResult);
    }

}
