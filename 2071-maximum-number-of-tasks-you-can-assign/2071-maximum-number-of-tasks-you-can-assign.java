class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        int n=tasks.length;
        int m=workers.length;
        int cnt=0;
        Arrays.sort(tasks);
        Arrays.sort(workers);
        int a=0;
        int b=n-1;
        while(a<b){
            int tmp=tasks[a];
            tasks[a]=tasks[b];
            tasks[b]=tmp;
            a++;
            b--;
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(workers[j]>=tasks[i]){
                    workers[j]=-1;
                    cnt++;
                    break;
                }else{
                    if(workers[j]!=-1 &&  pills!=0 && workers[j]+strength >= tasks[i]){
                        cnt++;
                        pills--;
                        workers[j]=-1;
                        break;
                    }
                }
            }
        }

        return cnt;
    }
}