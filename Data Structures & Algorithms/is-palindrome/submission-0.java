class Solution {
    public boolean isPalindrome(String s) {
        String cleaned = s.replaceAll("[^A-Za-z0-9]","");
        return new StringBuilder(cleaned).reverse().toString().equalsIgnoreCase(cleaned);
    }
}
