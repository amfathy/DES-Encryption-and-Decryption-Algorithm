//assignment1
//20190068
//Ahmed Mohammed Fathy
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    private static class DES {
        // S-boxes Table
        int[][][] S_BOX
                = {{{14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6,
                12, 5, 9, 0, 7},
                {0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12,
                        11, 9, 5, 3, 8},
                {4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7,
                        3, 10, 5, 0},
                {15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14,
                        10, 0, 6, 13}},

                {{15, 1, 8, 14, 6, 11, 3, 4, 9, 7, 2, 13,
                        12, 0, 5, 10},
                        {3, 13, 4, 7, 15, 2, 8, 14, 12, 0, 1, 10,
                                6, 9, 11, 5},
                        {0, 14, 7, 11, 10, 4, 13, 1, 5, 8, 12, 6,
                                9, 3, 2, 15},
                        {13, 8, 10, 1, 3, 15, 4, 2, 11, 6, 7, 12,
                                0, 5, 14, 9}},
                {{10, 0, 9, 14, 6, 3, 15, 5, 1, 13, 12, 7,
                        11, 4, 2, 8},
                        {13, 7, 0, 9, 3, 4, 6, 10, 2, 8, 5, 14,
                                12, 11, 15, 1},
                        {13, 6, 4, 9, 8, 15, 3, 0, 11, 1, 2, 12,
                                5, 10, 14, 7},
                        {1, 10, 13, 0, 6, 9, 8, 7, 4, 15, 14, 3,
                                11, 5, 2, 12}},
                {{7, 13, 14, 3, 0, 6, 9, 10, 1, 2, 8, 5,
                        11, 12, 4, 15},
                        {13, 8, 11, 5, 6, 15, 0, 3, 4, 7, 2, 12,
                                1, 10, 14, 9},
                        {10, 6, 9, 0, 12, 11, 7, 13, 15, 1, 3,
                                14, 5, 2, 8, 4},
                        {3, 15, 0, 6, 10, 1, 13, 8, 9, 4, 5, 11,
                                12, 7, 2, 14}},
                {{2, 12, 4, 1, 7, 10, 11, 6, 8, 5, 3, 15,
                        13, 0, 14, 9},
                        {14, 11, 2, 12, 4, 7, 13, 1, 5, 0, 15,
                                10, 3, 9, 8, 6},
                        {4, 2, 1, 11, 10, 13, 7, 8, 15, 9, 12, 5,
                                6, 3, 0, 14},
                        {11, 8, 12, 7, 1, 14, 2, 13, 6, 15, 0, 9,
                                10, 4, 5, 3}},
                {{12, 1, 10, 15, 9, 2, 6, 8, 0, 13, 3, 4,
                        14, 7, 5, 11},
                        {10, 15, 4, 2, 7, 12, 9, 5, 6, 1, 13, 14,
                                0, 11, 3, 8},
                        {9, 14, 15, 5, 2, 8, 12, 3, 7, 0, 4, 10,
                                1, 13, 11, 6},
                        {4, 3, 2, 12, 9, 5, 15, 10, 11, 14, 1, 7,
                                6, 0, 8, 13}},
                {{4, 11, 2, 14, 15, 0, 8, 13, 3, 12, 9, 7,
                        5, 10, 6, 1},
                        {13, 0, 11, 7, 4, 9, 1, 10, 14, 3, 5, 12,
                                2, 15, 8, 6},
                        {1, 4, 11, 13, 12, 3, 7, 14, 10, 15, 6,
                                8, 0, 5, 9, 2},
                        {6, 11, 13, 8, 1, 4, 10, 7, 9, 5, 0, 15,
                                14, 2, 3, 12}},
                {{13, 2, 8, 4, 6, 15, 11, 1, 10, 9, 3, 14,
                        5, 0, 12, 7},
                        {1, 15, 13, 8, 10, 3, 7, 4, 12, 5, 6, 11,
                                0, 14, 9, 2},
                        {7, 11, 4, 1, 9, 12, 14, 2, 0, 6, 10, 13,
                                15, 3, 5, 8},
                        {2, 1, 14, 7, 4, 10, 8, 13, 15, 12, 9, 0,
                                3, 5, 6, 11}}};
        // CONSTANTS
        // Initial Permutation Table
        int[] INITIAL_PERMUTATION_TABLE
                = {58, 50, 42, 34, 26, 18, 10, 2, 60, 52, 44,
                36, 28, 20, 12, 4, 62, 54, 46, 38, 30, 22,
                14, 6, 64, 56, 48, 40, 32, 24, 16, 8, 57,
                49, 41, 33, 25, 17, 9, 1, 59, 51, 43, 35,
                27, 19, 11, 3, 61, 53, 45, 37, 29, 21, 13,
                5, 63, 55, 47, 39, 31, 23, 15, 7};

        // Inverse Initial Permutation Table
        int[] INVERSE_PERMUTATION_TABLE
                = {40, 8, 48, 16, 56, 24, 64, 32, 39, 7, 47,
                15, 55, 23, 63, 31, 38, 6, 46, 14, 54, 22,
                62, 30, 37, 5, 45, 13, 53, 21, 61, 29, 36,
                4, 44, 12, 52, 20, 60, 28, 35, 3, 43, 11,
                51, 19, 59, 27, 34, 2, 42, 10, 50, 18, 58,
                26, 33, 1, 41, 9, 49, 17, 57, 25};

        // first key-hePermutation Table
        int[] KEY_PERMUTATION_1
                = {57, 49, 41, 33, 25, 17, 9, 1, 58, 50,
                42, 34, 26, 18, 10, 2, 59, 51, 43, 35,
                27, 19, 11, 3, 60, 52, 44, 36, 63, 55,
                47, 39, 31, 23, 15, 7, 62, 54, 46, 38,
                30, 22, 14, 6, 61, 53, 45, 37, 29, 21,
                13, 5, 28, 20, 12, 4};

        // second key-Permutation Table
        int[] KEY_PERMUTATION_2
                = {14, 17, 11, 24, 1, 5, 3, 28, 15, 6,
                21, 10, 23, 19, 12, 4, 26, 8, 16, 7,
                27, 20, 13, 2, 41, 52, 31, 37, 47, 55,
                30, 40, 51, 45, 33, 48, 44, 49, 39, 56,
                34, 53, 46, 42, 50, 36, 29, 32};

        // Expansion D-box Table
        int[] EXPANSION_TABLE = {32, 1, 2, 3, 4, 5, 4, 5, 6, 7,
                8, 9, 8, 9, 10, 11, 12, 13, 12, 13,
                14, 15, 16, 17, 16, 17, 18, 19, 20, 21,
                20, 21, 22, 23, 24, 25, 24, 25, 26, 27,
                28, 29, 28, 29, 30, 31, 32, 1};

        // Straight Permutation Table
        int[] STRAIGHT_PERMUTATION
                = {16, 7, 20, 21, 29, 12, 28, 17, 1, 15, 23,
                26, 5, 18, 31, 10, 2, 8, 24, 14, 32, 27,
                3, 9, 19, 13, 30, 6, 22, 11, 4, 25};

        int[] SHIFT_BITS = {1, 1, 2, 2, 2, 2, 2, 2,
                1, 2, 2, 2, 2, 2, 2, 1};
        int[] DECRYPT_SHIFT_BITS = {2, 1, 2, 2, 2, 2, 2, 2,
                1, 2, 2, 2, 2, 2, 2, 1};


        String shift_left(int round, String c, String d) {
            StringBuilder ci = new StringBuilder();
            StringBuilder di = new StringBuilder();
            if (SHIFT_BITS[round] == 1) {
                for (int i = 1; i < 28; i++) {
                    ci.append(c.charAt(i));
                    di.append(d.charAt(i));
                }
                ci.append(c.charAt(0));
                di.append(d.charAt(0));
            } else {
                for (int i = 2; i < 28; i++) {
                    ci.append(c.charAt(i));
                    di.append(d.charAt(i));
                }
                ci.append(c.charAt(0));
                di.append(d.charAt(0));
                ci.append(c.charAt(1));
                di.append(d.charAt(1));
            }

            return ci + di.toString();
        }


        String shift_right(int round, String c, String d) {
            StringBuilder ci = new StringBuilder();
            StringBuilder di = new StringBuilder();
            if(DECRYPT_SHIFT_BITS[round]==1){
                ci.append(c.charAt(27));
                di.append(d.charAt(27));
                for (int i = 0; i < 27; i++) {
                    ci.append(c.charAt(i));
                    di.append(d.charAt(i));
                }
            } else{
                ci.append(c.charAt(27));
                ci.append(c.charAt(26));
                di.append(d.charAt(27));
                di.append(d.charAt(26));
                for (int i = 0; i < 26; i++) {
                    ci.append(c.charAt(i));
                    di.append(d.charAt(i));
                }
            }
            return ci + di.toString();
        }

        // conversions

        List<StringBuilder> plainToBinary(String input) {
            List<StringBuilder> blocks = new ArrayList<>();
            StringBuilder result = new StringBuilder();
            char[] chars = input.toCharArray();
            for (char aChar : chars) {
                result.append(
                        String.format("%8s", Integer.toBinaryString(aChar))
                                .replaceAll(" ", "0")
                );
            }
            if (result.length()!=64){
                for (String s : generateBlocks(result.toString())){
                    blocks.add(new StringBuilder(s));
                }
            }else
                blocks.add(result);

            return blocks;

        }

        String keyToBinary(String key) {
            StringBuilder result = new StringBuilder();
            char[] chars = key.toCharArray();
            for (char aChar : chars) {
                result.append(
                        String.format("%8s", Integer.toBinaryString(aChar))   // char -> int, auto-cast
                                .replaceAll(" ", "0")    // add zero if it's less than 8 characters
                );
            }
            return result.toString();
        }

        static String binToString(String binary) {
            String temp = "";
            String output = "";
            for (int i = 0; i < binary.length(); i += 8) {
                for (int j = i; j < i + 8; j++) {
                    temp += binary.charAt(j);
                }
                int decimal = Integer.parseInt(temp, 2);
                temp = "";
                char c = (char) decimal;
                output += c;
            }

            return output;
        }



        List<String> generateBlocks(String binary) {
            List<String> result = new ArrayList<>();
            int index = 0;
            while (index < binary.length()) {
                String res = binary.substring(index, Math.min(index + 64, binary.length())); // 0, min(64,128)

                int size = 64 - res.length();
                StringBuilder temp= new StringBuilder();
                while (temp.length()<size) {
                    temp.append('0');
                }

                result.add(temp+res);
                index += 64;
            }
            return result;
        }


        // Tables (Permutations - Expansion - PC 1-2)
        String permutation(StringBuilder input) {
            StringBuilder output = new StringBuilder();
            for (int j : INITIAL_PERMUTATION_TABLE) {
                output.append(input.charAt(j - 1));
            }
            return output.toString();
        }
        String finalPermutation(String input) {
            StringBuilder output = new StringBuilder();
            for (int j : INVERSE_PERMUTATION_TABLE) {
                output.append(input.charAt(j - 1));
            }
            return output.toString();
        }
        String StraightPermutation(String input) {
            StringBuilder output = new StringBuilder();
            for (int j : STRAIGHT_PERMUTATION) {
                output.append(input.charAt(j - 1));
            }
            return output.toString();
        }
        String expansion(String R) {
            String output = "";
            for (int i = 0; i < EXPANSION_TABLE.length; i++) {
                output += R.charAt(EXPANSION_TABLE[i] - 1);
            }
            return output;
        }

        String PC1_key(String key) {
            String output = "";
            for (int i = 0; i < KEY_PERMUTATION_1.length; i++) {
                output += key.charAt(KEY_PERMUTATION_1[i]-1);
            }
            return output;
        }
        String PC2_key(String key) {
            String output = "";
            for (int i = 0; i < KEY_PERMUTATION_2.length; i++) {
                output += key.charAt(KEY_PERMUTATION_2[i] - 1);
            }
            return output;
        }



        // XOR functions

        String XOR_32(String text, String text2) {
            String output = "";

            for (int i = 0; i < 32; i++) {
                output += text.charAt(i) ^ text2.charAt(i);
            }
            return output;
        }
        String XOR_48(String text, String key) {
            String output = "";

            for (int i = 0; i < 48; i++) {
                output += text.charAt(i) ^ key.charAt(i);
            }
            return output;
        }



        String searchSbox(int i, String row, String col){
            int sboxDecimal = S_BOX[i][Integer.parseInt(row, 2)][Integer.parseInt(col, 2)]; // Binary to decimal
            String sboxBinary = Integer.toBinaryString(sboxDecimal);
            int size = 4 - sboxBinary.length();
            String expandedBin="";
            while (expandedBin.length()<size) {
                expandedBin+='0';
            }
            expandedBin+=sboxBinary;
            return expandedBin;
        }

        String sboxIndexGeneration(String rightPrevious){
            int j=0;
            String result="";
            StringBuilder SI= new StringBuilder();
            String row="";
            String col="";
            for (int i = 0; i<8; i++){
                do{
                    SI.append(rightPrevious.charAt(j));
                    j++;
                }while(j%6!=0);
                row = row.concat(String.valueOf(SI.charAt(0)));
                row = row.concat(String.valueOf(SI.charAt(5)));

                col = col.concat(String.valueOf(SI.charAt(1)));
                col = col.concat(String.valueOf(SI.charAt(2)));
                col = col.concat(String.valueOf(SI.charAt(3)));
                col = col.concat(String.valueOf(SI.charAt(4)));
                SI = new StringBuilder();
                result+=searchSbox(i,row,col);
                row="";
                col="";
            }
            return result;
        }
        String encrypt(List<StringBuilder> input, String key) {
            String CipherText = "";
            String plaintext = "";

            for(StringBuilder S : input){
                String LeftCurrent="";
                String rightCurrent="";
                String leftPrevious="";
                String rightPrevious="";

                String key1 = "";
                plaintext = permutation(S);

                final int mid = plaintext.length() / 2; //get the middle of the String
                leftPrevious = plaintext.substring(0, mid);
                rightPrevious = plaintext.substring(mid);

                // key first permutation
                key1 = PC1_key(key);
                final int key_mid = key1.length() / 2; //get the middle of the String
                String C0 = key1.substring(0, key_mid);
                String D0 = key1.substring(key_mid);

                String subKeyI = "";
                String subKeyPC = "";


                //loop on 16 rounds
                for(int round=0; round<16; round++){
                    subKeyI = shift_left(round,C0,D0);
                    subKeyPC = PC2_key(subKeyI);


                    LeftCurrent = rightPrevious;
                    rightPrevious = expansion(rightPrevious);
                    rightPrevious = XOR_48(rightPrevious,subKeyPC);

                    String sboxResult = sboxIndexGeneration(rightPrevious);
                    rightCurrent = StraightPermutation(sboxResult);

                    rightPrevious = XOR_32(rightCurrent,leftPrevious);
                    leftPrevious = LeftCurrent;


                    //get the middle of the String
                    C0 = subKeyI.substring(0, key_mid);
                    D0 = subKeyI.substring(key_mid);
                }
                String finalPerm = rightPrevious + "" + leftPrevious;
                finalPerm = finalPermutation(finalPerm);
                CipherText += finalPerm;
            }
            return CipherText;
        }
        String decrypt(List<StringBuilder> cipherText, String key){
            String cipher = "";
            String plaintext = "";
            //permutation(input , IP table)
            for(StringBuilder S : cipherText){
                String leftCurrent="";
                String rightCurrent="";
                String leftPrevious="";
                String rightPrevious="";
                String key1 = "";

                cipher = permutation(new StringBuilder(S));

                final int mid = cipher.length() / 2; //get the middle of the String
                String L0 = cipher.substring(0, mid);
                String R0 = cipher.substring(mid);

                // key first permutation
                key1 = PC1_key(key);
                final int key_mid = key1.length() / 2; //get the middle of the String
                String C16 = key1.substring(0, key_mid);
                String D16 = key1.substring(key_mid);

                String subKeyI = key1;
                String subKeyPC = "";
                leftPrevious = L0;
                rightPrevious = R0;


                //loop on 16 rounds
                for(int round=0; round<15; round++){
                    if(round==0){
                        subKeyPC = PC2_key(key1);
                    }else{
                        subKeyI = shift_right(round,C16,D16);
                        subKeyPC = PC2_key(subKeyI);
                    }
                    leftCurrent = rightPrevious;
                    rightPrevious = expansion(rightPrevious);
                    rightPrevious = XOR_48(rightPrevious,subKeyPC);

                    String sboxResult = sboxIndexGeneration(rightPrevious);
                    rightCurrent = StraightPermutation(sboxResult);

                    rightPrevious = XOR_32(rightCurrent,leftPrevious);
                    leftPrevious = leftCurrent;


                    //get the middle of the String
                    C16 = subKeyI.substring(0, key_mid);
                    D16 = subKeyI.substring(key_mid);
                }
                String finalPerm = rightPrevious + "" + leftPrevious;
                finalPerm = finalPermutation(finalPerm);
                plaintext += finalPerm;
            }
            return plaintext;
        }
    }

    public static void main(String[] args) {
        DES obj = new DES();
        System.out.println("Enter text");
        Scanner scanner = new Scanner(System.in);
        List<StringBuilder> inputt = new ArrayList<>();
        String input = scanner.nextLine();
        //convert input to binary
        inputt = obj.plainToBinary(input);
        String key = "";
        List<StringBuilder> input2 = new ArrayList<>();
        //key
        while (true) {
            System.out.println("Enter 8 character keys: ");
            key = scanner.nextLine();
            key = obj.keyToBinary(key);
            if (key.length() != 64) {
                System.out.println("Error! Insert a new key");
            }else
                break;
        }

        //encrypt
        String binaryCipher = obj.encrypt(inputt, key);
        System.out.println("Binary number of cipher: " + binaryCipher);
        String finalCipherText = DES.binToString(binaryCipher);
        System.out.println("Final Cipher: "+finalCipherText);


        // decrypt
        input2 = obj.plainToBinary(finalCipherText);
        System.out.println("Final binary text : " + input2);
        obj.decrypt(input2,key);
        String finalPlainText = DES.binToString(obj.decrypt(input2,key));
        System.out.println("Final Plain: "+ finalPlainText);

    }
}