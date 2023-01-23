public class Program {
    public static void main(String[] args){
        
        
        int[] arr = {2,6,1,2,2,6,7,19,5};
        Set s1 = new Set(arr);
        Set s2 = new Set();

        s2.add(7);
        s2.add(2);
        s2.add(8);
        s2.add(11);
        Set s3;
        s3= s1.union(s2);
        s1.intersect(s2);
        System.out.println( s1.union(s2).subSet(s1.intersect(s2)));
        int[] b;
        b = s3.toArray();
        for (int k=0; k<b.length;k++){
            System.out.println(b[k]);
        }
    }
}
