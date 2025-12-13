class Solution {

    public boolean validateCode(String code) {
        if (code.length() == 0)
            return false;
        for (int c : code.toCharArray()) {
            int ascii = c;
            if ((!(ascii <= 'z' && ascii >= 'a')) && (!(ascii <= 'Z' && ascii >= 'A')) && (!(c >= '0' && c <= '9'))
                    && c != '_')
                return false;
        }
        return true;
    }

    public boolean validateBusinessLine(String businessLine) {
        if (businessLine.equals("electronics") || businessLine.equals("grocery") || businessLine.equals("pharmacy")
                || businessLine.equals("restaurant"))
            return true;
        return false;
    }

    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {

        List<String> electronics = new ArrayList<>();
        List<String> grocery = new ArrayList<>();
        List<String> pharmacy = new ArrayList<>();
        List<String> restaurant = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        int n = code.length;

        for (int i = 0; i < n; i++) {
            if (validateCode(code[i]) && validateBusinessLine(businessLine[i]) && isActive[i]) {
                switch (businessLine[i]) {
                    case "electronics" -> electronics.add(code[i]);
                    case "grocery" -> grocery.add(code[i]);
                    case "pharmacy" -> pharmacy.add(code[i]);
                    case "restaurant" -> restaurant.add(code[i]);
                }
            }
        }

        Collections.sort(electronics);
        Collections.sort(grocery);
        Collections.sort(pharmacy);
        Collections.sort(restaurant);

        for(String s: electronics)
            ans.add(s);
        for(String s: grocery)
            ans.add(s);
        for(String s: pharmacy)
            ans.add(s);
        for(String s: restaurant)
            ans.add(s);

        return ans;
    }
}