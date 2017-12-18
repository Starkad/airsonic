package org.airsonic.player.service;

import org.airsonic.player.domain.MediaFile;
import org.airsonic.player.service.metadata.MetaData;
import org.airsonic.player.service.metadata.MetaDataParser;
import org.airsonic.player.service.metadata.MetaDataParserFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class MetaDataService {

    @Autowired
    private MetaDataParserFactory metaDataParserFactory;

    public MetaData getMetaDate(MediaFile mediaFile) {
        File file = mediaFile.getFile();
        MetaDataParser parser = metaDataParserFactory.getParser(file);

        MetaData metaData = parser.getMetaData(file);
        return metaData;
    }
}
