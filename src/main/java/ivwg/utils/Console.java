package ivwg.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Console {

    private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public String readString(String title) {
        String input = null;
        this.write(title);
        try {
            input = this.bufferedReader.readLine();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return input;
    }

    public int readInt(String title) {
        int input = 0;
        boolean ok = false;
        do {
            try {
                input = Integer.parseInt(this.readString(title));
                ok = true;
            } catch (Exception ex) {
                this.writeError("integer");
            }
            assert ok;
        } while (!ok);
        return input;
    }

    public void writeln(String string) {
        System.out.println(string);
    }

    public void write(String string) {
        System.out.print(string);
    }

    public void writeError(String format) {
        System.out.println("FORMAT ERROR! " + "Enter a " + format + " formatted value.");
    }
}
