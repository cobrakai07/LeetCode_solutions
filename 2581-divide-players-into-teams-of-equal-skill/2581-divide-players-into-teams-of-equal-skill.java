class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int s=0, e=skill.length-1;
        int sameSkill=skill[s]+skill[e];
        long ans=skill[s]*skill[e];
        for(int i=1, j=skill.length-2 ; i<j; i++,j--){
            if(sameSkill!= skill[i]+skill[j])return -1;
            else ans=ans+(skill[i]*skill[j]);   
        }
        return ans;
    }
}