package veri;

import com.sun.corba.se.spi.activation.Server;
import java.net.ServerSocket;
import java.io.*;
import java.net.*;
import java.util.Scanner;
import javax.imageio.stream.FileImageInputStream;


public class server {
   
    public static void main(String[] args) throws Exception {
       
     Scanner scanner = new Scanner(System.in);
     System.out.println("Göndereceğiniz dosyanın dizin yolunu yazınız");
     String girdi =scanner.nextLine();
     System.out.println(" ");
     System.out.println("Göndereceğiniz dosyanın ismini ve tipini yazınız.");
     System.out.println("Örnek : veriler.txt / picture.jpg");
             
                 
     Scanner scanner1  = new Scanner(System.in);
     String dosyaadı = scanner1.nextLine();
     System.out.println(" ");
     System.out.println("Bağlantı kuruldu.Bekleniyor...");
     
     ServerSocket serverSocket = new ServerSocket(300);
     Socket socket = serverSocket.accept();
   
   

     PrintWriter pr = new PrintWriter(socket.getOutputStream());
     pr.println(dosyaadı);
     pr.flush();
     
     FileInputStream fr = new FileInputStream(girdi);
     System.out.println(girdi);
     byte b[] = new byte[20002];
     fr.read(b,0,b.length);
     OutputStream os =socket.getOutputStream();
     os.write(b,0,b.length);
 
    }
   
}