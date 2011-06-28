package com.maritatf.wow;
/**
 * @author fmaritato
 */

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xpath.XPathAPI;
import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class AchievementList {

    private static transient Log log = LogFactory.getLog(AchievementList.class);

    private static final String ARMORY_LINK =
            "http://www.wowarmory.com/character-achievements.xml?";
    private static final String CHAR_OPT = "&cn=";
    private static final String REALM_OPT = "r=";
    private static final String GUILD_OPT = "&gn=";
    private static final String POINTS = "/page/characterInfo/character/@points";

    @Option(name = "-r", usage = "Realm name", required = true)
    private String realm;

    @Option(name = "-c", usage = "Character names to compare")
    private List<String> names;

    @Option(name = "-g", usage = "Guild name")
    private String guild;

    @Option(name = "-f", usage = "XML File")
    private String file;

    @Argument
    private List<String> arguments = new ArrayList<String>();

    private TreeSet<Toon> achData = new TreeSet<Toon>();

    public void run() {
        if (file != null) {
            processData(file);
            return;
        }
        HttpClient client = new HttpClient();
        client.getParams()
                .setParameter(HttpMethodParams.USER_AGENT, "Firefox/2.0");

        for (String n : names) {
            log.info(n);
            StringBuilder buf = new StringBuilder()
                    .append(ARMORY_LINK)
                    .append(REALM_OPT).append(realm)
                    .append(CHAR_OPT).append(n);
            if (log.isDebugEnabled()) {
                log.debug(buf.toString());
            }
            HttpMethod method = new GetMethod(buf.toString());

            try {
                // Execute the method.
                int statusCode = client.executeMethod(method);

                if (statusCode != HttpStatus.SC_OK) {
                    System.err.println("Method failed: " + method.getStatusLine());
                }

                // Read the response body.
                String resp = new String(method.getResponseBody());
                if (log.isDebugEnabled()) {
                    log.debug(resp);
                }

                DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
                Document doc = docBuilder.parse(new InputSource(new StringReader(resp)));
                doc.getDocumentElement().normalize();
                Integer points = Integer.parseInt(XPathAPI.eval(doc, POINTS).toString());
                achData.add(new Toon(n, points));

            }
            catch (IOException e) {
                log.error(e.getMessage(), e);
            }
            catch (ParserConfigurationException e) {
                log.error(e.getMessage(), e);
            }
            catch (SAXException e) {
                log.error(e.getMessage(), e);
            }
            catch (TransformerException e) {
                log.error(e.getMessage(), e);
            }
        }
        for (Toon t : achData.descendingSet()) {
            log.info(t.getName()+"        "+t.getPoints());                    
        }
    }

    public void processData(String filename) {
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = null;
        try {
            docBuilder = docBuilderFactory.newDocumentBuilder();

            Document doc = docBuilder.parse(new InputSource(new FileReader(filename)));
            doc.getDocumentElement().normalize();
            String str = XPathAPI.eval(doc, POINTS).toString();
            log.debug(str);
        }
        catch (ParserConfigurationException e) {
            log.error(e.getMessage(), e);
        }
        catch (TransformerException e) {
            log.error(e.getMessage(), e);
        }
        catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        catch (SAXException e) {
            log.error(e.getMessage(), e);
        }
    }

    public static void main(String[] args) {
        AchievementList l = new AchievementList();
        l.doMain(args);
        l.run();
    }

    private void doMain(String[] args) {
        CmdLineParser parser = new CmdLineParser(this);
        try {
            // parse the arguments.
            parser.parseArgument(args);
        }
        catch (CmdLineException e) {
            log.error(e.getMessage(), e);
        }
    }

    class Toon implements Comparable {
        String name;
        Integer points;

        Toon(String name, Integer points) {
            this.name = name;
            this.points = points;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getPoints() {
            return points;
        }

        public void setPoints(Integer points) {
            this.points = points;
        }

        public int compareTo(Object o) {
            return points.compareTo(((Toon)o).getPoints());
        }

        @Override
        public String toString() {
            return "Toon{" +
                   "name='" + name + '\'' +
                   ", points=" + points +
                   '}';
        }
    }
}
