package src;

public class signBitIntConverter extends unsignedIntConvert
{
    public String decToBin(long dec, int expectedLength) {
        String kq;
        if(dec < 0){
            kq = addLeadingZero(decToBin(0 - dec), expectedLength - 1);
            kq = '1' + kq;
        } else {
            kq = addLeadingZero(decToBin(dec), expectedLength - 1);
            kq = '0' + kq;
        }
        return kq;
    }

    @Override
    public String binToDec(String bin) {
        boolean isNegative = (bin.charAt(0) == '1');
        StringBuilder kqtoStr = new StringBuilder(bin);
        kqtoStr.replace(0, 1, "0");
        String kq = super.binToDec(bin);
        if(isNegative) kq = "-" + kqtoStr;
        return kqtoStr.toString();
    }
}
