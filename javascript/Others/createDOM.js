/**
 * Create DOM elements.
 */
function createDOM() {
  const ele = document.getElementById('js-list');
  if (ele === undefined) {
    return;
  }

  for (let i = 0; i < 3; i++) {
    const ndList = document.createElement('li');
    ndList.innerText = (i+1).toString();
    ele.appendChild(ndList);
  }
}

// TODO: Is any other methods to get dom elements?

/**
 * Create DOM elements with event.
 */
function createDOMWithClickEvent() {
  const ele = document.getElementById('js-list');
  if (ele === undefined) {
    return;
  }

  for (let i = 0; i < 3; i++) {
    const ndList = document.createElement('li');
    ndList.innerText = (i+1).toString();
    ndList.addEventListener('click', ()=> console.log(i));
    ele.appendChild(ndList);
  }
}

// TODO: If I want to create 30000 li and every li with click event???

