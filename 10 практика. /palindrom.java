public class palindrom {
    public static String recursion(String word){
        if (word.length() <= 1){
            return "YES";
        }
        if (word.charAt(0) != word.charAt(word.length()- 1)){
            return "NO";
        }
        return recursion(word.substring(1, word.length()- 1));
    }
    public static void main(String[] args){
        String word = "tenet";
        String neww = recursion(word);
        System.out.println(neww);
    }
}
