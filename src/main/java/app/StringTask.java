package app;

public class StringTask {
    private String str;

    public StringTask() {
        str = "";
    }

    public StringTask(String str) {
        this.str = str;
    }

    public StringTask(char[] str) {
        StringBuilder stringBuilder = new StringBuilder();
        for(char c : str)
            stringBuilder.append(c);

        this.str = stringBuilder.toString();
    }


    public String getStr() {
        return str;
    }

    //For change your string
    public void setStr(String str) {
        this.str = str;
    }

    //OPeration for type changes
    private char[] stringToCharArr(String stringToArray) {

        char[] strCharArr = new char[str.length()];
        char tmp;

        for(int i = 0; i < str.length(); i++) {
            strCharArr[i] = str.charAt(i);
        }

        return strCharArr;
    }

    private String charToString(char[] charTo){
        StringBuilder stringBuilder = new StringBuilder();
        for(char c : charTo)
            stringBuilder.append(c);

        return stringBuilder.toString();
    }



    public String reverseByCharArray() {
        char tmp;
        if(str.isEmpty())
            return str;

        char[] strCharArr = stringToCharArr(str);

        for(int i = 0, j = (str.length() - 1); i <= (str.length()/2); i++, j--) {
            tmp = strCharArr[i];
            strCharArr[i] = strCharArr[j];
            strCharArr[j] = tmp;
        }

        return  charToString(strCharArr);
    }



    public String reverseByStringBuilder() {

        StringBuilder stringBuilder = new StringBuilder(str);
        stringBuilder.reverse();

        return stringBuilder.toString();
    }

    public String trimStringByStringMethod(){
        return str.trim();
    }

    public String trimStringByCharArr(){
        if(str.isEmpty())
            return str;

        char[] strCharArr = stringToCharArr(str);
        char[] tempStrCharArr;
        int tempLengthCharArr;
        int countSpace = 0;

        for(char c : strCharArr){
            if(c == ' ')
                countSpace++;
        }

        tempLengthCharArr = strCharArr.length - countSpace;
        if (tempLengthCharArr < 0)
            throw new StringIndexOutOfBoundsException(tempLengthCharArr);
        else if(tempLengthCharArr == 0)
            return "";

        if(countSpace!=0){
            tempStrCharArr = new char[tempLengthCharArr];
            for(int i = 0, j = 0; i < strCharArr.length; i++){
                if(strCharArr[i]!=' ') {
                    tempStrCharArr[j] = strCharArr[i];
                    j++;
                }
            }

            return charToString(tempStrCharArr);
        }

        return str;
    }

    public String toUpperCaseString(){
        return  str.toUpperCase();
    }

    public String sub(int start, int end) {
        String strtemp = "";
        try {
            strtemp = str.substring(start, end);
        } catch(StringIndexOutOfBoundsException ex){
            System.out.println("Неверно введены индексы");
        }

        return strtemp;
    }


    @Override
    public String toString() {
        return str;
    }
}

