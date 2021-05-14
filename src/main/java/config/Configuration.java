package config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.LoadType;

@LoadPolicy(LoadType.MERGE)
@Config.Sources({
    "system:properties",
    "classpath:general.properties",
    "classpath:local.properties",
    "classpath:grid.properties",
    "classpath:datadriven.properties"})
public interface Configuration extends Config {

    @Key("target")
    String target();

    @Key("browser")
    String browser();

    @Key("headless")
    Boolean headless();

    @Key("url.base")
    String url();

    @Key("timeout")
    int timeout();

    @Key("grid.url")
    String gridUrl();

    @Key("grid.port")
    String gridPort();

    @Key("faker.locale")
    String faker();
    
    @Key("excel.data.file")
    String excelDataFile();

    @Key("excel.data.sheet")
    String excelDataSheet();

    @Key("excel.total.cols")
    String excelTotalCols();
}
