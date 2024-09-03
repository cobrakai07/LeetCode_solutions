class Solution {
    public boolean isPossible(int[] target) {
        if (target.length == 1) return target[0] == 1;

	PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
	int sum = 0;
	for (int t: target) {
		pq.offer(t);
		sum += t;
	}

	while (pq.peek() != 1) {

        int maxEle=pq.poll();
        int remSum=sum-maxEle;
        //maxEl= remSum + element

        //edge case
        if(remSum<=0||remSum>=maxEle)return false;

        int element=maxEle%remSum;
        if(element==0){
            return remSum==1 ? true : false;
        }
        sum=remSum+element;
        pq.offer(element);

	}

	return true;
    }
}