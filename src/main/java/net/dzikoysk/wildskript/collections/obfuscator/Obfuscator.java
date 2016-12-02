package net.dzikoysk.wildskript.collections.obfuscator;

import java.io.File;
import java.io.FileWriter;
import java.util.regex.Matcher;

public class Obfuscator {

    public static void to(String from, String to, int power) throws Exception {
        File sk = new File(from.replaceAll("/", Matcher.quoteReplacement(File.separator)));
        if (!sk.exists()) {
            return;
        }
        File file = new File(to.replaceAll("/", Matcher.quoteReplacement(File.separator)));
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
        }

        String code = ObfuscatorUtils.content(sk);
        StringBuilder sb = new StringBuilder("");
        for (char c : code.toCharArray()) {
            int i = (int) c;
            i = i * power;
            sb.append(i + "-");
        }

        File tmp = new File("tmp.ws");
        FileWriter fw = new FileWriter(tmp);
        fw.write(sb.toString());
        fw.flush();
        fw.close();
        ObfuscatorUtils.zip(tmp, file);
        tmp.delete();
    }

    public static String load(File file, int power) {
        String pasd = ObfuscatorUtils.unzip(file);
        String[] values = pasd.split("-");
        StringBuilder code = new StringBuilder("");
        for (String un : values) {
            if (un == null || un.isEmpty()) {
                continue;
            }
            int i = Integer.valueOf(un);
            i = i / power;
            code.append((char) i);
        }
        return code.toString();
    }
}
