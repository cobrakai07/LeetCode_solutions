class Twitter {
    Map<Integer, Set<Integer>> userMap;
    Map<Integer, Set<Integer>> userPostMap;
    Map<Integer, Integer> timeMap;
    int counterClock = 0;

    public Twitter() {
        userMap = new HashMap<>();
        userPostMap = new HashMap<>();
        timeMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        if (userPostMap.get(userId) == null) {
            Set<Integer> set = new HashSet<>();
            set.add(tweetId);
            userPostMap.put(userId, set);
        } else {
            Set<Integer> set = userPostMap.get(userId);
            set.add(tweetId);
            userPostMap.put(userId, set);
        }

        timeMap.put(tweetId, counterClock);
        counterClock++;
    }

    public List<Integer> getNewsFeed(int userId) {
        // System.out.println(userPostMap+" "+userId);
        // if(userMap.get(userId)==null)return new ArrayList<>();
        Set<Integer> set = userMap.get(userId);
        // if(set==null)System.out.println(set);
        List<int[]> list = new ArrayList<>();
        if (set != null) {
            Iterator<Integer> it = set.iterator();

            while (it.hasNext()) {
                int f = it.next();
                Set<Integer> setPost = userPostMap.get(f);
                if (setPost != null) {
                    Iterator<Integer> itPost = setPost.iterator();
                    while (itPost.hasNext()) {
                        int postId = itPost.next();
                        int time = timeMap.get(postId);
                        list.add(new int[] { postId, time });
                    }
                }

            }
        }

        Set<Integer> setPost = userPostMap.get(userId);

        if (setPost != null) {
            Iterator<Integer> itPost = setPost.iterator();
            while (itPost.hasNext()) {
                int postId = itPost.next();
                int time = timeMap.get(postId);
                list.add(new int[] { postId, time });
            }
        }

        Collections.sort(list, (a, b) -> b[1] - a[1]);
        List<Integer> ans = new ArrayList<>();
        int recentCounter=0;
        for (int[] x : list){
            ans.add(x[0]);
            recentCounter++;
            if(recentCounter==10)break;
        }
            
        return ans;
    }

    public void follow(int followerId, int followeeId) {
        if (userMap.get(followerId) == null) {
            Set<Integer> set = new HashSet<>();
            set.add(followeeId);
            userMap.put(followerId, set);
        } else {
            Set<Integer> set = userMap.get(followerId);
            set.add(followeeId);
            userMap.put(followerId, set);
        }
    }

    public void unfollow(int followerId, int followeeId) {
        if (userMap.get(followerId) != null && userMap.get(followerId).contains(followeeId))
            userMap.get(followerId).remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */