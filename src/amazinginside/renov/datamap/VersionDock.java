package amazinginside.renov.datamap;

/**
 * Created by Sangeeth Nandakumar on 28-11-2017.
 */
public class VersionDock {
    String name;
    String version;
    String provider;
    String updated;

    public VersionDock(String name, String version, String provider, String updated) {
        this.name = name;
        this.version = version;
        this.provider = provider;
        this.updated = updated;
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    public String getProvider() {
        return provider;
    }

    public String getUpdated() {
        return updated;
    }
}
