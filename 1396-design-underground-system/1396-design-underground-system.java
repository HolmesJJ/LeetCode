class UndergroundSystem {
    
    public Map<Integer, Pair<String, Integer>> checkinMap;
    public Map<List<String>, List<Integer>> totalMap;

    public UndergroundSystem() {
        checkinMap = new HashMap<>();
        totalMap = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkinMap.put(id, new Pair<>(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> checkin = checkinMap.get(id);
        List<String> route = Arrays.asList(checkin.getKey(), stationName);
        if (!totalMap.containsKey(route)) {
            totalMap.put(route, Arrays.asList(0, 0));
        }
        List<Integer> value = totalMap.get(route);
        value.set(0, value.get(0) + t - checkin.getValue());
        value.set(1, value.get(1) + 1);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        List<String> route = Arrays.asList(startStation, endStation);
        System.out.println(startStation + ", " + endStation);
        System.out.println(totalMap.get(route));
        List<Integer> value = totalMap.get(route);
        return value.get(0) * 1.0 / value.get(1);
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */