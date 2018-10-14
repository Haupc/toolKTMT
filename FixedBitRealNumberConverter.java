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
        long phanNguyen = (long) dec;
        double phanThapPhan = dec - phanNguyen;
        String kq = addLeadingZero(decToBin(phanNguyen), bitForNguyen);
        for (int i = 0; i < bitForThapPhan; i++){
            phanThapPhan *= 2;
            long du = (long) phanThapPhan;
            phanThapPhan -= du;
            kq += du;
        }
        if(dec < 0){
            kq = reverseBit(kq);
            kq = addOne(kq);
        }
        return kq;
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
        if(bin.charAt(0) == '1'){
            bin = subOne(bin);
        }
        String phanNguyen = bin.substring(0, bitForNguyen);
        String phanTP = bin.substring(bitForNguyen);
        String kq = super.binToDec(phanNguyen);
        kq += ".";
        phanTP = reverseBit(phanTP);
        double dTP = 0.0, toMul = 1.0;
        int i = 0;
        while (i < phanTP.length()){
            toMul /= 2;
            if(phanTP.charAt(i) == '1'){
                dTP += toMul;
            }
            i++;
        }
        kq += Double.toString(dTP).substring(2);
        return kq;
    }
}
