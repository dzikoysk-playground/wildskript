package net.dzikoysk.wildskript.util;

import org.bukkit.Bukkit;

import java.io.*;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.zip.GZIPOutputStream;

public class MetricsLite {

	private static List<MetricsLite> list = new ArrayList<>();
	
    private final static int REVISION = 7;
    private static final String BASE_URL = "http://report.mcstats.org";
    private static final String REPORT_URL = "/plugin/%s";
    private final static int PING_INTERVAL = 10;
    private final Object optOutLock = new Object();
    private Timer timer; 
    
    private final String name;
    private String version;

    private MetricsLite(String name){
        this.name = name;
        timer = new Timer();
        list.add(this);
    }
    
    public static MetricsLite get(String name){
    	for(MetricsLite mcs : list) if(mcs.getName().equalsIgnoreCase(name)) return mcs;
    	return new MetricsLite(name);
    }
    
    public MetricsLite version(String version){
    	this.version = version;
    	return this;
    }
    
    public String getName(){
    	return this.name;
    }
    
    public boolean start() {
        synchronized (optOutLock) {
            if (isOptOut()) return false;
            if (timer != null) return true;
            timer.schedule( new TimerTask(){
                private boolean firstPost = true;
                public void run() {
                    try {
                        synchronized (optOutLock) {
                            if (isOptOut() && timer != null) {
                                timer.cancel();
                                timer = null;
                            }
                        }
                        postPlugin(!firstPost);
                        firstPost = false;
                    } catch (IOException e) { }
                }
            }, 0, PING_INTERVAL * 1200);
            return true;
        }
    }

    public boolean isOptOut() {
        synchronized (optOutLock){
        	return false;
        }
    }

    public void enable() throws IOException {
        synchronized (optOutLock) {
            if (timer == null) start();
        }
    }

    public void disable() throws IOException {
        synchronized (optOutLock) {
            if (timer != null) {
                timer.cancel();
                timer = null;
            }
        }
    }

    private void postPlugin(boolean isPing) throws IOException {
        String pluginName = "WS " + name;
        boolean onlineMode = Bukkit.getOnlineMode();
        String pluginVersion = version;
        String serverVersion = Bukkit.getVersion();
        int playersOnline = Bukkit.getOnlinePlayers().size();

        StringBuilder json = new StringBuilder(1024);
        json.append('{');

        appendJSONPair(json, "guid", pluginName);
        appendJSONPair(json, "plugin_version", pluginVersion);
        appendJSONPair(json, "server_version", serverVersion);
        appendJSONPair(json, "players_online", Integer.toString(playersOnline));

        String osname = System.getProperty("os.name");
        String osarch = System.getProperty("os.arch");
        String osversion = System.getProperty("os.version");
        String java_version = System.getProperty("java.version");
        int coreCount = Runtime.getRuntime().availableProcessors();

        if (osarch.equals("amd64")) osarch = "x86_64";
        
        appendJSONPair(json, "osname", osname);
        appendJSONPair(json, "osarch", osarch);
        appendJSONPair(json, "osversion", osversion);
        appendJSONPair(json, "cores", Integer.toString(coreCount));
        appendJSONPair(json, "auth_mode", onlineMode ? "1" : "0");
        appendJSONPair(json, "java_version", java_version);

        if (isPing) appendJSONPair(json, "ping", "1");
        json.append('}');
        URL url = new URL(BASE_URL + String.format(REPORT_URL, urlEncode(pluginName)));
        URLConnection connection;
        if (isMineshafterPresent()) connection = url.openConnection(Proxy.NO_PROXY);
        else  connection = url.openConnection();
        byte[] compressed = gzip(json.toString());
        connection.addRequestProperty("User-Agent", "MCStats/" + REVISION);
        connection.addRequestProperty("Content-Type", "application/json");
        connection.addRequestProperty("Content-Encoding", "gzip");
        connection.addRequestProperty("Content-Length", Integer.toString(compressed.length));
        connection.addRequestProperty("Accept", "application/json");
        connection.addRequestProperty("Connection", "close");
        connection.setDoOutput(true);
        OutputStream os = connection.getOutputStream();
        os.write(compressed);
        os.flush();
        final BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String response = reader.readLine();
        os.close();
        reader.close();
        if (response == null || response.startsWith("ERR") || response.startsWith("7")) {
            if (response == null) response = "null";
            else if (response.startsWith("7")) response = response.substring(response.startsWith("7,") ? 2 : 1);
            throw new IOException(response);
        }
    }

    public static byte[] gzip(String input) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        GZIPOutputStream gzos = null;
        try {
            gzos = new GZIPOutputStream(baos);
            gzos.write(input.getBytes("UTF-8"));
        } catch (IOException e) { e.printStackTrace();
        } finally {
            if (gzos != null) try {
                gzos.close();
            } catch (IOException ignore) {
            }
        }
        return baos.toByteArray();
    }

    private boolean isMineshafterPresent() {
        try {
            Class.forName("mineshafter.MineServer");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static void appendJSONPair(StringBuilder json, String key, String value) throws UnsupportedEncodingException {
        boolean isValueNumeric = false;
        try {
            if (value.equals("0") || !value.endsWith("0")) {
                Double.parseDouble(value);
                isValueNumeric = true;
            }
        } catch (NumberFormatException e) {
            isValueNumeric = false;
        }
        if (json.charAt(json.length() - 1) != '{')  json.append(',');
        json.append(escapeJSON(key));
        json.append(':');
        if (isValueNumeric) json.append(value);
        else json.append(escapeJSON(value));
    }

    private static String escapeJSON(String text) {
        StringBuilder builder = new StringBuilder();
        builder.append('"');
        for (int index = 0; index < text.length(); index++) {
            char chr = text.charAt(index);
            switch (chr) {
                case '"':
                case '\\':
                    builder.append('\\');
                    builder.append(chr);
                    break;
                case '\b':
                    builder.append("\\b");
                    break;
                case '\t':
                    builder.append("\\t");
                    break;
                case '\n':
                    builder.append("\\n");
                    break;
                case '\r':
                    builder.append("\\r");
                    break;
                default:
                    if (chr < ' ') {
                        String t = "000" + Integer.toHexString(chr);
                        builder.append("\\u" + t.substring(t.length() - 4));
                    } else builder.append(chr);
                    break;
            }
        }
        builder.append('"');
        return builder.toString();
    }
    
    private static String urlEncode(final String text) throws UnsupportedEncodingException {
        return URLEncoder.encode(text, "UTF-8");
    }

}