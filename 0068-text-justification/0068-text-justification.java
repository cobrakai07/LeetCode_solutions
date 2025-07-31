class Solution {

    // Handles justification of all lines except the last
    public String justify(StringBuilder sb, int currentWidth, int width) {
        String[] words = sb.toString().split(" ");
        int totalChars = 0;
        for (String word : words) {
            totalChars += word.length();
        }

        int totalSpaces = width - totalChars;
        int gaps = words.length - 1;

        sb = new StringBuilder();

        if (gaps == 0) {
            // Only one word, left-justify
            sb.append(words[0]);
            while (sb.length() < width) sb.append(" ");
            return sb.toString();
        }

        int baseSpace = totalSpaces / gaps;
        int extraSpaces = totalSpaces % gaps;

        for (int i = 0; i < gaps; i++) {
            sb.append(words[i]);
            // Base spaces
            for (int j = 0; j < baseSpace; j++) sb.append(" ");
            // Distribute extra spaces to leftmost gaps
            if (extraSpaces > 0) {
                sb.append(" ");
                extraSpaces--;
            }
        }

        sb.append(words[words.length - 1]); // Add last word
        return sb.toString();
    }

    // Handles the last line: left-justified
    public String justifyLastLine(StringBuilder sb, int currentWidth, int width) {
        String[] words = sb.toString().split(" ");
        sb = new StringBuilder();

        for (int i = 0; i < words.length - 1; i++) {
            sb.append(words[i]).append(" ");
        }
        sb.append(words[words.length - 1]);

        // Add spaces at the end to reach full width
        while (sb.length() < width) {
            sb.append(" ");
        }

        return sb.toString();
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int currentWidth = 0;

        for (String word : words) {
            // Check if the word fits in the current line
            if (sb.length() == 0) {
                sb.append(word);
                currentWidth = word.length();
            } else if (currentWidth + 1 + word.length() <= maxWidth) {
                sb.append(" ").append(word);
                currentWidth += 1 + word.length();
            } else {
                // Line is full, justify it and start new line
                result.add(justify(sb, currentWidth, maxWidth));
                sb = new StringBuilder(word);
                currentWidth = word.length();
            }
        }

        // Handle the last line
        result.add(justifyLastLine(sb, currentWidth, maxWidth));
        return result;
    }
}
