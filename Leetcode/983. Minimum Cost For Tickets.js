/**
 * @param {number[]} days
 * @param {number[]} costs
 * @return {number}
 */
var mincostTickets = function(days, costs) {
  const totalDays = 366;

  // dayIncluded[i] = true 代表第i天要坐船，一開始初始化先設定都不坐船
  let dayIncluded = new Array(totalDays);
  dayIncluded.fill(false);
  
  // 根據題目坐船日期，設定dayIncluded
  for (let day of days) {
      dayIncluded[day] = true;
  }
  
  // minCost[i] 存放的是第i天的最小金額。一開始先初始化為0
  let minCost = new Array(totalDays);
  minCost.fill(0);

  // 第0天沒有要坐船，因此不管怎麼樣第0天一定是不花錢。
  minCost[0] = 0;
  
  for (let day = 1; day < totalDays; day++) {
      // 如果第i天不坐船，那第i天的錢其實copy第i - 1天的就好
      // 可以用days = [5, 15]來思考，因為第五天才有坐船，所以其實第1,2,3,4天應該是不用花錢的。
      // 因為第六天至第十四天不坐船，因此第六至十四天的前應該都等於第五天的，也就是2
      if (dayIncluded[day] === false) {
          minCost[day] = minCost[day - 1];
          continue;
      }

      // 第day日的票錢先以 先以第day-1的最小金額 + 單日票錢，存入minimul
      let minimul = minCost[day - 1] + costs[0];

      // 比較第day-1的最小金額 + 單日票錢 與 七天前的最小金額 + 七日票錢 誰比較小，小的存入minimul
      // 之所以Math.max(0, day - 7)是七日內的話會扣成負數，例如day = 5。
      minimul = Math.min(minimul, minCost[Math.max(0, day - 7)] + costs[1]);

      // 七天前的最小金額 + 七日票 與 三十天前的金額 + 三十日票錢 誰比較小，小的存入minimul
      // 之所以Math.max(0, day - 30)是30日內的話會扣成負數，例如day = 5。
      minimul = Math.min(minimul, minCost[Math.max(0, day - 30)] + costs[2]);

      // 目前的minimul就是第day天的最低金額，存到minCost
      minCost[day] = minimul;
  }
  return minCost[totalDays-1];
};

console.log(mincostTickets([1,4,6,7,8,20], [2,7,15]));
console.log(mincostTickets([1,2,3,4,6,7,29,30], [2,7,30]));