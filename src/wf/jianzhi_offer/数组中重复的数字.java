package wf.jianzhi_offer;

public class 数组中重复的数字 {

    public static void main(String[] args) {
//        int[] numbers=new int[]{2,3,1,0,2,5,3};
        int[] numbers=new int[]{2,1,3,1,4};
        int[] duplication = new int[1];
        if (duplicate(numbers,numbers.length,duplication)) {
            System.out.println(duplication[0]);
        }else {
            System.out.println("数组中无重复值");
        }
    }

    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public static boolean duplicate(int numbers[],int length,int [] duplication) {
        int i=0;
        while (i<length){
            if (numbers[i]==i){
                i++;
            }else if (numbers[numbers[i]]!=numbers[i]){
                int n=numbers[numbers[i]];
                numbers[numbers[i]]=numbers[i];
                numbers[i]=n;
            }else {
                duplication[0]=numbers[i];
                return true;
            }
        }
        return false;
    }
}
