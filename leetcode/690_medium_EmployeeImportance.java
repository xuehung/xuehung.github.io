class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> eMap = new HashMap<>();
        for (Employee e : employees) eMap.put(e.id, e);
        return helper(eMap, id);
    }
    private int helper(Map<Integer, Employee> eMap, int id) {
        int output = eMap.get(id).importance;
        for (int sub : eMap.get(id).subordinates) {
            output += helper(eMap, eMap.get(sub).id);
        }
        return output;
    } 
}
