package src;

public class TwoComplementConverter extends OneComplementConverter {

    public String binToDec(String bin) {
        if(bin.charAt(0) == '1'){
            String kq = super.binToDec(bin);
            Long decInLong = Long.parseLong(kq);
            return ("-" + Long.toString((decInLong - 1)));
        }
        return super.binToDec(bin);
    }

    @Override
    public String decToBin(long dec, int expectedLength) {
        if(dec < 0){
            return (super.decToBin((dec - 1), expectedLength));
        }
        return (super.decToBin(dec, expectedLength));
    }
}
