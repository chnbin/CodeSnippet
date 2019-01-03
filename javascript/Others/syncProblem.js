/**
 *
 */
function aSyncProblem() {
  for (let i = 0; i < 5; i++) {
    start(i);
  }
}
/**
 * @param  {int} i
 */
function start(i) {
  setTimeout(()=> {
    console.log(i);
  }, 1000*i);
}
/**
 * Print 0, 1, 2, 3, 4 per second.
 */
function aSyncProblemWithPromise() {
  const tasks = [];

  const output = (i) => new Promise((resolve) => {
    setTimeout(() => {
      console.log(i);
      resolve();
    }, 1000 * i);
  });

  for (let i = 0; i < 5; i++) {
    tasks.push(output(i));
  }


  Promise.all(tasks).then(() => {
    setTimeout(() => {
      console.log('All tasks were done.');
    }, 1000);
  });
}
