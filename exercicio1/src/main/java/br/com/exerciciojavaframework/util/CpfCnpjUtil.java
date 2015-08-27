package br.com.exerciciojavaframework.util;

public class CpfCnpjUtil {

    /**
     * CNPJ digit count
     */
    public static final int CNPJ_DIGITS = 14;
    /**
     * CNPJ mask
     */
    public static final String CNPJ_MASK = "##.###.###/####-##";
    /**
     * CPF digit count
     */
    public static final int CPF_DIGITS = 11;
    /**
     * CPF mask
     */
    public static final String CPF_MASK = "###.###.###-##";

    public static boolean isValid(String cpfOrCnpj) {
        if (cpfOrCnpj == null) {
            return false;
        }
        String n = cpfOrCnpj.replaceAll("[^0-9]", "");
        boolean isCnpj = n.length() == CNPJ_DIGITS;
        boolean isCpf = n.length() == CPF_DIGITS;
        if (!isCpf && !isCnpj) {
            return false;
        }
        int i;
        int j; // just count
        int digit; // A number digit
        int coeficient; // A coeficient
        int sum; // The sum of (Digit * Coeficient)
        int[] foundDv = {0, 0}; // The found Dv1 and Dv2
        int dv1 = Integer.parseInt(String.valueOf(n.charAt(n.length() - 2)));
        int dv2 = Integer.parseInt(String.valueOf(n.charAt(n.length() - 1)));
        for (j = 0; j < 2; j++) {
            sum = 0;
            coeficient = 2;
            for (i = n.length() - 3 + j; i >= 0; i--) {
                digit = Integer.parseInt(String.valueOf(n.charAt(i)));
                sum += digit * coeficient;
                coeficient++;
                if (coeficient > 9 && isCnpj) {
                    coeficient = 2;
                }
            }
            foundDv[j] = 11 - sum % 11;
            if (foundDv[j] >= 10) {
                foundDv[j] = 0;
            }
        }
        return dv1 == foundDv[0] && dv2 == foundDv[1];
    }

    public static char getModule11Dv(String number, boolean isCpf) {
        int sum; // Sum of Multiply (Digit * Peso)
        int digit; // A number digit
        int coeficient; // A coeficient
        int dv; // Calculated Chek Digit
        // Remove literal characters
        String n = number.replaceAll("[^0-9]", "");
        // Sum Calculation
        sum = 0;
        coeficient = 2;
        for (int i = n.length() - 1; i >= 0; i--) {
            digit = Integer.parseInt(String.valueOf(n.charAt(i)));
            sum += digit * coeficient;
            coeficient++;
            if (coeficient > 9 && !isCpf) {
                coeficient = 2;
            }
        }
        // Module 11
        dv = 11 - sum % 11;
        if (dv >= 10) {
            dv = 0; // must be beetwen 0 and 9
        }
        return Integer.toString(dv).charAt(0);
    }

    /**
     * 094.* @param number A imcomplete number (CPF = 9, CNPJ = 12) 095.*
     * @return The complete number 096.
     */
    public static String completeDv(String number) {
        // Remove literal characters
        if (number != null) {
            String n = number.replaceAll("[^0-9]", "");
            boolean isCpf = n.length() == 9;
            n = n + getModule11Dv(n, isCpf);
            n = n + getModule11Dv(n, isCpf);
            return n;
        } else {
            return null;
        }
    }

    public static String extractDv(String completeNumber) {
        if (completeNumber != null) {
            String n = completeNumber.replaceAll("[^0-9]", "");
            boolean isCpf = n.length() == 9;
            return "" + getModule11Dv(completeNumber, isCpf);
        } else {
            return null;
        }

    }

    /**
     * The internal mask of CPF or CNPJ
     */
    private String mask = null;
    /**
     * Internal number
     */
    private String number = null;
    /**
     * Determines if executes auto correction on setCpfCnpj()
     */
    private boolean autoCorrection = false;

    /**
     * 128.* Simple Constructor 129.
     */
    public CpfCnpjUtil() {
        super();
    }

    /**
     * Parameter Constructor.<br>
     * 135.* CpfCnpj c = new CpfCnpj("12345678911");<br>
     * 136.* Or<br>
     * 137.* CpfCnpj c = new CpfCnpj("123.456.789-11");<br>
     * 138.* @param cpfCnpj The Cpf or Cnpj number 139.
     */
    public CpfCnpjUtil(String cpfCnpj) {
        super();
        setCpfCnpj(cpfCnpj);
    }

    /**
     * Compare the <code>toString()</code> method.
     * <P>
     * 146.* <code>return this.toString().equals(obj.toString());</code> 147.*
     * @see java.lang.Object#equals(java.lang.Object) 148.
     */
    public boolean equals(Object obj) {
        return this.toString().equals(obj.toString());
    }

    /**
     * Returns the Mask (CPF Mask or CNPJ Mask).
     * <p>
     * 154.* @return the Mask (CPF Mask or CNPJ Mask). 155.
     */
    public String getMask() {
        return mask;
    }

    /**
     * Returns the simple number, without mask.
     * <p>
     * 161.* @return the simple number, without mask.<br>
     * 162.
     */
    public String getNumber() {
        return number;
    }

    /**
     * Return the formated CPF or CNPJ.<br>
     * 168.* @return The formated CPF or CNPJ 169.
     */
    public String getCpfCnpj() {
        if (number != null) {
            if (this.isCpf()) {
                return number.replaceAll(
                        "([0-9]{3})([0-9]{3})([0-9]{3})([0-9]{2})",
                        "$1\\.$2\\.$3-$4");
            } else {
                return number.replaceAll(
                        "([0-9]{2})([0-9]{3})([0-9]{3})([0-9]{4})([0-9]{2})",
                        "$1\\.$2\\.$3/$4-$5");
            }
        } else {
            return null;
        }
    }

    /**
     * Determines if the object is a CNPJ. 180.* @return true if the object is a
     * CNPJ and 181.* False if the object is a CPF or invalid 182.
     */
    public boolean isCnpj() {
        return number != null && number.length() == CNPJ_DIGITS;
    }

    /**
     * Determines if the object is a CPF 188.* @return true if the object is a
     * CPF and 189.* False if the object is a CNPJ or invalid 190.
     */
    public boolean isCpf() {
        return number != null && number.length() == CPF_DIGITS;
    }

    /**
     * Determines if the format is valid.<br>
     * 196.* The object must be a CPF or a CNPJ. 197.* @return True - is Valid,
     * False - is Invalid 198.
     */
    public boolean isFormatValid() {
        return (isCpf() || isCnpj());// Must be CPF or CNPJ
    }

    /**
     * 204.* @see org.brazilutils.validation.Validable#isValid() 205.* @return
     * true id is valid and false if is not 206.
     */
    public boolean isValid() {
        return isValid(getNumber());
    }

    /**
     * Set the CPF or CNPJ number as String<br>
     * 212.* You can use "123.456.789-01" or "12345678901" 213.* @param cpfCnpj
     * The Cpf or Cnpj number 214.
     */
    public void setCpfCnpj(String cpfCnpj) {
        if (cpfCnpj != null) {
            number = cpfCnpj.replaceAll("[^0-9]*", "");
            if (isCpf()) {
                mask = CPF_MASK;
            } else if (isCnpj()) {
                mask = CNPJ_MASK;
            }
        } else {
            number = null;
        }
    }

    /**
     * Returns a Long represents the internal number.<br>
     * 226.* @see org.brazilutils.utilities.NumberComposed#toLong() 227.
     */
    public long toLong() {
        if (number != null && number.length() > 0) {
            return Long.parseLong(number);
        } else {
            return 0;
        }
    }

    /**
     * Returns the <code>getValue()</code> Method.<br>
     * 235.* @see java.lang.Object#toString() 236.* @see
     * org.brazilutils.utilities.NumberComposed#getCpfCnpj() 237.
     */
    public String toString() {
        return getCpfCnpj();
    }

    /**
     * Determines if executes auto correction 250.* @return 251.
     */
    public boolean isAutoCorrection() {
        return autoCorrection;
    }

    /**
     * 257.* @param autoCorrection If true executes correction 258.
     */
    public void setAutoCorrection(boolean autoCorrection) {
        this.autoCorrection = autoCorrection;
    }

    public static boolean isNotValid(Object valor) {

        return !isValid(valor.toString());

    }

}
