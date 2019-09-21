package Collection;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class WayOfMap implements Map {
    @Override
    public int size() {//返回映射中项的个数
        return 0;
    }

    @Override
    public boolean isEmpty() {//如果映射是空的，则返回true，否则返回false
        return false;
    }

    @Override
    public boolean containsKey(Object key) {//如果映射中包含了关键字key，则返回true，否则返回false
        return false;
    }

    @Override
    public boolean containsValue(Object value) {//如果映射中包含了值value，则返回true，否则返回false
        return false;
    }

    @Override
    public Object get(Object key) {//返回与关键字key相关联的值
        return null;
    }

    @Override
    public Object put(Object key, Object value) {//将一个键值对加入调用映射，覆盖原先与改关键字相关联的值
        return null;
    }

    @Override
    public Object remove(Object key) {//删除关键字等于key的项
        return null;
    }

    @Override
    public void putAll(Map m) {//将所有来自m的项加入映射

    }

    @Override
    public void clear() {//从映射中删除所有的关键字

    }

    @Override
    public Set keySet() {//返回一个映射中关键字的集合（Set）
        return null;
    }

    @Override
    public Collection values() {//返回一个包含了映射中的值的类集合，这个方法为映射中的值提供了一个类集合的视图
        return null;
    }

    @Override
    public Set<Entry> entrySet() {//返回映射中的项的集合（Set），为映射提供了一个集合“视图”
        return null;
    }
}
