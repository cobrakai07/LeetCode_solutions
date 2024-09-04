class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int x = 0, y = 0;
        int max = Integer.MIN_VALUE;
        char d = 'u';

        Set<String> set = new HashSet<>();
        for (int[] obstacle : obstacles) {
            set.add(obstacle[0] + " " + obstacle[1]);
        }

        for (int i : commands) {
            if (i > 0) {
                if (d == 'u') {
                    for (int ii = 1; ii <= i; ii++) {
                        if (!set.contains(x + " " + (y + 1))) {
                            y += 1;
                        } else {
                            break;
                        }
                    }
                } else if (d == 'd') {
                    for (int ii = 1; ii <= i; ii++) {
                        if (!set.contains(x + " " + (y - 1))) {
                            y -= 1;
                        } else {
                            break;
                        }
                    }
                } else if (d == 'l') {
                    for (int ii = 1; ii <= i; ii++) {
                        if (!set.contains((x - 1) + " " + y)) {
                            x -= 1;
                        } else {
                            break;
                        }
                    }
                } else {
                    for (int ii = 1; ii <= i; ii++) {
                        if (!set.contains((x + 1) + " " + y)) {
                            x += 1;
                        } else {
                            break;
                        }
                    }
                }
            } else {
                if (i == -1) {
                    if (d == 'u') {
                        d = 'r';
                    } else if (d == 'd') {
                        d = 'l';
                    } else if (d == 'l') {
                        d = 'u';
                    } else {
                        d = 'd';
                    }
                } else {
                    if (d == 'u') {
                        d = 'l';
                    } else if (d == 'd') {
                        d = 'r';
                    } else if (d == 'l') {
                        d = 'd';
                    } else {
                        d = 'u';
                    }
                }
            }

            max = Math.max(max, x * x + y * y);
        }

        return max;
    }
}
