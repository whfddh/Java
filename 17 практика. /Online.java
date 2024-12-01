import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class Online {
    String FIO;
    int INN;

    public Online(String FIO, String INN) {
        this.FIO = FIO;
        this.INN = Integer.parseInt(INN);
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public void setINN(int INN) {
        this.INN = INN;
    }

    public int getINN() {
        return INN;
    }

    public String getFIO() {
        return FIO;
    }

    public static void isINNValid(String INN) throws InvalidINNException{
        if (!INN.matches("\\d{10}")){
            throw new InvalidINNException("Недействительный формат ИНН.");
        }


    }

    static class InvalidINNException extends Exception {
        public InvalidINNException(String message) {
            super(message);
        }
    }

}
