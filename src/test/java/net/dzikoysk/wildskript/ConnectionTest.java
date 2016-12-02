package net.dzikoysk.wildskript;

import net.dzikoysk.wildskript.util.IOUtils;

public class ConnectionTest {

    public static void main(String[] args) {
        String content = IOUtils.getContent("http://www.dzikoysk.net/projects/wildskript/download/latest.info");
        System.out.println("Content: " + content);
    }

}
