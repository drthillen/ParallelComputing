// Synchronization.java

import java.lang.*;

public class Synchronization {
    public static void main(String[] args) {
        printThreadID();
    }

    static void printThreadID() {
        ThreadID.get();
    }
}