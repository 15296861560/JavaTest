package Collection;

import java.util.ArrayList;

public class WayOfArrayList extends ArrayList {
    @Override
    public boolean add(Object o) {//将指定的元素追加到此列表末尾
        return super.add(o);
    }


    @Override
    public void add(int index, Object element) {//将指定的元素插入到列表的指定位置
        super.add(index, element);
    }

    @Override
    public void clear() {//移除此列表中的所有元素
        super.clear();
    }

    @Override
    public boolean contains(Object o) {//如果此列表中包含指定的元素，则返回true
        return super.contains(o);
    }

    @Override
    public Object get(int index) {//返回此列表中指定位置上的元素
        return super.get(index);
    }

    @Override
    public boolean isEmpty() {//测试此列表是否为空
        return super.isEmpty();
    }

    @Override
    public Object remove(int index) {//移除此列表中指定位置上的元素
        return super.remove(index);
    }

    @Override
    public boolean remove(Object o) {//从此列表中移除指定元素
        return super.remove(o);
    }

    @Override
    public int size() {//返回此列表的元素个数
        return super.size();
    }
}
