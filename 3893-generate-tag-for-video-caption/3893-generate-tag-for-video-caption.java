class Solution {
    public String generateTag(String caption) {
        String[] arr = caption.split(" ");
        List<String>list = new ArrayList<>();
        for(String ss : arr){
            if(ss.length()!=0)list.add(ss);
        }
        int size=0;
        for(int i=0;i<list.size();i++){
            arr[i]=list.get(i);
            size++;
        }
        // System.out.println(Arrays.toString(arr));
        if(arr.length==0)return "#";
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        int count =1;
        arr[0]=arr[0].toLowerCase();
        if(arr[0].length()>=100){sb.append(arr[0].substring(0,99));return sb.toString();}
        else { sb.append(arr[0]); count+=arr[0].length(); }
        int idx=1;
        while(count!=100 && idx<size){
            if(arr[idx].length()==0){
                idx++;
                continue;
            }
            int n = arr[idx].length();
            if(count+n<=100){
                arr[idx]=arr[idx].toLowerCase();
                int asci = arr[idx].charAt(0);
                asci-=32;
                char []narr = arr[idx].toCharArray();
                narr[0]=(char)asci;
                arr[idx]= new String(narr);
                sb.append(arr[idx]); count+=n;
            }else{
                int diff = 100-(count);
                arr[idx]=arr[idx].substring(0,diff);
                arr[idx]=arr[idx].toLowerCase();
                int asci = arr[idx].charAt(0);
                asci-=32;
                char []narr = arr[idx].toCharArray();
                narr[0]=(char)asci;
                arr[idx]= new String(narr);
                sb.append(arr[idx]); count+=n;
            }
            idx++;
        }
        return sb.toString();
    }
}