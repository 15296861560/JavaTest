package Collection;

import java.util.Collection;
import java.util.Iterator;

public class WayOfCollection {
    class TestClass implements Collection{

        @Override
        public int size() {//返回类集合中元素的个数
            return 0;
        }

        @Override
        public boolean isEmpty() {//如果类集合是空的，则返回true，否则返回false
            return false;
        }

        @Override
        public boolean contains(Object o) {//如果o是调用类集合的一个元素，则返回true，否则返回false
            return false;
        }

        @Override
        public Iterator iterator() {//返回类集合的迭代器
            return null;
        }

        @Override
        public Object[] toArray() {//把集合转换为数组
            return new Object[0];
        }

        @Override
        public boolean add(Object o) {//将o加入到类集合中，如果操作成功则返回true，如果操作失败则返回false
            return false;
        }

        @Override
        public boolean remove(Object o) {//删除o，若成功删除则返回true，否则返回false
            return false;
        }

        @Override
        public boolean addAll(Collection c) {//将c中的所有元素都加入到类集合中，如果操作成功，则返回true，否则返回false
            return false;
        }

        @Override
        public void clear() {//删除所有元素

        }

        @Override
        public boolean retainAll(Collection c) {//删除除包含在c中的元素之外的全部元素
            return false;
        }

        @Override
        public boolean removeAll(Collection c) {//删除c的所有元素，若成功，则返回true，否则返回false
            return false;
        }

        @Override
        public boolean containsAll(Collection c) {//如果c是调用类集合的一个子集，则返回true，否则返回false（myself）
            return false;
        }

        @Override
        public Object[] toArray(Object[] a) {//把集合转换为对象数组（myself）
            return new Object[0];
        }
    }
}
