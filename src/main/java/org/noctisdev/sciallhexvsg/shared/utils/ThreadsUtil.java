package org.noctisdev.sciallhexvsg.shared.utils;

public class ThreadsUtil {

    public static void runTask(Runnable task) {
        new Thread(task).start();
    }

}
