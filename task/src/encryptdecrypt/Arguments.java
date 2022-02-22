package encryptdecrypt;

public enum Arguments {
    MODE("-mode"),
    KEY("-key"),
    ALG("-alg"),
    DATA("-data"),
    IN("-in"),
    OUT("-out");

    private String code;

    Arguments(String code){
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
