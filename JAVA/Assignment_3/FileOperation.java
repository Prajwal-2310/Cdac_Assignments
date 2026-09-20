package com.Prajwal;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOperation {

    String fileName = "C:\\Users\\prajwal\\eclipse-workspace\\Cdac.txt";

    int key = 3;

    public void encryptFile() {

        FileInputStream fileStream = null;
        DataInputStream dataStream = null;

        StringBuffer encryptedData = new StringBuffer();

        // ---------- READING ----------
        try {

            fileStream = new FileInputStream(fileName);
            dataStream = new DataInputStream(fileStream);

            int data;

            while ((data = dataStream.read()) != -1) {

                char ch = (char) data;

                char encryptedChar = encryptCharacter(ch);

                encryptedData.append(encryptedChar);
            }

        } catch (IOException e) {

            e.printStackTrace();

            return;

        } finally {

            try {

                if (dataStream != null) {
                    dataStream.close();
                }

                if (fileStream != null) {
                    fileStream.close();
                }

            } catch (IOException e) {

                e.printStackTrace();
            }
        }


        // ---------- WRITING ----------
        FileOutputStream outputStream = null;
        DataOutputStream dataOutputStream = null;

        try {

            outputStream = new FileOutputStream(fileName);
            dataOutputStream = new DataOutputStream(outputStream);

            for (int i = 0; i < encryptedData.length(); i++) {

                dataOutputStream.write(
                    (byte) encryptedData.charAt(i)
                );
            }

            System.out.println("File encrypted successfully.");

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (dataOutputStream != null) {
                    dataOutputStream.close();
                }

                if (outputStream != null) {
                    outputStream.close();
                }

            } catch (IOException e) {

                e.printStackTrace();
            }
        }
    }


    public void decryptFile() {

        FileInputStream fileStream = null;
        DataInputStream dataStream = null;

        StringBuffer decryptedData = new StringBuffer();

        // ---------- READING ----------
        try {

            fileStream = new FileInputStream(fileName);
            dataStream = new DataInputStream(fileStream);

            int data;

            while ((data = dataStream.read()) != -1) {

                char ch = (char) data;

                char decryptedChar = decryptCharacter(ch);

                decryptedData.append(decryptedChar);
            }

        } catch (IOException e) {

            e.printStackTrace();

            return;

        } finally {

            try {

                if (dataStream != null) {
                    dataStream.close();
                }

                if (fileStream != null) {
                    fileStream.close();
                }

            } catch (IOException e) {

                e.printStackTrace();
            }
        }


        // ---------- WRITING ----------
        FileOutputStream outputStream = null;
        DataOutputStream dataOutputStream = null;

        try {

            outputStream = new FileOutputStream(fileName);
            dataOutputStream = new DataOutputStream(outputStream);

            for (int i = 0; i < decryptedData.length(); i++) {

                dataOutputStream.write(
                    (byte) decryptedData.charAt(i)
                );
            }

            System.out.println("File decrypted successfully.");

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (dataOutputStream != null) {
                    dataOutputStream.close();
                }

                if (outputStream != null) {
                    outputStream.close();
                }

            } catch (IOException e) {

                e.printStackTrace();
            }
        }
    }


    // ---------- ENCRYPTION LOGIC ----------

    private char encryptCharacter(char ch) {

        // Uppercase
        if (ch >= 'A' && ch <= 'Z') {

            return (char) ('A' + (ch - 'A' + key) % 26);
        }

        // Lowercase
        if (ch >= 'a' && ch <= 'z') {

            return (char) ('a' + (ch - 'a' + key) % 26);
        }

        // Numbers
        if (ch >= '0' && ch <= '9') {

            return (char) ('0' + (ch - '0' + key) % 10);
        }

        // Space, newline and special characters
        // remain unchanged
        return ch;
    }


    // ---------- DECRYPTION LOGIC ----------

    private char decryptCharacter(char ch) {

        // Uppercase
        if (ch >= 'A' && ch <= 'Z') {

            return (char) ('A' + (ch - 'A' - key + 26) % 26);
        }

        // Lowercase
        if (ch >= 'a' && ch <= 'z') {

            return (char) ('a' + (ch - 'a' - key + 26) % 26);
        }

        // Numbers
        if (ch >= '0' && ch <= '9') {

            return (char) ('0' + (ch - '0' - key + 10) % 10);
        }

        // Space, newline and special characters
        // remain unchanged
        return ch;
    }
}