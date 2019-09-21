![image](https://github.com/DeosChange/algorithm-study/blob/master/images/hannuo.png?raw=true)

![image](https://github.com/DeosChange/algorithm-study/blob/master/images/mytest.png?raw=true)

一、算法分析上将之提炼为三段操作：

1、前段操作： 把n-1个盘子由A 移到 B；

2、中段操作： 把第n个盘子由 A移到 C；

3、后段操作： 把n-1个盘子由B 移到 C；

二、怎么由实践实验提炼出这个思路，并转化为代码呢？

1、实践可知：

（1）完成3段操作，总步数，一定为奇数，且为2的N次方减1；

（2）前、后段的步数一定相等，且也均为奇数；

比如n=2时，前后段都需1步；n=3时，前后端均需3步；n=4时，前后端均需7步......

（3）不管n为几，前段的第一步起点必为A，最后一步的终点必为B；

区别只在于：

当n为偶数时，前段第一步必为A->B，最后一步必为A->B；（比如n=2、4、6...）
 
当n为大于1的奇数时，前段第一步必为A->C，最后一步必为C->B；（比如n=3、5、7...）

2、提炼实践的信息转化为代码指导：

不用管，前、后段中间实际真正是怎么确定的始、终点；

只需能由中段的盘子编号，推导出前后段各需的步骤总数，然后在奇数的步骤总数前提下，怎样确保必定最后能使始、终点正确；

所以这里的递归，可以由盘子编号的递减来控制递归次数，fromPanel指定后，其实不管递归多少次，都不变；只需不断替换toPanel和tempPanel的位置，但奇数次的替换，最后必定等于没有替换；

运行testHanNuo2，得到概念上实现结果：

![image](https://github.com/DeosChange/algorithm-study/blob/master/images/testResult.png?raw=true)

运行testHanNuo，得到在copyList上实现结果：

![image](https://github.com/DeosChange/algorithm-study/blob/master/images/copyList.png?raw=true)

这样copyList真是费力，仅当实践汉诺算法实验；
