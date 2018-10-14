package src;

public class OneComplementConverter extends unsignedIntConvert {
    public String reverseBit(String input){
        char[] inChar = input.toCharArray();
        for (int i = 0; i < input.length(); i++){
            inChar[i] = (char) ('1' + '0' - inChar[i]);
        }
        return new String(inChar);
    }
    @Override
    public String binToDec(String bin) {
        String kq;
        if(bin.charAt(0) == '1'){
            kq = reverseBit(bin);
            kq = super.binToDec(kq);
            kq = "-" + kq;
        } else {
            kq = super.binToDec(bin);
        }
        return kq;
    }

    public String decToBin(long dec, int expectedLength) {
        if(dec < 0){
            String kq = addLeadingZero(decToBin(0 - dec), expectedLength - 1);
            kq = "0" + kq;
            return reverseBit(kq);
        }
        String kq = addLeadingZero(decToBin(dec), expectedLength - 1);
        kq = "0" + kq;
        return kq;
    }
}
