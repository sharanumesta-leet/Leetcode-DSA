class ThroneInheritance {
    Map<String, List<String>> tree;
    Set<String> deaths = new HashSet<>();
    private String king;

    public ThroneInheritance(String kingName) {
        tree = new HashMap<>();
        tree.put(kingName, new ArrayList<>());
        king = kingName;
    }

    public void birth(String parentName, String childName) {
        tree.putIfAbsent(parentName, new ArrayList<>());
        tree.putIfAbsent(childName, new ArrayList<>());
        tree.get(parentName).add(childName);
    }

    public void death(String name) {
        deaths.add(name);
    }

    public void buildOrder(String successor, List<String> curOrder) {
        if (!deaths.contains(successor))
            curOrder.add(successor);
        for (String child : tree.get(successor))
            buildOrder(child, curOrder);
    }

    public List<String> getInheritanceOrder() {
        List<String> curOrder = new ArrayList<>();
        buildOrder(king, curOrder);
        return curOrder;
    }
}

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */