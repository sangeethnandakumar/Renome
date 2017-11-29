package amazinginside.renov.xmlmap;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import amazinginside.renov.datamap.VersionDock;
import org.jdom.input.SAXBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

/**
 * Created by Sangeeth Nandakumar on 28-11-2017.
 */

public class MetaFactory {
    SAXBuilder saxBuilder;
    File inputFile;
    DocumentBuilderFactory dbFactory;
    DocumentBuilder dBuilder;
    Document doc;
    List<VersionDock> versionDockList;

    String META_FILE="C:\\Users\\Sangeeth Nandakumar\\IdeaProjects\\Renome\\src\\amazinginside\\renov\\metaversion.xml";
    String metaRoot;

    public MetaFactory() {
        versionDockList=new ArrayList<>();
    }

    public List<VersionDock> parseVersions()
    {
        try
        {
            //Clear Versionlist
            versionDockList.clear();
            //Identify Versions
            saxBuilder = new SAXBuilder();
            inputFile = new File(META_FILE);
            dbFactory = DocumentBuilderFactory.newInstance();
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList components = doc.getElementsByTagName("component");
            for (int i = 0; i < components.getLength(); i++)
            {
                Node component = components.item(i);
                if (component.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element element = (Element) component;
                    //Add component versions
                    versionDockList.add(new VersionDock(
                            element.getAttribute("name"),
                            element.getAttribute("version"),
                            element.getAttribute("provider"),
                            element.getAttribute("updated")));
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return versionDockList;
    }

    public String getRoot()
    {
        try
        {
            metaRoot="";
            saxBuilder = new SAXBuilder();
            inputFile = new File(META_FILE);
            dbFactory = DocumentBuilderFactory.newInstance();
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            metaRoot= doc.getDocumentElement().getNodeName();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return metaRoot;
    }
}
