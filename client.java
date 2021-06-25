package veri;

import java.util.Scanner;
import java.net.ServerSocket;
import java.io.*;
import java.net.*;

public class client {
    public static void main(String[] args) throws IOException {
              
        byte [] b = new byte[20002];
        Scanner scanner = new Scanner(System.in); 
        System.out.println("Dosyayı alacağınız bilgisayarın IP adresini giriniz: ");
        String ipadresi = scanner.nextLine(); 
          System.out.println("");
        
        Scanner scanner2 = new Scanner(System.in); 
        System.out.println("Dosyayı koymak istediğiniz yerin dizin yolunu belirtiniz ");
       
        System.out.println("Lütfen, en sondaki ters slash (\\) işaretini koymayı unutmayınız...");
         System.out.println("Örnek: (C:\\Users\\User\\Desktop\\)");
            System.out.println("");
        String dizin = scanner2.nextLine();  
        Socket socket = new Socket(ipadresi,300);
        
        
        InputStreamReader input_stream = new InputStreamReader(socket.getInputStream());
        BufferedReader buffer_reader = new BufferedReader(input_stream);
        String dosya_adi_ve_uzantisi = buffer_reader.readLine();
        
        dizin = dizin + dosya_adi_ve_uzantisi;
           
        InputStream inputstream = socket.getInputStream();
        FileOutputStream filestream = new FileOutputStream(dizin);
        inputstream .read(b,0,b.length);
        filestream.write(b,0,b.length);
         System.out.println("");
        System.out.println("Dosya başarıyla alındı...");
     
       
    }


}