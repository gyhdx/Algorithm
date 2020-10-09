package wf.jianzhi_offer;

/*
题目描述
把只包含质因子2、3和5的数称作丑数（Ugly Number）。
例如6、8都是丑数，但14不是，因为它包含质因子7。
习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class JZ33丑数 {

    public static void main(String[] args) {
        System.out.println(GetUglyNumber_Solution(3));
    }

    public static int GetUglyNumber_Solution(int index) {
        if (index <= 0)return 0;
        int i2 = 0,i3 = 0,i5 = 0;
        int[] ens = new int[index];
        ens[0] = 1;
        for (int i = 1; i < index; i++) {
            ens[i] = Math.min(ens[i2]*2,Math.min(ens[i3]*3,ens[i5]*5));
            if (ens[i] == ens[i2]*2)i2++;
            if (ens[i] == ens[i3]*3)i3++;
            if (ens[i] == ens[i5]*5)i5++;
        }
        return ens[index-1];
    }
}
