public class fixedRealConvert extends signedIntConvert
{
    String unsignedRealToBin (String real, String numOfBitAfterDot)
    {
        int bitsAfterDot = Integer.parseInt(numOfBitAfterDot);
        String[] parts = real.split("\\.");
        int integerPart = Integer.parseInt(parts[0]);
        int afterDot = Integer.parseInt("0" + parts[1]);

        String integerPartToBin = decToBin(integerPart);
        String afterDotToBin = "";
        int count = 1;
        while (count <= bitsAfterDot)
        {
            afterDot *= 2;
            if (afterDot < 1)
            {
                afterDotToBin += "0";
            }
            else
            {
                afterDotToBin += "1";
                afterDot -= 1;
            }
            count ++;
        }

        String result = integerPartToBin + afterDotToBin;
        return result;
    }
}