package main.java.Test;

import java.util.*;

/**
 * @Desc:
 * @Date: 2019/2/7 10:29  better late than never. 认真思考，不要直接就动手写
 * <p>
 * <p>
 * 链接：https://www.nowcoder.com/questionTerminal/9be0172896bd43948f8a32fb954e1be1
 * 来源：牛客网
 * <p>
 * /***********方式一、用两个优先队列来模拟两个堆---主要思路************************
 * 1.先用java集合PriorityQueue来设置一个小顶堆和大顶堆，大顶堆需要先重写一下里面的比较器
 * <p>
 * 2.主要的思想是：因为要求的是中位数，那么这两个堆，大顶堆用来存较小的数，从大到小排列；
 * 小顶堆存较大的数，从小到大的顺序排序，
 * 显然中位数就是大顶堆的根节点与小顶堆的根节点和的平均数。
 * <p>
 * 保证：小顶堆中的元素都大于等于大顶堆中的元素，所以每次塞值，并不是直接塞进去，而是从另一个堆中poll出一个最大（最小）的塞值
 * <p>
 * 3.当数目为偶数的时候，将这个值插入大顶堆中，再将大顶堆中根节点（即最大值）插入到小顶堆中；
 * 当数目为奇数的时候，将这个值插入小顶堆中，再讲小顶堆中根节点（即最小值）插入到大顶堆中；
 * <p>
 * 这样就可以保证，每次插入新值时，都保证小顶堆中值大于大顶堆中的值，并且都是有序的。
 * <p>
 * 4.由于第一个数是插入到小顶堆中的，所以在最后取中位数的时候，若是奇数，就从小顶堆中取即可。
 * 这样，当count为奇数的时候，中位数就是小顶堆的根节点；当count为偶数的时候，中位数为大顶堆和小顶堆两个根节点之和的平均数
 * <p>
 * 5.例如，传入的数据为：[5,2,3,4,1,6,7,0,8],那么按照要求，输出是"5.00 3.50 3.00 3.50 3.00 3.50 4.00 3.50 4.00 "
 * a.那么，第一个数为5，count=0,那么存到小顶堆中，
 * 步骤是：先存到大顶堆；然后弹出大顶堆root，就是最大值给小顶堆，第一次执行完，就是小顶堆为5，count+1=1；
 * 此时若要输出中位数，那么就是5.0，因为直接返回的是小顶堆最小值(第一次塞入到小顶堆中，是从大顶堆中找到最大的给他的)
 * <p>
 * <p>
 * <p>
 * b.继续传入一个数为2，那么先存到小顶堆中，将小顶堆最小值弹出给大顶堆，即2，那么这次执行完，小顶堆为5，大顶堆为2，count+1=2
 * 此时若要输出中位数，因为是偶数，那么取两个头的平均值，即(5+2)/2=3.5(第二次塞入到大顶堆中，是从小顶堆中找到最小的给他的)
 * <p>
 * c.继续传入一个数为3，那么此时count为偶数，那么执行第一个if，先存到大顶堆中，大顶堆弹出最大值，那么3>2，就是弹出3
 * 3存到小顶堆中，那么此时小顶堆为3,5，大顶堆为2，count+1=3(第三次塞入到小顶堆中，是从大顶堆中找到最大的给他的)
 * 此时若要输出中位数，因为是奇数，那么取小顶堆的最小值，即3.0
 * <p>
 * d.继续传入一个数为4，先存到小顶堆中，小顶堆此时为3,4，5,弹出最小值为3，给大顶堆
 * 此时大顶堆为3,2,小顶堆为4,5，(第四次塞入到小顶堆中，是从大顶堆中找到最大的给他的)
 * 此时若要输出中位数，因为是偶数，那么取两个头的平均值,即(3+4)/2=3.5
 * <p>
 * e.依次类推。。。
 * <p>
 * <p>
 * ******************************************
 * <p>
 * /***************方式二、ArrayList***********************
 * 用ArrayList来存输入的数据流，然后每次用Collections.sort(list)来保证数据流有序，然后再取中位数
 * 思想非常简单，但是每次都要进行排序，时间复杂度可想而知
 ****************************************/

/***************方式三、插入排序，插入到对应的位置***********************
 *     LinkedList<Integer> data = new LinkedList<Integer>();
 *     public void Insert(Integer num) {
 *         for (int i = data.size() - 1; i >= 0 ; i--) {
 *             if (num >= data.get(i)){
 *                 data.add(i+1,num);
 *                 return;
 *             }
 *         }
 *         data.addFirst(num);
 *     }
 *     ****************************************/


public class GetMedian_ {

    PriorityQueue<Integer> min = new PriorityQueue<>();
    PriorityQueue<Integer> max = new PriorityQueue<>(15, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });
    int count = 0;

    public void Insert(Integer num) {
        count++;
        if (count % 2 == 1) {
            max.offer(num);
            min.offer(max.poll());
        } else {
            min.offer(num);
            max.offer(min.poll());
        }
    }
    public Double GetMedian() {
        if (count % 2 == 0) return (min.peek() + max.peek()) / 2.0;
        else return (double) min.peek();
    }

/*
    ArrayList<Integer> result = new ArrayList<>();

    public void Insert(Integer num) {
        result.add(num);
        Collections.sort(result);
    }

    public Double GetMedian() {

        int size = result.size();
        int mid = size / 2;
        if (size == 1) return (double) result.get(0);
        if (size % 2 == 0)
            return (double) (result.get(mid) + result.get(mid + 1)) / 2;
        else return (double) result.get(mid);
    }*/
}
