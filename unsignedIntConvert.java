public class unsignedIntConvert
{
    /*
     * DEC to Everything
     */
    public String decToBin (long dec)
    {
        return Long.toBinaryString(dec);
    }

    public String decToOctal (long dec)
    {
        return Long.toOctalString(dec);
    }

    public String decToHex (long dec)
    {
        return "0x" + Long.toHexString(dec);
    }
    public String decToBin(long dec, int expectedLength){
        return addLeadingZero(decToBin(dec), expectedLength);
    }
    /*
     * BIN to Everything
     */
    public String binToOctal (String bin)
    {
        long binToDec = Long.parseLong(bin, 2);
        return decToOctal(binToDec);
    }

    public String binToDec (String bin)
    {
        long binToDec = Long.parseLong(bin, 2);
        return (binToDec + "");
    }

    public String binToHex (String bin)
    {
        long binToDec = Long.parseLong(bin, 2);
        return decToHex(binToDec);
    }

    /*
     * Octal to Everything
     */
    public String octalToBin (String octal)
    {
        long octalToDec = Long.parseLong(octal, 8);
        return decToBin(octalToDec);
    }

    public String octalToDec (String octal)
    {
        long octalToDec = Long.parseLong(octal, 8);
        return (octalToDec + "");
    }

    public String octalToHex(String octal)
    {
        long octalToDec = Long.parseLong(octal, 8);
        return decToHex(octalToDec);
    }

    /*
     * Hex to Everything
     */
    public String hexToBin (String hex)
    {
        hex = hex.substring(2);
        long hexToDec = Long.parseLong(hex, 16);
        return decToBin(hexToDec);
    }
    public String hexToOctal (String hex)
    {
        hex = hex.substring(2);
        long hexToDec = Long.parseLong(hex, 16);
        return decToOctal(hexToDec);
    }

    public String hexToDec (String hex)
    {
        hex = hex.substring(2);
        long hexToDec = Long.parseLong(hex, 16);
        return (hexToDec + "");
    }

    public String addLeadingZero (String input, int expectedLength) throws ArithmeticException{
        if(input.length() > expectedLength){
            throw new ArithmeticException("input's length is greater than expected length");
        }
        while (input.length() < expectedLength){
            input = "0" + input;
        }
        return  input;
    }
}
