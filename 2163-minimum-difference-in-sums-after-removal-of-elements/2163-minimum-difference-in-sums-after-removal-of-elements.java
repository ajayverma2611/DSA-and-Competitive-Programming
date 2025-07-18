class Solution {
    
    public long minimumDifference(int[] nums) {

        int n=nums.length;
        long left[]=new long[n];
        long right[]= new long[n];

        PriorityQueue<Integer> minpq=new PriorityQueue<>((a,b)->b-a);
        PriorityQueue<Integer> maxpq=new PriorityQueue<>();


        long sum=0;
        int size=n/3;
        for(int i=0;i<n;i++){
            
            if(minpq.size()>=size){

                if(minpq.peek()>nums[i]){
                    int num=minpq.poll();
                    sum-=num;

                    minpq.add(nums[i]);
                    sum+=nums[i];

                }
                
            }else{
                minpq.add(nums[i]);
                sum+=nums[i];
            }

            left[i]=sum;
        }

    


        sum=0;
         for(int i=n-1;i>=0;i--){
            
            if(maxpq.size()>=size){

                if(maxpq.peek()<nums[i]){
                    int num=maxpq.poll();
                    sum-=num;

                    maxpq.add(nums[i]);
                    sum+=nums[i];

                }
                
            }else{
                maxpq.add(nums[i]);
                sum+=nums[i];
            }

            right[i]=sum;
        }


        // for(int i=0;i<n;i++){
        //     System.out.print(left[i]+" ");
        // }
        // System.out.println();

        // for(int i=0;i<n;i++){
        //     System.out.print(right[i]+" ");
        // }


      
      

        long ans=Long.MAX_VALUE;
        for(int i=size ; i<n-size+1;i++){
            ans=Math.min(ans,left[i-1]-right[i]);
        }

        return ans;
    }
}