import java.util.*;

public class ListWithinRange {
    /**
     * Write tests for a method, and then write the method to satisfy the following:
     *
     * Given two lists of integers, check that all the elements of one list are completely within the range of the other
     * list.
     *
     * So, given the lists (5, 2, 1, 3) and the list (4, 3), the method would return true because both 4
     * and 3 are between the min and max of the first list (1 and 5)
     *
     * Also, given the lists (4, 3) and (1, 7), the method would again return true
     * because the whole first list is within the range of the second list
     *
     * Given the lists (4, 1) and (3, 7), the method would return false because 7 is not between 1 and 4
     * and 1 is not between 3 and 7.
     *
     * If either list is empty or null, the result is true.
     *
     * Given these arguments, the method would return true:
     *  (14, 355, 121, 66) and (39, 55, 355, 18, 26, 321, 1)
     *  (4922, 4922, 4922, 4922, 4922) and (4922, 4922, 4922)
     *  () and (-83)
     *
     * Given these arguments, the method would return false:
     *  (0, 2) and (1, 3)
     *  (3) and (4)
     *  (94, 22, 161, 18, 55, 230) and (56, 47, 206, 102, 12)
     *
     */

    public static void main(String[] args) {
        ListWithinRange listWithinRange = new ListWithinRange();

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(5);
        linkedList.add(2);
        linkedList.add(1);
        linkedList.add(3);

        Stack<Integer> stack = new Stack<>();
        stack.push(4);
        stack.push(3);

        boolean returnA = listWithinRange.isListWithinRange(linkedList, stack);

        System.out.println("According to the instructions, this should be true: " + returnA);

        System.out.println("According to the instructions, this should be false: " + listWithinRange.isListWithinRange(Arrays.asList(4, 1), Arrays.asList(3, 7)));

    }

    public boolean isListWithinRange(List<Integer> a, List<Integer> b) {
int aMax,aMin,bMax,bMin;
if (a.isEmpty()||b.isEmpty()){return true;}
aMax=a.stream().max(Integer::compare).get();
bMax=b.stream().max(Integer::compare).get();
aMin=a.stream().min(Integer::compare).get();
bMin=b.stream().min(Integer::compare).get();
return(aMax<=bMax&&aMin>=bMin)||(bMax<=aMax&&bMin>=aMin);
    }

}
