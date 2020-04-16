public class Exercise_18_01a {
    public static void main(String[] args) {
        System.out.println("Is moon and noon an anagram? " + isAna("moon", "noon"));
        System.out.println("Is moon and mono an anagram? " + isAna("moon", "mono"));

        System.out.println("Is moon and mono an anagram? " + isAna("school master", "the classroom"));
        System.out.println("Is moon and mono an anagram? " + isAna("niggo", "going"));

    }

    /** Made by Mools222 */
    public static boolean isAna(String s1, String s2) {
        if (s1.length() == 0 && s2.length() == 0) {
            return true;
        } else {
            char c = s1.charAt(0);
            int index = s2.indexOf(c);

            if (index != -1) {
                String s1New = s1.substring(1);
                String s2New = s2.substring(0, index) + s2.substring(index + 1);
                return isAna(s1New, s2New);
            } else
                return false;
        }
    }
}
