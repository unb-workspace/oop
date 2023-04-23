package main;

import gui.LoginInterface;

public class Main {
    public static void main(String[] args) {
        System.out.println("[LOG] Opening login screen...");

        LoginInterface loginInterface = new LoginInterface();

        loginInterface.show();

    }

    public static String getUserDirectory() {
        return System.getProperty("user.dir");
    }
}
