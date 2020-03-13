package app.IO;

public interface Console {

        void print(String line);
        default void printLn(String line) {
            print(line);
            print("\n");
        }
        String readLn();
    }

