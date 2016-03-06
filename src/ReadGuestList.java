import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadGuestList {
    private final String guestList;
    public ReadGuestList(String guestList) {
        this.guestList = guestList;
    }
    public  String [] read() throws IOException {
        File file = new File(guestList);
        int length = (int) file.length();
        FileReader fileReader = new FileReader(file);
        char[] characterBuffer = new char[length];
        fileReader.read(characterBuffer, 0, length);
        String fileContent = new String(characterBuffer);
        return fileContent.split("\n");
    }

}
