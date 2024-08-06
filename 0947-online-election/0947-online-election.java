
class TopVotedCandidate {
    Map<Integer, Integer> mp;
    int[] tCopy;

    public TopVotedCandidate(int[] persons, int[] times) {
        mp = new HashMap<>();
        tCopy = times;

        Map<Integer, Integer> voteCount = new HashMap<>();
        int leader = -1, maxVotes = 0;

        for (int i = 0; i < persons.length; i++) {
            int person = persons[i];
            voteCount.put(person, voteCount.getOrDefault(person, 0) + 1);
            
            if (voteCount.get(person) >= maxVotes) {
                if (voteCount.get(person) > maxVotes || leader != person) {
                    leader = person;
                    maxVotes = voteCount.get(person);
                }
            }
            mp.put(times[i], leader);
        }
    }

    public int q(int t) {
        int s = 0, e = tCopy.length - 1;
        int lbMax = -1;
        
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (tCopy[m] == t) {
                return mp.get(tCopy[m]);
            }
            if (tCopy[m] < t) {
                lbMax = m; // Keep track of the largest index with time less than or equal to t
                s = m + 1;
            } else {
                e = m - 1;
            }
        }
  
        
        return mp.get(tCopy[lbMax]);
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */
