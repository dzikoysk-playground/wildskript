package net.dzikoysk.wildskript.collections.packet;

import net.dzikoysk.wildskript.collections.packet.elements.EffPacket;
import net.dzikoysk.wildskript.register.RegisterManager;
import net.dzikoysk.wildskript.util.doc.Documentation;
import net.dzikoysk.wildskript.util.doc.Element;
import net.dzikoysk.wildskript.util.doc.Type;

public class PacketElements {

    public static void register() {

        Documentation.addElement(new Element(Type.DESC)
                .collection("Packets")
                .name("Packets")
                .desc("Allows you to send packet to player")
        );

        RegisterManager.registerEffect(new Element(Type.COLLECTION)
                        .collection("Packets")
                        .name("Packet")
                        .desc("# Send packet from list to player")
                        .example("[player].sendPacket{[objects]};")
                        .usage(new String[]{
                                "%players%.sendPacket{[%-objects%]}[;]"
                        })
                , EffPacket.class);
    }
}
