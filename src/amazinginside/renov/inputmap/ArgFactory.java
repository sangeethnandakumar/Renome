package amazinginside.renov.inputmap;

import amazinginside.renov.datamap.VersionDock;
import amazinginside.renov.xmlmap.MetaFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sangeeth Nandakumar on 28-11-2017.
 */
public class ArgFactory {
    String[] args;
    int ARG_COUNT=0;
    String argBase;

    public ArgFactory(String[] args) {
        //Recive arg array
        this.args = args;
        //Count no: of args
        ARG_COUNT=args.length;
        //Set base arg
        argBase=args[0];
        //Start Mapping
        argMapper();
    }

    public void argMapper()
    {
        switch (argBase)
        {
            case "-version":
                //Print RenomeVersion
                MetaFactory metaFactory=new MetaFactory();
                List<VersionDock> versionDockList=new ArrayList<>();
                versionDockList=metaFactory.parseVersions();
                for (int i=0;i<versionDockList.size();i++)
                {
                    System.out.println("Component : "+versionDockList.get(i).getName());
                    System.out.println("Current Version : "+versionDockList.get(i).getVersion());
                    System.out.println("Provided By : "+versionDockList.get(i).getProvider());
                    System.out.println("Last Updated : "+versionDockList.get(i).getUpdated()+"\n");
                }
                break;
            default:
                //Print ArgsException
                System.out.println("Unspecified Command");
                break;
        }
    }

}
