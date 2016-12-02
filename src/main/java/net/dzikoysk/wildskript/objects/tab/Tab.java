package net.dzikoysk.wildskript.objects.tab;

import java.util.ArrayList;
import java.util.List;

public class Tab {

    private final String id;
    private final String[] prefix;
    private final String[] center;
    private final String[] suffix;
    private List<String> fields;
    private String[][] backup;
    private boolean sent;

    protected Tab(String id) {
        this.id = id;
        this.prefix = new String[60];
        this.center = new String[60];
        this.suffix = new String[60];
        this.fields = new ArrayList<>();
        TabUtils.add(this);
    }

    public void set(int i, String s) {
        if (i >= 60) {
            return;
        }
        String[] ss = s.split("(?<=\\G................)");
        if (ss.length >= 3) {
            prefix[i] = ss[0];
            center[i] = ss[1];
            suffix[i] = ss[2];
        }
        else if (ss.length == 2) {
            prefix[i] = ss[0];
            center[i] = ss[1];
            suffix[i] = "";
        }
        else if (ss.length == 1) {
            prefix[i] = "";
            center[i] = ss[0];
            suffix[i] = "";
        }
    }

    public void fill() {
        for (int i = 0; i < center.length; i++) {
            if (center[i] == null || center[i].isEmpty()) {
                center[i] = TabUtils.uniqueField(this);
            }
            if (prefix[i] == null) {
                prefix[i] = "";
            }
            if (suffix[i] == null) {
                suffix[i] = "";
            }
        }
    }

    protected void fields(List<String> fields) {
        this.fields = fields;
    }

    public void backup(String[] prefix, String[] center, String[] suffix) {
        this.backup = new String[][]{ prefix.clone(), center.clone(), suffix.clone() };
    }

    public void backup() {
        this.backup = new String[][]{ prefix.clone(), center.clone(), suffix.clone() };
    }

    public void sent(boolean b) {
        this.sent = b;
    }

    public boolean isSent() {
        return sent;
    }

    public String[][] getRows() {
        return new String[][]{ prefix.clone(), center.clone(), suffix.clone() };
    }

    public String[] getPrefix() {
        return prefix.clone();
    }

    public String[] getCenter() {
        return center.clone();
    }

    public String[] getSuffix() {
        return suffix.clone();
    }

    public String[][] getBackup() {
        return backup.clone();
    }

    public List<String> getFields() {
        return fields;
    }

    public String getID() {
        return this.id;
    }
}
