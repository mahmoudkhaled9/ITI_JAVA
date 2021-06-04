public class main {
    public static void main(String args[]) {
        StringUtils string1 = "BetterString";
        StringUtils string2 = "String";
        StringUtils isBetter_Length = (n, d) -> n.length() > d.length();
        if(isBetter_Length.betterString(string1, string2)) System.out.println(string1+" is better than "+string2); 
        else System.out.println(string2+" is better than "+string1); 
        
        
        Alphabet isAlphabet_ = (s)-> s.chars().allMatch(Character::isLetter);
        
        System.out.println("Test of string contains only alphabets");
        System.out.println("First Test Case Input= 'BetterString' , Output: " + isAlphabet_.isAlphabet("BetterString"));
        System.out.println("First Test Case Input= 'Better023String' , Output: " + isAlphabet_.isAlphabet("Better023String"));
        
    }
    
}