class Pair{
    int val;
    int lab;
    int used;
    Pair(int val, int lab, int used){
        this.val =val;
        this.lab=lab;
        this.used=used;
    }
    public String toString(){
        return this.val+"|"+this.lab+" :"+this.used;
    }
}
class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        Map<Integer,Integer>mp = new HashMap<>();
        PriorityQueue<Pair>pq= new PriorityQueue<>((a,b)->Integer.compare(b.val,a.val));
        for(int i=0;i<values.length;i++){
            pq.offer(new Pair(values[i],labels[i],0));
        }
        int ans=0;
        while(!pq.isEmpty() && numWanted!=0)
        {
            // System.out.println(pq);
            Pair p=pq.poll();
            if(mp.get(p.lab)!=null && mp.get(p.lab)==useLimit)continue;
            p.used++;
            ans=ans+p.val;
            mp.put(p.lab, mp.getOrDefault(p.lab,0)+1);
            numWanted--;
        }
        return ans;
        
    }
}