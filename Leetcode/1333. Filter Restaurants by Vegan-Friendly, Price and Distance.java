class Solution {
  public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
      List<Integer> res = new ArrayList<>();
      RestaurantInfo[] infos = new RestaurantInfo[restaurants.length];
      
      for (int i = 0; i < restaurants.length; i++) {
          infos[i] = new RestaurantInfo(restaurants[i][0],
                                        restaurants[i][1],
                                        restaurants[i][2],
                                        restaurants[i][3],
                                        restaurants[i][4]
                                       );
      }
      
      PriorityQueue<RestaurantInfo> pq = new PriorityQueue<>((a, b) -> {
          if (a.rating == b.rating) {
              return b.id - a.id;
          }
          return b.rating - a.rating;
      });
      
      for (RestaurantInfo info: infos) {
          if (veganFriendly == 1 && info.veganFriendly != 1) {
              continue;
          }
          
          if (info.price <= maxPrice && info.distance <= maxDistance) {
              pq.offer(info);
          }
      }
      
      while (!pq.isEmpty()) {
          res.add(pq.poll().id);
      }
      
      return res;
  }
  
}

class RestaurantInfo {
  int id;
  int rating;
  int veganFriendly;
  int price;
  int distance;
  public RestaurantInfo(int id, int rating, int veganFriendly, int price, int distance) {
      this.id = id;
      this.rating = rating;
      this.veganFriendly = veganFriendly;
      this.price = price;
      this.distance = distance;
  }
  
}
