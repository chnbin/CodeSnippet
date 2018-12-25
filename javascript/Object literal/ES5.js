/**
 * Create a bookshop object by inventory
 * @param {inventory} inventory
 * @return {any}
 */
function BookShop(inventory) {
  return {
    inventory: inventory,
    inventoryValue: function() {
      return this.inventory.reduce((sum, book) => {
        return sum + book.price;
      }, 0);
    },
    queryPriceByTitle: function(title) {
      return this.inventory.find((book) => {
        return book.title === title;
      }).price;
    },
  };
}

const inventory = [
  {title: 'Lord of the rings', price: 45},
  {title: 'CS: APP', price: 75},
  {title: 'Asobiasobase', price: 25},
];

const bookshop = new BookShop(inventory);
console.log(bookshop.inventoryValue());
console.log(bookshop.queryPriceByTitle('CS: APP'));
