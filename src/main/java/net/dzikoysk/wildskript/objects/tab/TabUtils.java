package net.dzikoysk.wildskript.objects.tab;

import net.dzikoysk.wildskript.util.PacketUtils;
import net.dzikoysk.wildskript.util.ReflectionUtils;
import net.dzikoysk.wildskript.util.User;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TabUtils {

    private static List<Tab> list = new ArrayList<>();
    private static final Class<?> packetClass;
    private static final Class<?>[] typesClass;
    private static final String[] colorsCode;

    static {
        packetClass = ReflectionUtils.getCraftClass("PacketPlayOutPlayerInfo");
        typesClass = new Class<?>[]{ String.class, boolean.class, int.class };
        colorsCode = new String[]{ "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
    }

    protected static void add(Tab t) {
        list.add(t);
    }

    protected static void remove(Tab t) {
        list.remove(t);
    }

    public static List<Tab> getTabs() {
        return list;
    }

    public static Tab get(String id) {
        for (Tab t : list) {
            if (t.getID().equals(id)) {
                return t;
            }
        }
        return new Tab(id);
    }

    @SuppressWarnings("deprecation")
    public static void sendTab(Tab tab, User user) throws Exception {
        Scoreboard sb = user.getScoreboard();
        if (tab.isSent()) {
            PacketUtils.sendPacket(user.getPlayer(), packets(tab.getBackup()[1], false));
        }
        Player[] ps = Bukkit.getOnlinePlayers().toArray(new Player[Bukkit.getOnlinePlayers().size()]);
        String[] ss = new String[ps.length];
        for (int i = 0; i < ps.length; i++) {
            ss[i] = ps[i].getPlayerListName();
        }
        PacketUtils.sendPacket(user.getPlayer(), packets(ss, false));
        tab.fill();
        String[][] rows = tab.getRows();
        PacketUtils.sendPacket(user.getPlayer(), packets(tab.getCenter(), true));
        for (int i = 0; i < 60; i++) {
            String center = rows[1][i];
            Team team = sb.getTeam(center);
            if (team == null) {
                team = sb.registerNewTeam(center);
            }
            team.setPrefix(rows[0][i]);
            team.setSuffix(rows[2][i]);
            team.addPlayer(Bukkit.getOfflinePlayer(center));
        }
        tab.backup();
        user.setScoreboard(sb);
        tab.sent(true);
    }

    public static Object[] packets(String[] ss, boolean b) throws Exception {
        Object[] packets = new Object[ss.length];
        for (int i = 0; i < ss.length; i++) {
            packets[i] = TabUtils.getPacket(ss[i], b, 0);
        }
        return packets;
    }

    public static Object getPacket(String text, boolean b, int i) throws Exception {
        return packetClass.getConstructor(typesClass).newInstance(text, b, i);
    }

    protected static String uniqueField(Tab tab) {
        List<String> fields = tab.getFields();
        Random random = new Random();
        String s = "";
        if (!fields.contains(s)) {
            fields.add(s);
        }
        while (fields.contains(s)) {
            String r = colorsCode[random.nextInt(colorsCode.length)];
            s = s + "�" + r;
            if (s.length() > 16) {
                s = "";
            }
        }
        fields.add(s);
        tab.fields(fields);
        return s;
    }
}
