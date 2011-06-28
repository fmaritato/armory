package com.maritatf.wow;
/**
 * @author fmaritato
 */

import com.maritatf.wow.value.Realm;
import com.maritatf.wow.value.RealmList;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jibble.pircbot.IrcException;
import org.jibble.pircbot.PircBot;
import org.kohsuke.args4j.Option;
import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.CmdLineException;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class WowBot extends PircBot {

    private static transient Log log = LogFactory.getLog(WowBot.class);

    @Option(name = "--hostname")
    private String hostname;

    @Option(name = "--username")
    private String username;

    @Option(name = "--password")
    private String password;

    @Option(name = "--port")
    private int port;

    @Option(name = "--channel")
    private String channel;

    @Argument
    private List<String> arguments = new ArrayList<String>();

    public WowBot() {
    }

    public void onMessage(String channel,
                          String sender,
                          String login,
                          String hostname,
                          String message) {

        String[] command = message.split(" ");
        if (command == null || !command[0].equals("wowbot:")) {
            return;
        }
        if (command[1].equals("help") ||
            command.length < 3) {
            sendHelpMessage(channel);
            return;
        }

        if (command[1].equals("rs")) {
            sendRealmStatus(channel, command);
        }
        else if (command[1].equals("c")) {
            sendCharacterInfo(channel, command);
        }
        else if (command[1].equals("g")) {
            sendGuildInfo(channel, command);
        }

    }

    private void sendGuildInfo(String channel, String[] command) {
        //To change body of created methods use File | Settings | File Templates.
    }

    private void sendCharacterInfo(String channel, String[] command) {
        //To change body of created methods use File | Settings | File Templates.
    }

    private void sendRealmStatus(String channel, String[] command) {
        if (command.length == 3) {
            Realm r = null;
            try {
                r = ArmoryUtil.getRealmStatus(command[2]);
                sendMessage(channel, r.toString());
            }
            catch (ArmoryException e) {
                log.error(e.getMessage(), e);
                sendMessage(channel, e.getMessage());
            }
            catch (IOException e) {
                log.error(e.getMessage(), e);
                sendMessage(channel, e.getMessage());
            }
        }
    }


    private void sendHelpMessage(String channel) {
        String msg = "rs [realm] -- returns realm status";
        sendMessage(channel, msg);
        msg = "help -- provide a help message";
        sendMessage(channel, msg);
    }

    private void doMain(String[] args) throws IOException, IrcException {
        CmdLineParser parser = new CmdLineParser(this);
        try {
            // parse the arguments.
            parser.parseArgument(args);
        }
        catch (CmdLineException e) {
            log.error(e.getMessage(), e);
        }

        this.setName(username);
        setVerbose(true);
        setLogin(username);
        connect(hostname, port, password);
        joinChannel(channel);
    }

    public static void main(String[] args) throws IOException, IrcException {
        WowBot bot = new WowBot();
        bot.doMain(args);
    }
}
