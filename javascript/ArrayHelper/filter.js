// First examle
const products = [
  {name: 'black tea', type: 'tea', quantity: 0, price: 1},
  {name: 'oolong', type: 'tea', quantity: 20, price: 3},
  {name: 'latte', type: 'coffee', quantity: 15, price: 2},
  {name: 'cappuccino', type: 'coffee', quantity: 12, price: 4},
];

let productsFilter = products.filter((product) => {
  return product.type === 'tea';
});

console.log(productsFilter);

productsFilter = products.filter((product) => {
  return product.type === 'tea'
    && product.quantity > 0
    && product.price >= 0;
});

console.log(productsFilter);

// Second example
const post = [
  {id: 3, title: 'Title 1'},
];

const comments = [
  {commentId: 3, content: 'Good job'},
  {commentId: 4, content: 'great!!!'},
  {commentId: 3, content: 'master piece'},
];

/**
 * Find comments which commentid is equal to postid.
 * @param {any} post post.
 * @param {any} comments All comments.
 * @return {any} The comments which commentid is equal to postid.
 */
function commentsOfPost(post, comments) {
  return comments.filter((comment) => {
    return post.id === comment.commentId;
  });
}

const filter = commentsOfPost(post, comments);

console.log(filter);
