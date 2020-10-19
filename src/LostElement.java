import java.util.*;

public class LostElement {
    public static void findElement (){
        Scanner in = new Scanner(System.in);
        int size;

        System.out.println("Enter the size of the array");

        if(in.hasNextInt()) {
            size = in.nextInt();
        } else throw new IllegalArgumentException();
        in.close();

        if(size < 10) throw new IllegalArgumentException();

        Integer[] myArr = new Integer[size];
        int origArraySum = (myArr.length*(myArr.length+1))/2;      //sum of all elements of the original array

        for (int i = 0; i < size; i++) {
            myArr[i] = i+1;
        }

        System.out.println(Arrays.toString(myArr));

        // remove the element
        int randIndex = new Random().nextInt(myArr.length);
        List<Integer> tmpArr = new ArrayList<>(Arrays.asList(myArr));
        tmpArr.remove(randIndex);
        myArr = tmpArr.toArray(new Integer[tmpArr.size()]);

        System.out.println(Arrays.toString(myArr));

        //shuffling
        Random rnd = new Random();
        for (int j = 0; j < myArr.length; j++) {
            for (int i = 0; i < myArr.length; i++) {
                int index = rnd.nextInt(i + 1);
                int a = myArr[index];
                myArr[index] = myArr[i];
                myArr[i] = a;
            }
        }

        System.out.println(Arrays.toString(myArr));


        int curArraySum = 0;
        for (int i = 0; i < myArr.length; i++) {
            curArraySum += myArr[i];
        }
        int lostElement = origArraySum - curArraySum;
        System.out.println(lostElement);

    }


    public static void main(String[] args) {
        LostElement.findElement();
    }
}
