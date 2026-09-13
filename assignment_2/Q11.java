package assignment_2;



class CharacterOperations {
    public static void main(String[] args) {
        char c = 'a';

        if (Character.isDigit(c))
            System.out.println(c + " " + (int)c);
        else if (Character.isLowerCase(c))
            System.out.println(Character.toUpperCase(c) + " " + (int)Character.toUpperCase(c));
        else if (Character.isUpperCase(c))
            System.out.println(Character.toLowerCase(c) + " " + (int)Character.toLowerCase(c));
        else
            System.out.println("Neither");
    }
}



