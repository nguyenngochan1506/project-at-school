package lesson1;

import java.io.*;

public class MyCaesarCipher {
    private char[] alphabet  = new char[26];
    public MyCaesarCipher(){
        for (int i = 0; i<alphabet.length; i++){
            this.alphabet[i] = (char)('A'+i);
        }
    }

    /**
     * phuong thuc ma hoa
     * @param txt : doan van ban can ma hoa
     * @param step : so buoc nhay trong bang alphabet
     * @return van ban da duoc ma hoa
     */
    public String encrypt(String txt, int step){
        StringBuilder result = new StringBuilder();
        char[] temp = txt.toUpperCase().toCharArray();
        for(char c : temp){
            /*
            goi p = vi tri hien tai cua char trong alphabet = indexOfCharInAlphabet(c)
            goi k = step
            theo cong thuc: (p+k)mod26
             */
            if(c == ' '){
                result.append(" ");
            }else if(c==','){
                result.append(',');
            }
            else{
                result.append(this.alphabet[(indexOfCharInAlphabet(c)+step)%26]);
            }
        }
        return result.toString();
    }

    /**
     * phuong thuc giai ma
     * @param txt doan van ban can duoc giai ma
     * @param step so buoc nhay trong alphabet (ban can nhap dung so buoc ma truoc do da ma hoa)
     * @return van ban da duoc giai ma
     */
    public String decrypt(String txt, int step) {
        StringBuilder result = new StringBuilder();
        //chuyen toan bo van ban ve dung dinh dang ma ta da tao ra trong alphabet
        char[] temp = txt.toUpperCase().toCharArray();

        for (char c : temp) {
            if (c == ' ') {
                result.append(' ');
            } else if (c == ',') {
                result.append(',');
            } else {
                /*
                goi p = vi tri hien tai cua char trong alphabet = indexOfCharInAlphabet(c)
                goi k = step
                -theo cong thuc: (p-k)mod26
                 */
                result.append(this.alphabet[(indexOfCharInAlphabet(c) - step) % 26]);
            }
        }
        return result.toString();
    }

    /**
     * phuong thuc tim vi tri cua mot chu cai trong bang alphabet ma ta da tao ra
     * @param c ki tu can tim
     * @return vi tri cua ki tu (neu khong tim thay thi return -1)
     */
    public int indexOfCharInAlphabet(char c){
        for (int i = 0; i<this.alphabet.length; i++){
            if(c == this.alphabet[i]){
                return i;
            }
        }
        return -1;

    }

    /**
     * phuong thuc luu file
     * @param fileName ten file
     * @param text noi dung can luu
     */
    public void saveToFile(String fileName, String text){
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write(text);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * phuong thuc doc noi dung file text
     * @param fileName ten file can doc
     * @return noi dung o trong file
     */
    public String readFromFile(String fileName){

        try {
            BufferedReader  reader = new BufferedReader(new FileReader(fileName));
            String line;
            StringBuilder result = new StringBuilder();

            //doc tung dong mot cho toi khi khong con dong nao
            while ((line = reader.readLine()) != null){
                result.append(line);
            }
            reader.close();
            return result.toString();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        MyCaesarCipher myCaesarCipher = new MyCaesarCipher();
        String txt = "Return to Caesar what belongs to Caesar, and to God what belongs to God";

        //Test encrypt and save file
        System.out.println("Text: "+ txt+"\n");
        //encrypt
        System.out.println("Encrypt with step = 3: ");
        String encryptedTxt = myCaesarCipher.encrypt(txt, 3);
        System.out.println(encryptedTxt);
        //save file
        myCaesarCipher.saveToFile("Encrypt.txt",encryptedTxt);
        System.out.println("Saved to Encrypt.txt\n");

        //Test decrypt and read file
        System.out.println("Decrypt:");
        //read file
        String textFromFile = myCaesarCipher.readFromFile("Encrypt.txt");
        System.out.printf("Read from file Encrypt.txt: %s \n",textFromFile);
        //decrypt
        System.out.printf("Decrypt: %s", myCaesarCipher.decrypt(textFromFile, 3));
}
}
