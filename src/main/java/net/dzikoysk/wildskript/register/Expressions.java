package net.dzikoysk.wildskript.register;

import net.dzikoysk.wildskript.expressions.*;
import net.dzikoysk.wildskript.expressions.bukkit.*;
import net.dzikoysk.wildskript.expressions.files.*;
import net.dzikoysk.wildskript.expressions.system.ExprFreeMemory;
import net.dzikoysk.wildskript.expressions.system.ExprMaxMemory;
import net.dzikoysk.wildskript.expressions.system.ExprTPS;
import net.dzikoysk.wildskript.expressions.system.ExprTotalMemory;
import net.dzikoysk.wildskript.util.doc.Element;
import net.dzikoysk.wildskript.util.doc.Type;

public class Expressions {

    public static void register() {

        RegisterManager.registerExpression(new Element(Type.EXPRESSION)
                .name("Connect Result")
                .version("1.2")
                .desc("Returns content of page into single string. Note that if this is a page with HTML, it will also be downloaded.")
                .example("set {_result} to result of connect to " + '"' + "raw.dzikoysk.net/text.txt" + '"')
                .usage(new String[]{
                        "result of connect to %string%"
                }), ExprConnectResult.class, String.class);

        RegisterManager.registerExpression(new Element(Type.EXPRESSION)
                .name("Ping")
                .version("1.5")
                .desc("Returns ping of player.")
                .example("set {_ping} to player's ping")
                .usage(new String[]{
                        "%player%'s ping"
                }), ExprPing.class, Integer.class);

        RegisterManager.registerExpression(new Element(Type.EXPRESSION)
                .name("Calendar")
                .version("1.5")
                .desc("Returns the interesting part of the date. Rememver - This is system time!")
                .example("set {_time} to " + '"' + "%hour%:%minutes%" + '"')
                .usage(new String[]{
                        "year",
                        "month",
                        "day",
                        "hour",
                        "minute[s]",
                        "second[s]",
                        "millisecond[s]"
                }), ExprCalendar.class, Integer.class);

        RegisterManager.registerExpression(new Element(Type.EXPRESSION)
                .name("Random Color")
                .version("1.5")
                .desc("Returns random color (&5, &3, &a, &b etc.)")
                .example("player.sendPacket{PacketPlayOutPlayerInfo{" + '"' + "%name of player%" + '"' + ", false, 0}};\n" +
                        "player.sendPacket{PacketPlayOutPlayerInfo{" + '"' + "%random color%%name of player%" + '"' + ", false, 0}};")
                .usage(new String[]{
                        "random color"
                }), ExprRandomColor.class, String.class);

        RegisterManager.registerExpression(new Element(Type.EXPRESSION)
                .name("Random Letter")
                .version("1.5")
                .desc("Returns random letter (a, b, c, d, e, f etc.)")
                .example("send " + '"' + "Your code: %random letter%%random letter%%random letter%%random letter%" + '"')
                .usage(new String[]{
                        "random letter"
                }), ExprRandomLetter.class, String.class);

        RegisterManager.registerExpression(new Element(Type.EXPRESSION)
                .name("Slime Size")
                .version("1.5")
                .desc("Returns size of slime. I don't know, how it works :D")
                .example("{_integer} to silme size")
                .usage(new String[]{
                        "%entity% size"
                }), ExprSlimeSize.class, Integer.class);

		/*
		RegisterManager.registerExpression(new Element(Type.EXPRESSION)
		.name("Age")
		.version("1.5")
		.desc("#IN BUILD")
		.example("#IN BUILD")
		.usage(new String[] {
			"age of %entity%"
		}), ExprAge.class, Age.class);
		*/

        RegisterManager.registerExpression(new Element(Type.EXPRESSION)
                .name("Null")
                .version("1.5")
                .desc("Returns null.")
                .example("set {_variable} to null\nsend " + '"' + "%{_variable}%" + '"')
                .usage(new String[]{
                        "null"
                }), ExprNull.class, Object.class);

        RegisterManager.registerExpression(new Element(Type.EXPRESSION)
                .name("IP")
                .version("Return ip in server list ping event.")
                .desc("Returns null.")
                .example("{_ip} to ip\nif {name-by-ip.%{_ip}%} is set:\n	set motd to " + '"' + "Welcome %{name-by-ip.%{_ip}%}%!" + '"')
                .usage(new String[]{
                        "ip"
                }), ExprIP.class, String.class);

        RegisterManager.registerExpression(new Element(Type.EXPRESSION)
                .name("Slot")
                .version("1.7")
                .desc("Returns clicked slot in inventory.")
                .example("set {_slot} to slot")
                .usage(new String[]{
                        "slot",
                        "clicked slot"
                }), ExprSlot.class, Integer.class);
        ;


        // Files


        RegisterManager.registerExpression(new Element(Type.EXPRESSION)
                .name("Content")
                .version("1.5")
                .desc("Returns content of file into single string.")
                .example("set {_this} to content of file " + '"' + "plugins/Skript/scripts/%script%.sk" + '"')
                .usage(new String[]{
                        "content of file %string%"
                }), ExprContent.class, String.class);

        RegisterManager.registerExpression(new Element(Type.EXPRESSION)
                .name("Single Value")
                .version("1.2")
                .desc("Returns single value get of file - Note that this only works in yaml configuration file (*.yml).")
                .example("set {config.cost} to single value " + '"' + "cost" + '"' + " get of " + '"' + "plugins/MoneyPlugin/config.yml" + '"')
                .usage(new String[]{
                        "[single] value %string% get of %string%"
                }), ExprYamlSingleValue.class, String.class);

        RegisterManager.registerExpression(new Element(Type.EXPRESSION)
                .name("Value List")
                .version("1.4")
                .desc("Returns list of values from file into variables list ({- Note that this only works in yaml configuration file (*.yml).")
                .example("set {list::*} to value list " + '"' + "item-list" + '"' + " get of " + '"' + "plugins/Kits/config.yml" + '"')
                .usage(new String[]{
                        "value list %string% get of %string%"
                }), ExprYamlValueList.class, String.class);

        RegisterManager.registerExpression(new Element(Type.EXPRESSION)
                .name("Configuration Section")
                .version("1.5")
                .desc("Returns configuration sections from file - Note that this only works in yaml configuration file (*.yml).")
                .example("set {_sections::*} to configuration section " + '"' + "worlds" + '"' + " get of " + '"' + "plugins/Skript/WorldsPlugin/worlds.yml" + '"')
                .usage(new String[]{
                        "[configuration] section[s] %string% get of %string%"
                }), ExprYamlConfigurationSection.class, String.class);

        RegisterManager.registerExpression(new Element(Type.EXPRESSION)
                .name("Files")
                .version("1.4")
                .desc("Returns files from folder into variables list ({list::*}).")
                .example("set {scripts::*} to files in " + '"' + "plugins/Skript/scripts" + '"')
                .usage(new String[]{
                        "[all] file[s] in %string%"
                }), ExprFiles.class, String.class);


        // Bukkit


        RegisterManager.registerExpression(new Element(Type.EXPRESSION)
                .name("Motd")
                .version("1.1")
                .desc("Returns server's motd. If WildSkript set motd, then it will also be returned.")
                .example("on server ping: \n	set motd to " + '"' + "%random color%Awesome server!" + '"')
                .usage(new String[]{
                        "motd",
                        "server['s] motd"
                }), ExprMotd.class, String.class);

        RegisterManager.registerExpression(new Element(Type.EXPRESSION)
                .name("Server's Name")
                .version("1.5")
                .desc("Returns server's name. This name is set in the server configuration file (server.properties)")
                .example("set {_name} to server's name")
                .usage(new String[]{
                        "server['s] name"
                }), ExprServerName.class, String.class);

        RegisterManager.registerExpression(new Element(Type.EXPRESSION)
                .name("Server's IP")
                .version("1.5")
                .example("set {_ip} to server's ip")
                .desc("Returns server's. Remember - IP doesn't contain port!")
                .usage(new String[]{
                        "server['s] ip"
                }), ExprServerIP.class, String.class);

        RegisterManager.registerExpression(new Element(Type.EXPRESSION)
                .name("Server's Port")
                .version("1.5")
                .desc("Returns server's port into number. 127.0.0.1:<b>25565</b> <---- Port")
                .example("set {_port} to server's port")
                .usage(new String[]{
                        "server['s] port"
                }), ExprServerPort.class, Integer.class);

        RegisterManager.registerExpression(new Element(Type.EXPRESSION)
                .name("Max Players")
                .version("1.5")
                .desc("Returns maximum number of players on the server")
                .example("set {_max} to max players")
                .usage(new String[]{
                        "max players"
                }), ExprMaxPlayers.class, Integer.class);

        RegisterManager.registerExpression(new Element(Type.EXPRESSION)
                .name("Online Mode")
                .version("1.5")
                .desc("Returns online mode into boolean (online - true / offline - false)")
                .example("set {_online} to online mode")
                .usage(new String[]{
                        "online mode"
                }), ExprOnlineMode.class, Boolean.class);

        RegisterManager.registerExpression(new Element(Type.EXPRESSION)
                .name("View Distance")
                .version("1.5")
                .desc("Returns view distance into number. This value is set in the server configuration file (server.properties)")
                .example("set {_about} to view distance")
                .usage(new String[]{
                        "view distance"
                }), ExprViewDistance.class, Integer.class);

        RegisterManager.registerExpression(new Element(Type.EXPRESSION)
                .name("Nether")
                .version("1.5")
                .desc("Returns access to the Nether into boolean. This value is set in the server configuration file (server.properties)")
                .example("set {_nether-script-enable} to access to nether")
                .usage(new String[]{
                        "access to nether",
                        "allow nether"
                }), ExprAllowNether.class, Boolean.class);

        RegisterManager.registerExpression(new Element(Type.EXPRESSION)
                .name("End")
                .version("1.5")
                .desc("Returns access to the End into boolean.  This value is set in the bukkit configuration file (bukkit.yml)")
                .example("set {_end-script-enable} to access to end")
                .usage(new String[]{
                        "access to end",
                        "allow end"
                }), ExprAllowEnd.class, Boolean.class);

        RegisterManager.registerExpression(new Element(Type.EXPRESSION)
                .name("Bukkit Version")
                .version("1.5")
                .desc("Returns bukkit version into string (text). I do not know what it looks like :P")
                .example("set {_info} to bukkit version")
                .usage(new String[]{
                        "bukkit['s] version",
                        "version of bukkit"
                }), ExprBukkitVersion.class, String.class);


        // System


        RegisterManager.registerExpression(new Element(Type.EXPRESSION)
                .name("WildSkript Version")
                .version("1.5")
                .desc("Returns WildSkript version into string (text).")
                .example("set {_check-enable} to wildskript version")
                .usage(new String[]{
                        "wildskript version",
                        "version of wildskript"
                }), ExprWildSkript.class, String.class);

        RegisterManager.registerExpression(new Element(Type.EXPRESSION)
                .name("TPS")
                .version("1.5")
                .desc("Returns tps. <i>TPS</i> - Tick per seconds ")
                .example("set {_tps} to tps")
                .usage(new String[]{
                        "tps"
                }), ExprTPS.class, Double.class);
        ;

        RegisterManager.registerExpression(new Element(Type.EXPRESSION)
                .name("Free Memory")
                .version("1.5")
                .desc("Returns amount of free memory.")
                .example("set {_free} to free memory")
                .usage(new String[]{
                        "free memory"
                }), ExprFreeMemory.class, Integer.class);
        ;

        RegisterManager.registerExpression(new Element(Type.EXPRESSION)
                .name("Total Memory")
                .version("1.5")
                .desc("Returns amount of total memory.")
                .example("set {_total} to total memory")
                .usage(new String[]{
                        "total memory"
                }), ExprTotalMemory.class, Integer.class);
        ;

        RegisterManager.registerExpression(new Element(Type.EXPRESSION)
                .name("Max Memory")
                .version("1.5")
                .desc("Returns amount of maximum available memory.")
                .example("set {_free} to max memory")
                .usage(new String[]{
                        "max memory"
                }), ExprMaxMemory.class, Integer.class);
        ;

    }
}

