package src;

public class FixedBitRealNumberConverter extends OneComplementConverter {
    public String addOne(String bin){
        char[] inChar = bin.toCharArray();
        boolean add1 = true;
        for (int i = bin.length() - 1; i >= 0; i--){
            if(inChar[i] == '0'){
                inChar[i] = '1';
                add1 = false;
                break;
            }
            inChar[i] = '0';
        }
        String kq = new String(inChar);
        if(add1) kq = "1" + kq;
        return kq;
    }
    public String decToBin(double dec, int bitForNguyen, int bitForThapPhan) {
        boolean isNegative = (dec < 0);
        if(isNegative) dec = -dec;
        long phanNguyen = (long) dec;
        double phanThapPhan = dec - phanNguyen;
        String kq = decToBin(phanNguyen, bitForNguyen);
        for (int i = 0; i < bitForThapPhan; i++){
            phanThapPhan *= 2;
            long du = (long) phanThapPhan;
            phanThapPhan -= du;
            kq += du;
        }
        if(!isNegative) return kq;
        kq = reverseBit(kq);
        kq = addOne(kq);
        return kq;
        /*
        //String kq = addLeadingZero(decToBin(phanNguyen), bitForNguyen);
        String kq = new TwoComplementConverter().decToBin(phanNguyen, bitForNguyen);
        String thapPhanInString = "";

        if(dec < 0){
            thapPhanInString = reverseBit(kq);
            thapPhanInString = addOne(kq);
        }
        return kq+thapPhanInString;*/
    }
    public String subOne(String bin){
        char[] inChar = bin.toCharArray();
        for (int i = bin.length() - 1; i >= 0; i--){
            if(inChar[i] == '1'){
                inChar[i] = '0';
                break;
            }
            inChar[i] = '1';
        }
        String kq = new String(inChar);
        return kq;
    }

    public String binToDec(String bin, int bitForNguyen, int bitForTP){
        boolean isNegative = bin.charAt(0) == '1';
        if(isNegative){
            bin = subOne(bin);
            bin = reverseBit(bin);

        }
        String phanNguyen = bin.substring(0, bitForNguyen);
        String phanTP = bin.substring(bitForNguyen);
        String kq = new unsignedIntConvert().binToDec(phanNguyen);
        double dTP = 0.0, toMul = 1.0;
        int i = 0;
        while (i < phanTP.length()){
            toMul /= 2;
            if(phanTP.charAt(i) == '1'){
                dTP += toMul;
            }
            i++;
        }
        kq += ".";
        kq += Double.toString(dTP).substring(2);
        if(isNegative){
            return "-" + kq;
        }
        return kq;
        /*if(bin.charAt(0) == '1'){

        }


        kq += ".";
        phanTP = reverseBit(phanTP);

        return kq;*/
    }
}
