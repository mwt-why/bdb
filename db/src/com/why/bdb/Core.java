package com.why.bdb;

import com.why.bdb.exceptions.BdbException;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 创建终极根结和第一层类型结构
 */
public class Core {

    /**
     * 祖宗级别的根节点
     */
    private Node root;

    /**
     * 创建类型节点时，需要绑定的唯一id
     */
    private static volatile int currentTypeIndex = 0;

    /**
     * 类型和类型名字关系映射Map
     */
    private Map<Long, String> typeMap = new ConcurrentHashMap();

    /**
     * 存储所有的类型节点的名称
     */
    private List<String> nodeTypeList = new CopyOnWriteArrayList();

    /**
     * 创建根节点
     */
    public void createRoot() {
        root = new Node(null);
        root.setType(currentTypeIndex);
    }

    /**
     * 创建类型节点，次节点只是标识类型，并不存储数据
     *
     * @param typeName
     * @return
     */
    public long createTypeNode(String typeName) {
        checkTypeName(typeName);
        Node node = new Node();
        node.setName(typeName);
        node.setType(++currentTypeIndex);
        long property = root.connect(node);//因为是创建类型节点，所以没有数据
        typeMap.put(property, typeName);
        nodeTypeList.add(typeName);
        return property;
    }

    /**
     * 检查类型名字是否有效
     *
     * @param typeName
     */
    private void checkTypeName(String typeName) {
        typeName = typeName.trim();
        if (BaseUtil.isEmptyString(typeName))
            throw new BdbException("类型名称不能为空");
        if (nodeTypeList.contains(typeName))
            throw new BdbException("\"" + typeName + "\"" + "已存在");
    }

}
