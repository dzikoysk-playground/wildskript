package net.dzikoysk.wildskript.util.doc;

import net.dzikoysk.wildskript.WildSkript;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

public class Documentation {

    private static List<Element> events = new ArrayList<>();
    private static List<Element> effects = new ArrayList<>();
    private static List<Element> conditions = new ArrayList<>();
    private static List<Element> expressions = new ArrayList<>();
    private static List<Element> types = new ArrayList<>();
    private static List<Element> eventvalues = new ArrayList<>();
    private static List<Element> desc = new ArrayList<>();
    private static ElementMap<String, List<Element>> collections = new ElementMap<>();
    private static ElementMap<String, List<Element>> objects = new ElementMap<>();
    private static ElementMap<String, List<Element>> plugins = new ElementMap<>();

    private static File doc = new File(WildSkript.getInstance().getDataFolder() + File.separator + "doc");

    public static void addElement(Element e) {
        new ElementMap<String, List<Element>>();
        switch (e.getType()) {
            case EFFECT:
                effects.add(e);
                break;
            case CONDITION:
                conditions.add(e);
                break;
            case EVENT:
                events.add(e);
                break;
            case EXPRESSION:
                expressions.add(e);
                break;
            case COLLECTION:
                collections.add(e);
                break;
            case OBJECT:
                objects.add(e);
                break;
            case PLUGIN:
                plugins.add(e);
                break;
            case TYPE:
                types.add(e);
                break;
            case EVENT_VALUE:
                eventvalues.add(e);
                break;
            case DESC:
                desc.add(e);
                break;
            case NO_DOC:
                break;
            default:
                break;
        }
    }

    public static void generate() {
        deleteFolder(doc);
        index();
        single();
        mindex();
        multiple();
        css();
    }

    @SuppressWarnings({"unchecked"})
    private static void single() {
        List<Element>[] lists = new List[]{events, conditions, effects, expressions, types};
        for (List<Element> l : lists) {
            String name = l.get(0).getType().getName();
            String head = singleHead(name);
            String list = singleList(l);
            String patterns = singlePattern(l);
            String footer = footer();
            build(new File(doc + File.separator + name.toLowerCase() + ".html"), new String[]{
                    head,
                    list,
                    patterns,
                    footer
            });
        }
    }

    @SuppressWarnings({"unchecked"})
    private static void multiple() {
        ElementMap<String, List<Element>>[] maps = new ElementMap[]{collections, objects};
        for (ElementMap<String, List<Element>> ep : maps) {
            for (Entry<String, List<Element>> entry : ep.entrySet()) {
                Type type = entry.getValue().get(0).getType();
                String title = entry.getKey();
                String head = multipleHead(type, title);
                String body = multipleBody(title, entry.getValue());
                String footer = footer();
                build(new File(doc + File.separator + type.getName().toLowerCase() + File.separator + title + ".html"), new String[]{
                        head,
                        body,
                        footer
                });
            }
        }
    }

    //---------------------------------- SINGLE ----------------------------------\\

    private static String singleHead(String title) {
        InputStream is = resource("doc/single/header.txt");
        String s = isS(is);
        String head = s.replace("{TITLE}", title);
        return head;
    }

    private static String singleList(List<Element> list) {
        InputStream is = resource("doc/single/list.txt");
        String template = isS(is);
        StringBuilder sb = new StringBuilder("");

        Collections.sort(list);
        for (Element e : list) {
            String name = e.getName();
            sb.append("<a href=" + '"' + "#" + name + '"' + " class=" + '"' + "list-b" + '"' + ">" + name + "</a>");
        }
        sb.append(template);

        return sb.toString();
    }

    private static String singlePattern(List<Element> pattern) {
        InputStream is = resource("doc/single/pattern.txt");
        String tmp = isS(is);

        List<String> ptr = new ArrayList<>();
        Collections.sort(pattern);
        for (Element e : pattern) {
            String b = tmp
                    .replace("{NAME}", e.getName())
                    .replace("{USAGE}", updateClasses(e.getUsage()))
                    .replace("{VERSION}", e.getVersion())
                    .replace("{DESC}", e.getDesc())
                    .replace("{EXAMPLE}", e.getExample());
            ptr.add(b);
        }
        StringBuilder sb = new StringBuilder("");
        for (String s : ptr) sb.append(s);
        return sb.toString();
    }

    //---------------------------------- MULTIPLE ----------------------------------\\

    private static String multipleHead(Type type, String title) {
        InputStream is = resource("doc/multiple/header.txt");
        String s = isS(is);
        StringBuilder sb = new StringBuilder("");
        if (type == Type.COLLECTION)
            for (String name : collections.keySet())
                sb.append("<a href=" + '"' + "./" + name + ".html" + '"' + " class=" + '"' + "menu-link" + '"' + '>' + name + " </a> \n");
        else if (type == Type.OBJECT)
            for (String name : objects.keySet())
                sb.append("<a href=" + '"' + "./" + name + ".html" + '"' + " class=" + '"' + "menu-link" + '"' + '>' + name + " </a> \n");
        String head = s
                .replace("{TITLE}", title)
                .replace("{LIST}", sb.toString());
        return head;
    }

    private static String multipleBody(String name, List<Element> es) {
        InputStream is = resource("doc/multiple/body.txt");
        String tmp = isS(is);

        StringBuilder sb = new StringBuilder("");
        int i = 0;
        for (Element e : es) {
            if (i == 0) sb.append(e.getDesc() + " \n" + e.getExample());
            else sb.append("\n \n" + e.getDesc() + " \n" + e.getExample());
            i++;
        }
        Element esc = null;
        for (Element ef : desc) if (ef.getName().equalsIgnoreCase(name)) esc = ef;
        return tmp
                .replace("{DESC}", esc.getDesc())
                .replace("{CONTENT}", sb.toString())
                ;
    }

    //---------------------------------- OTHER ----------------------------------\\

    private static void index() {
        InputStream index = resource("doc/index.txt");
        copy(index, new File(doc + File.separator + "index.html"));
    }

    private static void mindex() {
        String chead = multipleHead(Type.COLLECTION, "Collections");
        String ohead = multipleHead(Type.OBJECT, "Objects");

        String cindex = isS(resource("doc/multiple/cindex.txt"));
        String oindex = isS(resource("doc/multiple/oindex.txt"));

        String footer = footer();

        build(new File(doc + File.separator + "collections" + File.separator + "index.html"), new String[]{
                chead,
                cindex,
                footer
        });

        build(new File(doc + File.separator + "objects" + File.separator + "index.html"), new String[]{
                ohead,
                oindex,
                footer
        });
    }

    private static void css() {
        InputStream css = WildSkript.getInstance().getResource("doc/css/style.css");
        InputStream bebas = WildSkript.getInstance().getResource("doc/css/BebasNeueRegular.ttf");
        InputStream kirvy = WildSkript.getInstance().getResource("doc/css/Kirvy-Regular.otf");
        InputStream icon = WildSkript.getInstance().getResource("doc/css/favicon.ico");

        copy(css, new File(doc + File.separator + "css" + File.separator + "style.css"));
        copy(bebas, new File(doc + File.separator + "css" + File.separator + "BebasNeueRegular.ttf"));
        copy(kirvy, new File(doc + File.separator + "css" + File.separator + "Kirvy-Regular.otf"));
        copy(icon, new File(doc + File.separator + "css" + File.separator + "favicon.ico"));
    }

    //---------------------------------- UTILS ----------------------------------\\

    private static void build(File file, String[] t) {
        try {
            file.getParentFile().mkdirs();
            FileWriter fw = new FileWriter(file);
            StringBuilder sb = new StringBuilder("");
            for (String s : t) sb.append(s + "\n");
            fw.write(sb.toString());
            fw.close();
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    private static String footer() {
        InputStream is = resource("doc/footer.txt");
        String footer = isS(is);
        return footer;
    }

    private static String updateClasses(String s) {
        String[] classes = new String[]{"string", "player", "number", "location", "entity"};
        for (String type : classes) {
            s = s.replace("%" + type + "%", "%<a href=" + '"' + "http://njol.ch/projects/skript/doc/classes/#" + type + '"' + "class=" + '"' + "a" + '"' + ">" + type + "</a>%");
        }
        return s;
    }

    public static void deleteFolder(File folder) {
        File[] files = folder.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    deleteFolder(f);
                } else {
                    f.delete();
                }
            }
        }
        folder.delete();
    }

    private static void copy(InputStream in, File file) {
        try {
            file.getParentFile().mkdirs();
            file.createNewFile();
            OutputStream out = new FileOutputStream(file);
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            out.close();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("resource")
    private static String isS(InputStream is) {
        Scanner s = new Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }

    private static InputStream resource(String dir) {
        return WildSkript.getInstance().getResource(dir);
    }

}


