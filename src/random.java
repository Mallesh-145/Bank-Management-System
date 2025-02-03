public class random {
    public static void main(String[] args) {

        int arr[] = {2,2,3};
        int n = arr.length;
        int[] dup = new int[n];
        for(int a : arr)
        {
            try {
                dup[a-1]++;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        int[] res = new int[2];
        for(int i =0;i< dup.length;i++)
        {
            if(dup[i] == 0) res[0] = i+1;
            if(dup[i] >1)
            {
                res[1] = i+1;
            }
        }
        for(int m :res)
        {
            System.out.println(m);
        }
    }
}
