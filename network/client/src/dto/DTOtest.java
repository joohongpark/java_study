package dto;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class DTOtest {
    public static void run(Socket s) {
        try {
            MemberDTO sendDTO = new MemberDTO(123, "羊肉片");

            ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
            oos.writeObject(sendDTO);
            oos.flush();

            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
            MemberDTO dto = (MemberDTO)ois.readObject();

            System.out.println(dto.toString());
        } catch (ClassNotFoundException | IOException e) {
            System.out.println(e);
        }
    }
}
